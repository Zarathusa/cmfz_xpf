package com.xpf.service;

import java.util.List;

import com.xpf.entity.Album;

public interface AlbumService {

	List<Album> queryAllAlbum(Integer page,Integer rows);
	
	Integer getTotal();
	
	void insertAlbum(Album album);
	
	/*
	 * count+1
	 */
	void addCount(Integer album_id);
}
