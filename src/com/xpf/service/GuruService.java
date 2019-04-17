package com.xpf.service;

import java.util.List;

import com.xpf.entity.Guru;

public interface GuruService {

	List<Guru> queryGuruByPage(Integer page,Integer rows);
	
	Integer getTotalGuru();
	
	Integer modifyStatus(Integer id,Integer status);
}
