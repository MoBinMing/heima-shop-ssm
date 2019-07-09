package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.shop.entity.Category;
import com.itheima.shop.mapper.CategoryMapper;

public class TestCategory {

	ApplicationContext ctx = null;
	StringRedisTemplate stringTemplate;
	CategoryMapper categoryMapper;

	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		stringTemplate = ctx.getBean(StringRedisTemplate.class);
		categoryMapper = ctx.getBean(CategoryMapper.class);
	}

	@Test
	public void test01() {
		// java对象转jsonString
		List<Category> categories = categoryMapper.findAll();
		System.out.println(categories);
		String categoriesJson = JSON.toJSONString(categories);
		System.out.println(categoriesJson);
		Category category = categories.get(0);
		String categoryJSON = JSON.toJSONString(category);
		System.out.println(categoryJSON);
	}

	@Test
	public void test02() {
		String json1 = "{\"cid\":1,\"cname\":\"手机数码\"}";
		System.out.println(json1);
		Category catetory = JSON.parseObject(json1, Category.class);
		System.out.println(catetory);

	}

	@Test
	public void test03() {
		String json2 = "[{\"cid\":1,\"cname\":\"手机数码\"},{\"cid\":2,\"cname\":\"电脑平板\"},{\"cid\":3,\"cname\":\"女士服装\"},{\"cid\":4,\"cname\":\"男士服装\"},{\"cid\":5,\"cname\":\"鞋帽箱包\"}]";
		System.out.println(json2);
		List<Category> categories1 = JSON.parseArray(json2, Category.class);
		System.out.println(categories1);
	}

	@Test
	public void test04() {
		String json2 = "[{\"cid\":1,\"cname\":\"手机数码\"},{\"cid\":2,\"cname\":\"电脑平板\"},{\"cid\":3,\"cname\":\"女士服装\"},{\"cid\":4,\"cname\":\"男士服装\"},{\"cid\":5,\"cname\":\"鞋帽箱包\"}]";
		System.out.println(json2);
		List<Category> categories1 = JSON.parseObject(json2, new TypeReference<List<Category>>() {
		});
		System.out.println(categories1);
	}
	
	@Test
	public void test05() {
		ValueOperations<String, String> ops = stringTemplate.opsForValue();
		List<Category> categories = categoryMapper.findAll();
		ops.set("categories", JSON.toJSONString(categories));
	}
	
	@Test
	public void test06() {
		ValueOperations<String, String> ops = stringTemplate.opsForValue();
		String json = ops.get("categories");
		List<Category>  categories = JSON.parseArray(json,Category.class);
		System.out.println(categories);
	}
	
	@Test
	public void test07() {
		PageHelper.startPage(2, 2,false);
		PageHelper.orderBy("cid desc");
		Page<Category> categories = categoryMapper.findAll3();
		System.out.println(categories.getPageNum());
		System.out.println(categories.getPages());
		System.out.println(categories.getTotal());
	}
	
	@Test
	public void test08() {
		List<Category> categories = categoryMapper.findAll2(2,0);
		System.out.println(categories);
	}
}
