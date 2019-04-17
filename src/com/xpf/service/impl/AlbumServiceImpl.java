package com.xpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.AlbumDAO;
import com.xpf.entity.Album;
import com.xpf.service.AlbumService;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumDAO albumDAO;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Album> queryAllAlbum(Integer page, Integer rows) {
		Integer begin=(page-1)*rows;
		Integer end=page*rows;
		return albumDAO.queryAllByPage(begin, end);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Integer getTotal() {
		return albumDAO.getCount();
	}

	@Override
	public void insertAlbum(Album album) {
		albumDAO.add(album);
	}

	@Override
	public void addCount(Integer album_id) {
		albumDAO.addCount(album_id);
	}

}
