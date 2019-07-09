package com.itheima.shop.service;

import com.itheima.shop.dto.UserMessage;
import com.itheima.shop.entity.User;

public interface UserService {
	public UserMessage regist(User user);
	
	public UserMessage activate(String code);
	
	public UserMessage login(String username, String password);
}
