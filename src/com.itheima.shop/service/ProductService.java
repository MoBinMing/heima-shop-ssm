package com.itheima.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.shop.entity.Product;

public interface ProductService {
	public Page<Product> findHot();
	
	public Page<Product> findNew();
	
	public PageInfo<Product> findByCid(Integer cid,Integer pageNum,Integer pageSize);

    public Product findByPid(int pid);
}
