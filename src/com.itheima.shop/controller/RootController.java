package com.itheima.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.itheima.shop.entity.Product;
import com.itheima.shop.service.CategoryService;
import com.itheima.shop.service.ProductService;

@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpServletRequest requesst;
	
	@RequestMapping("/header")
	public String header() {
		requesst.setAttribute("categories", categoryService.findAll());
		return "header";//forward
	}
	
	@RequestMapping("/index")
	public String index() {
		requesst.setAttribute("findHot",productService.findHot());
		return "index";
	}
	
	@RequestMapping("/findNew")
	@ResponseBody
	public Page<Product> findNew(){
		return productService.findNew();
	}
	
}
