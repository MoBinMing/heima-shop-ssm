package com.itheima.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;
import com.itheima.shop.entity.Category;

public interface CategoryMapper {
	@Select("select * from tab_category order by cid asc")
	public Page<Category> findAll();
	
	@Select("select * from tab_category")
	public Page<Category> findAll3();
	
	@Select("select * from tab_category order by cid asc")
	public List<Category> findAll2(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
}
