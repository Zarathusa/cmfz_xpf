package com.xpf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xpf.dao.ArticleDAO;
import com.xpf.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ArticleDAOTest {

	@Autowired
	private ArticleDAO articleDAO;
	
	@Test
	public void testQueryAll(){
		List<Article> list = articleDAO.queryAllByPage(0, 5,null);
		for (Article article : list) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testGetCount(){
		Integer count = articleDAO.getArticleCount("自由");
		System.out.println(count);
	}
	
}
