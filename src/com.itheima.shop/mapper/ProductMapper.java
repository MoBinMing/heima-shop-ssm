package com.itheima.shop.mapper;

import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;
import com.itheima.shop.entity.Product;

public interface ProductMapper {
	@Select("select * from tab_product where pflag = 1 and is_hot = 1")
	public Page<Product> findHot();
	
	@Select("select * from tab_product where pflag = 1")
	public Page<Product> findNew();
}
