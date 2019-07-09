package com.itheima.shop.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itheima.shop.entity.User;

public interface UserMapper {
	
	/**
	 * @param user
	 * @return
	 */
	@Insert("insert into tab_user(username,`password`,`name`,email,telephone,birthday,sex,state,`code`) "
			+ "values(#{username},#{password},#{name},#{email},#{telephone},#{birthday},#{sex},#{state},#{code})")
	public int insert(User user);
	
	@Select("select * from tab_user where username = #{username}")
	public User findByUserName(String username);
	
	//通过code找用户
	@Select("select * from tab_user where code = #{code}")
	public User findByCode(String code);
	
	//通过code设置state=1
	@Update("update tab_user set state = 1 where code = #{code}")
	public int updateStateByCode(String code);
}
