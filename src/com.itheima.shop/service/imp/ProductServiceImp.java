package com.itheima.shop.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.shop.entity.Product;
import com.itheima.shop.mapper.ProductMapper;
import com.itheima.shop.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Page<Product> findHot() {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 9,false);
		return productMapper.findHot();
	}

	@Override
	public Page<Product> findNew() {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 9,false);
		PageHelper.orderBy("pdate desc");
		return productMapper.findNew();
	}
	

}
