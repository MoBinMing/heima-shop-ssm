package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.itheima.shop.entity.User;
import com.itheima.shop.mapper.UserMapper;
import com.itheima.shop.util.Md5Util;
import com.itheima.shop.util.UuidUtil;

public class TestUser {
	ApplicationContext ctx = null;
	UserMapper userMapper = null;
	StringRedisTemplate stringTemplate;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userMapper = ctx.getBean(UserMapper.class);
		stringTemplate = ctx.getBean(StringRedisTemplate.class);
	}
	
	@Test
	public void test1() {
		User user = new User();
		user.setUsername("zhangsan");
		user.setBirthday("2019-08-08");
		user.setEmail("zhangsan@heima.com");
		user.setName("张三");
		user.setState(0);
		user.setPassword(Md5Util.encodeByMd5("123456"));
		user.setCode(UuidUtil.getUuid());
		user.setSex("男");
		user.setTelephone("10086");
		int num = userMapper.insert(user);
		System.out.println(num);
	}
	
	@Test
	public void test2() {
		
		User user = userMapper.findByUserName("zhangsan");
		System.out.println(user);
	}
	
	@Test
	public void test3() {
		User user = userMapper.findByCode("057592f9-65b0-44a0-bd09-bc59c41c4d37");
		System.out.println(user);
	}
	
	@Test
	public void test4() {
		ValueOperations<String, String> ops= stringTemplate.opsForValue();
		String test = ops.get("test");
		System.out.println(test);
	}
	
	@Test
	public void test5() {
		ValueOperations<String, String> ops= stringTemplate.opsForValue();
		ops.set("zhongwen","莫青芳");
		System.out.println(ops.get("zhongwen"));
	}
	
	String str = "<div class=\"col-md-2\"\r\n" + 
			"					style=\"text-align: center; height: 200px; padding: 10px 0px;\">\r\n" + 
			"					<a href=\"product_info.htm\"> <img src=\"products/hao/small03.jpg\"\r\n" + 
			"						width=\"130\" height=\"130\" style=\"display: inline-block;\">\r\n" + 
			"					</a>\r\n" + 
			"					<p>\r\n" + 
			"						<a href=\"product_info.html\" style='color: #666'>冬瓜</a>\r\n" + 
			"					</p>\r\n" + 
			"					<p>\r\n" + 
			"						<font color=\"#E4393C\" style=\"font-size: 16px\">&yen;299.00</font>\r\n" + 
			"					</p>\r\n" + 
			"				</div>";
}
