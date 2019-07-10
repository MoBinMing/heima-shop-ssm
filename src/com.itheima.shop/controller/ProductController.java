package com.itheima.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.itheima.shop.entity.Product;
import com.itheima.shop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/findByCid")
    public String findByCid(Integer cid,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5")Integer pageSize) {
        PageInfo<Product> products = productService.findByCid(cid,pageNum,pageSize);
        request.setAttribute("products",products);
        return "product_list";
    }
}
