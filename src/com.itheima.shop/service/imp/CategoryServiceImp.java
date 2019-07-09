package com.itheima.shop.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.itheima.shop.entity.Category;
import com.itheima.shop.mapper.CategoryMapper;
import com.itheima.shop.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public List<Category> findAll() {
		List<Category> categories = null;
		//优先从redis拿
		// TODO Auto-generated method stub
		ValueOperations<String, String>  ops = redisTemplate.opsForValue();
		String categoriyJSON = ops.get("categories");
		if(categoriyJSON!=null) {//redis已经存在
			categories = JSON.parseArray(categoriyJSON, Category.class);
		} else {
			categories = categoryMapper.findAll();
			ops.set("categories", JSON.toJSONString(categories));
		}
		return categories;
	}

}
