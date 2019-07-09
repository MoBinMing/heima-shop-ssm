package com.itheima.shop.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.shop.dto.UserMessage;
import com.itheima.shop.entity.User;
import com.itheima.shop.mapper.UserMapper;
import com.itheima.shop.service.UserService;
import com.itheima.shop.util.BeanCopyUtil;
import com.itheima.shop.util.MailEyouUtil;
import com.itheima.shop.util.Md5Util;
import com.itheima.shop.util.UuidUtil;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapper userMapper;	

	@Override
	public UserMessage regist(User user) { //注册方法
		UserMessage userMsg = new UserMessage();
		BeanCopyUtil.beanCopy(user, userMsg);
		userMsg.setMsgCode(1003);
		// TODO Auto-generated method stub
		//判断username是否已经存在
		User checkUser = userMapper.findByUserName(user.getUsername());
		if(checkUser!=null) { //已经存在用户
			//返回一个已经存在用户的信息
			userMsg.setMsgCode(1002);
		} else {
			user.setState(0);
			user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
			user.setCode(UuidUtil.getUuid());
			int num = userMapper.insert(user);
			if(num>0) {
				String content = "恭喜您，注册成功，请点击<a href='http://localhost:8080/heima-shop-ssm/user/activate?code="+user.getCode()+"'>链接</a>尽快激活！";
				MailEyouUtil.sendMail(MailEyouUtil.FROM_ADMIN_EMAIL, user.getEmail(), "注册成功，请尽快激活", content);
				//返回一个插入成功信息
				userMsg.setMsgCode(1001);
			}
		}
		return userMsg;
	}

	@Override
	/*
	 * 2001 激活成功
	 * 2002 用户已激活
	 * 2003 用户不存在
	 */
	public UserMessage activate(String code) {
		// TODO Auto-generated method stub
		UserMessage userMsg = new UserMessage();
		User user = userMapper.findByCode(code);
		if(user!=null) {
			BeanCopyUtil.beanCopy(user, userMsg);
			if(user.getState()==1) { //已经激活
				userMsg.setMsgCode(2002);
			} else if(user.getState()==0) {
				int num = userMapper.updateStateByCode(code);
				if(num>0) {
					userMsg.setMsgCode(2001);
				}
			}
		} else { //用户不存在
			userMsg.setMsgCode(2003);
		}
		return userMsg;
	}

	/*
	 * 3001 登陆成功
	 * 3002 未激活
	 * 3003 用户不存在
	 * 3004 用户名或者密码错误
	 */
	@Override
	public UserMessage login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.findByUserName(username);
		UserMessage userMsg = new UserMessage();
		if(user!=null) {
			//判断是否激活
			if(user.getState()==0) {
				userMsg.setMsgCode(3002);
				return userMsg;
			}
			//检查用户名和密码
			boolean isLogin = user.getUsername().equals(username)
					&& user.getPassword().equals(Md5Util.encodeByMd5(password));
			if(isLogin==true) {
				BeanCopyUtil.beanCopy(user, userMsg);
				userMsg.setMsgCode(3001);
			} else {
				userMsg.setMsgCode(3004);
			}
		} else {
			userMsg.setUsername(username);
			userMsg.setMsgCode(3003);
		}
		return userMsg;
	}
	
}
