package com.itheima.shop.entity;

public class OrderItem {
	private int orderitemid;   //订单项id
	private int count;    //数目
	private double subtotal;   //该订单项总数
	private Product product; //商品
	private Order order;  //所属订单

	public Integer getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [orderitemid=" + orderitemid + ", count=" + count + ", subtotal=" + subtotal + ", product="
				+ product + ", order=" + order + "]";
	}
	
}
