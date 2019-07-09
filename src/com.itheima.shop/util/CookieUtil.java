package com.itheima.shop.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {

	private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	private CookieUtil() {

	};

	public static void showCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();// 根据请求数据，找到cookie数组
		if (null == cookies) {// 如果没有cookie数组
			logger.info("没有cookie");
		} else if (cookies.length == 0) {
			logger.info("cookie为空");
		} else {
			for (Cookie cookie : cookies) {
				logger.info("cookieName:" + cookie.getName() + ",cookieValue:" + cookie.getValue()+",cookieMaxAge:"+cookie.getMaxAge());
			}
		}
	}

	// 创建cookie，并将新cookie添加到“响应对象”response中。
	public static void addCookie(HttpServletRequest request, HttpServletResponse response,String key,String value, int timeout) {
		Cookie cookie = new Cookie(key, value);// 创建新cookie
		cookie.setMaxAge(timeout);// 设置存在时间，单位秒
		cookie.setPath(request.getContextPath());// 设置作用域
		response.addCookie(cookie);// 将cookie添加到response的cookie数组中返回给客户端
	}

	// 修改cookie，可以根据某个cookie的name修改它（不只是name要与被修改cookie一致，path、domain必须也要与被修改cookie一致）
	public static void editCookie(HttpServletRequest request, HttpServletResponse response,String key,String value,int timeout) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			System.out.println("没有cookies");
		} else {
			for (Cookie cookie : cookies) {
				// 迭代时如果发现与指定cookieName相同的cookie，就修改相关数据
				if (cookie.getName().equals(key)) {
					cookie.setValue(value);// 修改value
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(timeout);// 修改存活时间
					response.addCookie(cookie);// 将修改过的cookie存入response，替换掉旧的同名cookie
					break;
				}
			}
		}
	}
	
	//删除cookie
    public static void delCookie(HttpServletRequest request,HttpServletResponse response,String key){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie");
        } else {
            for(Cookie cookie : cookies){
                //如果找到同名cookie，就将value设置为null，将存活时间设置为0，再替换掉原cookie，这样就相当于删除了。
                if(cookie.getName().equals(key)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}
