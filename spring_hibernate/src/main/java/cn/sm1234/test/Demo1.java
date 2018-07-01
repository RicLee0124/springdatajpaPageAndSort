package cn.sm1234.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

/**
 * 演示PagingAndSortingRepository接口的使用
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {

	@Resource
	private IProductDao productDao;

	/**
	 * 分页
	 */
	@Test
	public void test1(){
		//需求：查询第 1 页，每页查询3条
		//当前页，从0开始
		int page = 0;
		int size = 3;
		Pageable pageable = new PageRequest(page,size);
		Page<Product> pageData = productDao.findAll(pageable);

		//查询的当前页数据
		List<Product> list = pageData.getContent();
		for (Product product : list) {
			System.out.println(product);
		}
		//查询总记录数
		System.out.println(pageData.getTotalElements());
		//总页数
		System.out.println(pageData.getTotalPages());
	}

	/**
	 * 排序
	 */
	@Test
	public void test2(){
		//按照ID倒序
		//一个条件
		//Sort sort = new Sort(Direction.DESC,"id");

		//多个条件
		Sort sort = new Sort(new Order(Direction.DESC,"id"),new Order(Direction.ASC,"price"));

		List<Product> list = (List<Product>)productDao.findAll(sort);
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
