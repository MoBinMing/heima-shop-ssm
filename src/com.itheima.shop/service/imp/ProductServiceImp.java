package com.itheima.shop.service.imp;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.shop.entity.Product;
import com.itheima.shop.mapper.ProductMapper;
import com.itheima.shop.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public Page<Product> findHot() {
		Page<Product> hotProducts = null;
		// TODO Auto-generated method stub
		ValueOperations<String, String>  ops = redisTemplate.opsForValue();
		String hotProdutJson =ops.get("hotProduts");
		if(hotProdutJson!=null) {
			hotProducts  = JSON.parseObject(hotProdutJson, new TypeReference<Page<Product>>() {});
		} else {
			PageHelper.startPage(1, 9,false);
			hotProducts = productMapper.findHot();
			ops.set("hotProduts",JSON.toJSONString(hotProducts),1500L,TimeUnit.SECONDS);
		}
		return hotProducts;
	}

	@Override
	public Page<Product> findNew() {
		Page<Product> newProducts = null;
		// TODO Auto-generated method stub
		ValueOperations<String, String>  ops = redisTemplate.opsForValue();
		String newProdutJson =ops.get("newProduts");
		System.out.println("newProdutJson:"+newProdutJson);
		if(newProdutJson!=null) {
			newProducts  = JSON.parseObject(newProdutJson, new TypeReference<Page<Product>>() {});
		} else {
			PageHelper.startPage(1, 9,false);
			newProducts = productMapper.findNew();
			ops.set("newProduts",JSON.toJSONString(newProducts),3000L,TimeUnit.SECONDS);
		}
		return newProducts;
	}

	@Override
	public PageInfo<Product> findByCid(Integer cid,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize,true);
		// TODO Auto-generated method stub
		Page<Product> products= productMapper.findByCid(cid);
		return PageInfo.of(products);
	}


}