package com.xpf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xpf.entity.Task;

public interface TaskDAO {
	
	List<Task> queryAllTaskByPage(@Param("begin")Integer begin,@Param("end")Integer end);
	
	Integer getTaskCount();
}
