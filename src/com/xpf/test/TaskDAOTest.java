package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.TaskDAO;
import com.xpf.entity.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TaskDAOTest {

	@Autowired
	private TaskDAO taskDAO;
	
	@Test
	public void testQueryAll(){
		List<Task> list = taskDAO.queryAllTaskByPage(0, 2);
		for (Task task : list) {
			System.out.println(task);
		}
	}
	
	@Test
	public void testGetCount(){
		Integer count = taskDAO.getTaskCount();
		System.out.println(count);
		
	}
}
