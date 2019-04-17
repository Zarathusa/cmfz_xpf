package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.UserDAO;
import com.xpf.entity.User;
import com.xpf.pojo.City;
import com.xpf.pojo.Month;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testQueryAll(){
		List<User> all = userDAO.queryAllByPage(0,5);
		for (User user : all) {
			System.out.println(user);
		}
	}

	@Test
	public void testCount(){
		Integer count = userDAO.getUserCount();
		System.out.println(count);
		
	}
	
	@Test
	public void testStatus(){
		userDAO.modifyStatus(1, 0);
	}
	
	@Test
	public void testQueryDateBySex(){
		Month month = userDAO.queryRegDateBySex("m");
		//System.out.println(month);
		String mon = month.toString();
		String[] strings = mon.split(",");
		Integer[] arr = new Integer[strings.length];
		for (int i = 0; i < strings.length; i++) {
			arr[i]=Integer.valueOf(strings[i]);
		}
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}
	
	@Test
	public void testQueryCityRegCountByQuarter(){
		List<City> queryCityRegCountByQuarter = userDAO.queryCityRegCountByQuarter(1);
		for (City city : queryCityRegCountByQuarter) {
			System.out.println(city);
		}
		
	}
}
