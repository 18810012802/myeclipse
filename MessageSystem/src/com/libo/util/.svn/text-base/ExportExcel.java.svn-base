package com.libo.util;

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

public class ExportExcel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����excel��ͷ����
		String[] excelHeader = { "��Դ���", "·��url", "�Ƿ���Ч"};
		//�������ϣ�����ݿ��в�ѯ������
	/*	List<Student> list = new ArrayList<Student>();  
        list.add(new Student(1000,"zhangsan","20"));  
        list.add(new Student(1001,"lisi","23"));  
        list.add(new Student(1002,"wangwu","25"));
        //����Excel����
        HSSFWorkbook wb = new HSSFWorkbook();  
        //����sheet
        HSSFSheet sheet = wb.createSheet("ѧ����Ϣ");  
        //������
        HSSFRow row = sheet.createRow((int) 0);  
        //������ʽ
        HSSFCellStyle style = wb.createCellStyle();  
        //����
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
        }  
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            Student student = list.get(i);  
            row.createCell(0).setCellValue(student.getId());  
            row.createCell(1).setCellValue(student.getName());  
            row.createCell(2).setCellValue(student.getAge());  
        }  
        //������Ӧ��Ϣ����
        response.setContentType("application/vnd.ms-excel");  
        //������Ӧ��ͷ��Ϣ
        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
        //ͨ����������ļ�������ͻ���
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  */
	}
}
