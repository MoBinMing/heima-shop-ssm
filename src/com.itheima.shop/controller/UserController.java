package com.itheima.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.shop.dto.UserMessage;
import com.itheima.shop.entity.User;
import com.itheima.shop.service.UserService;
import com.itheima.shop.util.CookieUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/regist")
	public String regist(User user) {
		UserMessage userMsg = userService.regist(user);
		request.setAttribute("userMsg", userMsg);
		return "message";
	}
	
	@RequestMapping("/activate")
	public String activate(String code) {
		UserMessage userMsg = userService.activate(code);
		request.setAttribute("userMsg", userMsg);
		return "message";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,@RequestParam(defaultValue = "false")Boolean auto,
			boolean remember) {
		UserMessage userMsg = userService.login(username, password);
		if(userMsg.getMsgCode()==3001) {
			HttpSession session = request.getSession(true);
			System.out.println("sessionId:"+session.getId());
			session.setAttribute("USER", userMsg);
			/*
			 * 1、  登陆勾选记住登录，传参记为auto

				2、  UserController获得auto参数，执行正常的登陆逻辑
				
				3、  若登陆成功且auto为true,设置cookie修改JSESSIONID和记录auto为true的cookie
				
				4、  若登陆失败且auto为false，则清理掉auto为true的cookie
			 */
			if(auto==true) {
				CookieUtil.editCookie(request, response, "JSESSIONID",session.getId(), 60*60*24);
				CookieUtil.addCookie(request, response, "auto", auto.toString(), 60*60*24);
				session.setMaxInactiveInterval(60*60*24);
			} else {
				CookieUtil.delCookie(request, response, "auto");
				CookieUtil.editCookie(request, response, "JSESSIONID",session.getId(),-1);
			}
			
			if(remember==true) {
				//如果remember是true的情况下，调用CooieUtil.addCookie的key为remember,username，还有一个key是username
				CookieUtil.addCookie(request, response, "remember", remember+"", 60*60*24*3);
				CookieUtil.addCookie(request, response, "username", username, 60*60*24*3);
				CookieUtil.addCookie(request, response, "password", password, 60*60*24*3);
			} else {
				CookieUtil.delCookie(request, response, "remember");
				CookieUtil.delCookie(request, response, "username");
				CookieUtil.delCookie(request, response, "password");
			}
			
		}
		request.setAttribute("userMsg", userMsg);
		return "message";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		HttpSession session =  request.getSession();
		session.invalidate();
		session = null;
		request.setAttribute("message", "退出登陆成功");
		return "message";
	}
}
