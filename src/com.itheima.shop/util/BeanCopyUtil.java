package com.itheima.shop.util;

import org.springframework.beans.BeanUtils;

public class BeanCopyUtil {
	public static void beanCopy(Object from, Object to) {
		if(from!=null && to != null) {
			BeanUtils.copyProperties(from, to);
		}
	}
}
