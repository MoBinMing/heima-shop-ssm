package com.itheima.shop.util;

import java.util.UUID;

/**
 * 产生随机唯一字符串工具类
 */
public final class UuidUtil {

	/**
	 * 不允许new出工具类
	 */
	private UuidUtil(){}

	/**
	 * 产生随机唯一字符串
	 */
	public static String getUuid(){
		return UUID.randomUUID().toString();
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
	}
	
}
