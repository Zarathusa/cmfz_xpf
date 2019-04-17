package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.GuruDAO;
import com.xpf.entity.Guru;
import com.xpf.service.GuruService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class GuruServiceImpl implements GuruService{

	@Autowired
	private GuruDAO guruDAO;
	
	@Override
	public List<Guru> queryGuruByPage(Integer page, Integer rows) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
		return guruDAO.queryAllByPage(begin, end);
	}

	@Override
	public Integer getTotalGuru() {
		return guruDAO.countGuru();
	}

	@Override
	public Integer modifyStatus(Integer id, Integer status) {
		return guruDAO.updateStatus(id, status);
	}

}
