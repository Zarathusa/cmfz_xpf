package com.xpf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpf.dao.ChapterDAO;
import com.xpf.entity.Chapter;
import com.xpf.service.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
	
	@Autowired
	private ChapterDAO chapterDAO;
	
	@Override
	public void saveChapter(Chapter chapter) {
		chapterDAO.add(chapter);
	}

}
