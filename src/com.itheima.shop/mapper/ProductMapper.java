package com.itheima.shop.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.github.pagehelper.Page;
import com.itheima.shop.entity.Product;

public interface ProductMapper {
	@Select("select * from tab_product where pflag = 1 and is_hot = 1")
	public Page<Product> findHot();
	
	@Select("select * from tab_product where pflag = 1")
	public Page<Product> findNew();
	
	@Select("select * from tab_product where pflag = 1 and cid = #{cid}")
	public Page<Product> findByCid(Integer cid);
	
	//方法1:用数据库join的方式去实现1对1的关系
	@Select("select * from tab_product join tab_category on tab_product.cid = tab_category.cid where pflag = 1 and pid = #{pid}")
	@Results(
				{
					@Result(column = "cid",property = "category.cid"),
					@Result(column = "cname",property = "category.cname")
				}
			)
	public Product findByPid(Integer pid);
	
	//方法2:这是用@One注解来获取
	@Select("select * from tab_product where pflag = 1 and pid = #{pid}")
	@Results({
		@Result(column = "cid",property = "category",one = @One(select = "com.itheima.shop.mapper.CategoryMapper.findByCid",fetchType = FetchType.LAZY))
	})
	public Product findByPid2(Integer pid);
}
