package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.ArticleDAO;
import com.xpf.entity.Article;
import com.xpf.service.ArticleService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public List<Article> queryAllArticleByPage(Integer page, Integer rows,String like) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
   		return articleDAO.queryAllByPage(begin, end,like);
	}

	@Override
	public Integer getTotal(String like) {
		return articleDAO.getArticleCount(like);
	}

	
}
