package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.MenuDAO;
import com.xpf.entity.Menu;
import com.xpf.service.MenuService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDAO menuDAO;
	
	
	@Override
	public List<Menu> queryAllMenu() {
		List<Menu> menus = menuDAO.queryAll();
		return menus;
	}

}
