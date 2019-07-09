package com.itheima.shop.entity;

import java.util.Date;

public class Order {
	private int oid;   //订单id
	private Date ordertime;  //订单时间
	private double total;   //订单总价
	private int state;   //订单状态 0表示购物车状态，1表示已提交状态
	private String address;  //地址
	private String name;   //名字
	private String telephone;   //电话
	private User user;  //创建用户

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", address="
				+ address + ", name=" + name + ", telephone=" + telephone + "]";
	}

}
