package com.xpf.dao;

import java.util.List;

public interface BaseDAO<T> {

	List<T> queryAll();
	
	T queryOne(Integer id);
	
	void add(T t);
	
	void delete(Integer[] ids);
	
	void update(T t);
}
