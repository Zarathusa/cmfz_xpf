package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.MenuDAO;
import com.xpf.entity.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MenuDAOTest {

	@Autowired
	private MenuDAO menuDAO;
	
	@Test
	public void testMenu(){
		List<Menu> all = menuDAO.queryAll();
		for (Menu menu : all) {
			System.out.println(menu);
			
		}
	}
}
