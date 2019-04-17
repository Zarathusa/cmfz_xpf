package com.xpf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.AdminDAO;
import com.xpf.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminDAOTest {

	@Autowired
	private AdminDAO adminDAO;
	
	@Test
	public void testLogin(){
		Admin admin = adminDAO.queryByUsernameAndPassword("xpf", "123456");
		System.out.println(admin);
	}
	
	@Test
	public void testModify(){
		Integer i = adminDAO.modifyPassword(1, "654321", "123456");
		System.out.println(i);
	}
}
