package com.libo.servlet.fan;

import java.io.IOException;
import java.io.OutputStream;
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

import com.lib.service.t.Org_employeeService;
import com.libo.dao.fan.Org_RoleDao_fan;
import com.libo.dao.impl.fan.Org_RoleDaoImpl_fan;
import com.libo.entity.Org_employee;
import com.libo.entity.Org_role;
import com.libo.service.fan.Org_EmployeeService_fan;
import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;
import com.libo.service.impl.t.Org_employeeServiceImpl;

public class daoChu_fan extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("type");
		if(type!=null){
			daoChu1(request,response);
		}else{
			daoChu(request,response);
		}
	}
	public void daoChu1(HttpServletRequest request, HttpServletResponse response){
		String ids=request.getParameter("id");
		String [] id=ids.split(",");
		//创建excel表头部分
				String[] excelHeader = { "用户账户", "真实姓名", "角色"};
				//创建集合（从数据库中查询出来）
				List<Org_employee> list = new ArrayList<Org_employee>();  
				Org_EmployeeService_fan fan=new Org_EmployeeServiceImpl_fan();
				Org_RoleDao_fan o=new Org_RoleDaoImpl_fan();
				for(int i=0;i<id.length;i++){
					Org_employee e=fan.seleByid(Integer.parseInt(id[i]));
					list.add(e);
				}
		        //创建Excel对象
		        HSSFWorkbook wb = new HSSFWorkbook();  
		        //创建sheet
		        HSSFSheet sheet = wb.createSheet("用户");  
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
		            Org_employee e= list.get(i);  
		            row.createCell(0).setCellValue(e.getLoginname());  
		            row.createCell(1).setCellValue(e.getUsername());  
		            row.createCell(2).setCellValue(o.getRoleByid(e.getRoleid()).getRoleName());  
		        }  
		        //设置响应信息类型
		        response.setContentType("application/vnd.ms-excel");  
		        //设置响应的头信息
		        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
		        //通过输出流将文件输出到客户端
		        try {
					OutputStream ouputStream = response.getOutputStream();  
					wb.write(ouputStream);  
					ouputStream.flush();  
					ouputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	}
	public void daoChu(HttpServletRequest request, HttpServletResponse response){
		String ids=request.getParameter("id");
		String [] id=ids.split(",");
		//创建excel表头部分
				String[] excelHeader = { "角色名称", "状态"};
				//创建集合（从数据库中查询出来）
				List<Org_role> list = new ArrayList<Org_role>();  
				Org_RoleDao_fan o=new Org_RoleDaoImpl_fan();
				for(int i=0;i<id.length;i++){
					Org_role or=o.getRoleByid(Integer.parseInt(id[i]));
					list.add(or);
				}
		        //创建Excel对象
		        HSSFWorkbook wb = new HSSFWorkbook();  
		        //创建sheet
		        HSSFSheet sheet = wb.createSheet("角色");  
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
		            Org_role or= list.get(i);  
		            row.createCell(0).setCellValue(or.getRoleName());  
		            row.createCell(1).setCellValue(or.getState());    
		        }  
		        //设置响应信息类型
		        response.setContentType("application/vnd.ms-excel");  
		        //设置响应的头信息
		        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
		        //通过输出流将文件输出到客户端
		        try {
					OutputStream ouputStream = response.getOutputStream();  
					wb.write(ouputStream);  
					ouputStream.flush();  
					ouputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	}
}
