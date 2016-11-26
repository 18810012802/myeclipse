package com.libo.servlet.mc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.libo.entity.Sys_menu;
import com.libo.service.impl.mc.menuByidServiceImpl;
import com.libo.service.mc.menuByidService;


public class daoChuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String idstr=request.getParameter("id");
		String [] id=idstr.split(",");
		
		//创建excel表头部分
		String[] excelHeader = { "资源名称", "路径url", "是否有效"};
		//创建集合（从数据库中查询出来）
		menuByidService byidService=new menuByidServiceImpl();
		List<Sys_menu> list=new ArrayList<Sys_menu>();
		for(int i=0;i<id.length;i++){
		Sys_menu menu=byidService.selectMenu(Integer.parseInt(id[i]));
			list.add(menu);
		}
        //创建Excel对象
        HSSFWorkbook wb = new HSSFWorkbook();  
        //创建sheet
        HSSFSheet sheet = wb.createSheet("学生信息");  
        //创建行
        HSSFRow row = sheet.createRow((int) 0);  
        //创建样式
        HSSFCellStyle style = wb.createCellStyle();  
        //居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
        }  
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            Sys_menu sys_menu = list.get(i);  
            row.createCell(0).setCellValue(sys_menu.getMenuName());  
            row.createCell(1).setCellValue(sys_menu.getUrl());  
            row.createCell(2).setCellValue(sys_menu.getState());  
        }  
        //设置响应信息类型
        response.setContentType("application/vnd.ms-excel");  
        //设置响应的头信息
        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
        //通过输出流将文件输出到客户端
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  
	
	}

}
