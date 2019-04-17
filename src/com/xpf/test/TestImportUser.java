package com.xpf.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;





import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

import com.xpf.entity.User;

public class TestImportUser {

	@Test
	public void testImport()throws Exception{
		//通过输入流获取到要读取得excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("D:/userInformation.xls"));
		//获取工作表
		HSSFSheet sheet = workbook.getSheet("用户信息表");
		//声明一个List集合接收user对象
		List<User> users=new ArrayList<User>();
		//遍历添加对象到集合中
		for(int i=1;i<sheet.getLastRowNum();i++){
			//获取当前遍历的行
			HSSFRow row = sheet.getRow(i);
			//声明一个对象
			User user = new User();
			//给对象的属性挨个赋值
			//user.setId(Integer.valueOf(row.getCell(0).getStringCellValue()));
			user.setPhone(row.getCell(1).getStringCellValue());
			user.setPassword(row.getCell(2).getStringCellValue());
			
			users.add(user);
		}
		
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testImportUser(){
		ImportParams params = new ImportParams();
		params.setNeedSave(true);
		params.setTitleRows(2);
		params.setHeadRows(2);
		List<User> list = ExcelImportUtil.importExcel(new File("D:/userInformation.xls"),User.class, params);
		//System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
	}
	
	@Test
	public void testImport2()throws Exception{
		ImportParams params = new ImportParams();
		params.setNeedSave(true);
        params.setTitleRows(1);
        params.setHeadRows(2);
        long start = new Date().getTime();
        List<User> list = ExcelImportUtil.importExcel(
           new File("D:/userInformation.xls"),
            User.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
	}
}
