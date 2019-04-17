package com.xpf.service;

import java.util.List;

import com.xpf.entity.Article;

public interface ArticleService {

	/*
	 * 分页展示
	 */
	List<Article> queryAllArticleByPage(Integer page,Integer rows,String like);
	
	Integer getTotal(String like);
}
