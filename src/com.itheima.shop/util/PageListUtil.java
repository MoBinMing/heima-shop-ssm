package com.itheima.shop.util;

import java.util.ArrayList;
import java.util.List;

public class PageListUtil {

	/**
	 * @param pageNum 当前第几页
	 * @param pages   总共有多少页
	 * @param pageLen 分页的数字清单显示多少个分页项
	 * @return
	 */
	public static List<Integer> pageList(int pageNum, int pages, int pageLen) {
		// pageLen 6 leftLen:3 rightLen:3 如当前页是5
		// 排除掉自己
		pageLen -= 1;
		int leftLen = pageLen / 2;
		int rightLen = pageLen - leftLen;
		int beginNum = pageNum - leftLen; // 5-3=2
		int endNum = pageNum + rightLen;
		System.out.println(beginNum + "," + endNum);
		if(beginNum<1) {
			int leftOffSet = 1 - beginNum;
			beginNum = 1;
			endNum += leftOffSet; // 5+3=8
		} else if(endNum>pages) {
			int rightOffset = endNum-pages;  // 18+3>20
			beginNum -=rightOffset;
		}
		beginNum = beginNum<1? 1:beginNum;
		endNum = endNum>pages? pages:endNum;
		
		System.out.println(beginNum + "," + endNum);
		List<Integer> pageList = new ArrayList<>();
		for (int i = beginNum; i <= endNum; i++) {
			pageList.add(i);
		}
		
		return pageList;
	}

	public static void main(String[] args) {
		List<Integer> list = pageList(7, 20, 7);
		System.out.println(list);
	}
}
