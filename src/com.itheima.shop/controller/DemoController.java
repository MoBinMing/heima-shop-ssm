package com.itheima.shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class DemoController {
	private final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("jsp")
	public String jspDemo() {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		request.setAttribute("list", list);
		logger.info(list.toString());
		return "demo";
	}
	
	@RequestMapping("html")
	@ResponseBody
	public List<Integer> htmlDemo() {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		logger.info(list.toString());
		return list;
	}
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/images/{name}") //restful 风格
	@ResponseBody
	public void image(@PathVariable("name")String name) {
		byte[] data = null;
		System.out.println(name);
		try {
			data = Files.readAllBytes(Paths.get("/imgas/"+name+".jpg"));
			response.getOutputStream().write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
