package com.itheima.shop.service;

import com.github.pagehelper.Page;
import com.itheima.shop.entity.Product;

public interface ProductService {
	public Page<Product> findHot();
	
	public Page<Product> findNew();
}
