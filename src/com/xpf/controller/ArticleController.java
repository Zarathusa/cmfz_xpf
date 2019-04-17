package com.xpf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpf.entity.Article;
import com.xpf.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("showAll")
	public Map<String,Object> showAllArticle(Integer page,Integer rows,String like){
		map.clear();
		try {
			List<Article> list = articleService.queryAllArticleByPage(page, rows,like);
			Integer total = articleService.getTotal(like);
			map.put("total", total);
			map.put("rows",list);
			map.put("success", 200);
			map.put("message", "查询文章成功！");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 400);
			map.put("message", "查询文章失败！");
		}
		return map;
	}
}
