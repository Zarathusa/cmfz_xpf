package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Article;

public interface ArticleDAO extends BaseDAO<Article>{
	
	List<Article> queryAllByPage(@Param("begin")Integer begin,@Param("end")Integer end,@Param("likes")String likes);
	
	Integer getArticleCount(@Param("likes")String likes);
	/*
	 * 前端接口的文章展示
	 */
	List<Article> queryAllByGuruId(@Param("guru_id")Integer guru_id);
}
