package com.itheima.shop.entity;

import java.io.Serializable;

/**
 * 类别
 */
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cid;//类别主键
	private String cname;//类别名
	public Category(){}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}