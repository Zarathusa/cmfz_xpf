package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.AlbumDAO;
import com.xpf.entity.Album;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlbumDAOTest {

	@Autowired
	private AlbumDAO albumDAO;
	
	@Test
	public void testQueryAll(){
		List<Album> list = albumDAO.queryAllByPage(0, 5);
		for (Album album : list) {
			System.out.println(album);
		}
	}
	
	@Test
	public void testAdd(){
		Album album = new Album(null,"1",5.0,"11","11","111",null,"1111",null,null);
		albumDAO.add(album);
	}
	
	@Test
	public void testAddCount(){
		albumDAO.addCount(1);
		
	}
	
}
