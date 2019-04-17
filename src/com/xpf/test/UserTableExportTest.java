package com.xpf.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.xpf.dao.UserDAO;
import com.xpf.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTableExportTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testExportUser()throws Exception{
		List<User> users = userDAO.queryAll();
		List<User> userss=new ArrayList<User>();
		for (User user : users) {
			user.setHead_img("WebRoot"+user.getHead_img());
			userss.add(user);
		}
		//参数：标题，表名，实体类类对象，导出的集合
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲用户信息表","用户信息表"),User.class, userss);

		workbook.write(new FileOutputStream(new File("D:/userInformation.xls")));
		workbook.close();
	}
	
	
}
