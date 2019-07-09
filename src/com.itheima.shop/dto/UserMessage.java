package com.itheima.shop.dto;

import com.itheima.shop.entity.User;

public class UserMessage extends User{

	private static final long serialVersionUID = 1L;
	/*
	 * 1001 注册成功
	 * 1002 注册用户已存在
	 * 1003 异常
	 */
	private Integer msgCode;

	public Integer getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(Integer msgCode) {
		this.msgCode = msgCode;
	}
	
	
}
