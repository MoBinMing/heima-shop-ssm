package com.itheima.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.itheima.shop.entity.Product;
import com.itheima.shop.service.ProductService;
import com.itheima.shop.util.PageListUtil;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/findByCid")
	public String findByCid(Integer cid,
			@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "2") Integer pageSize) {
		PageInfo<Product> products = productService.findByCid(cid, pageNum, pageSize);
		request.setAttribute("products", products);
		List<Integer> pageList = PageListUtil.pageList(products.getPageNum(), products.getPages(), 5);
		request.setAttribute("pageList", pageList);
		return "product_list";
	}
	
	@RequestMapping("/findByPid")
	public String findByPid(Integer pid) {
		Product product = productService.findByPid(pid);
		request.setAttribute("product", product);
		return "forward:/product_info.jsp?cid="+product.getCategory().getCid();
	}
}
