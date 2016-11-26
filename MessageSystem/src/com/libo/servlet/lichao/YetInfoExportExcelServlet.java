package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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

import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.lichao.YetInfoServiecImpl;
import com.libo.service.lichao.InfoService;
import com.libo.service.lichao.YetInfoService;

public class YetInfoExportExcelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����excel��ͷ����
		String[] excelHeader = { "���ID","�ں�", "��������", "Լ����Ϣ","Լ�巢��ʱ��","Լ���ֹʱ��","Լ��״̬"};
		//�������ϣ������ݿ��в�ѯ������
		YetInfoService info=new YetInfoServiecImpl();
		int id=0;
		List<Msg_manuscripts> list = info.selectYetInfoByExcel(id) ;
        //����Excel����
        HSSFWorkbook wb = new HSSFWorkbook();  
        //����sheet
        HSSFSheet sheet = wb.createSheet("����Լ����Ϣ");  
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
            Msg_manuscripts msg = list.get(i);  
            row.createCell(0).setCellValue(msg.getId());  
            row.createCell(1).setCellValue(msg.getNumber());  
            row.createCell(2).setCellValue(msg.getName());
            row.createCell(4).setCellValue(msg.getContent());
            row.createCell(5).setCellValue(msg.getCreateDate());  
            row.createCell(6).setCellValue(msg.getEndDate());  
            row.createCell(7).setCellValue(msg.getState());  
        }  
        //������Ӧ��Ϣ����
        response.setContentType("application/vnd.ms-excel");  
        //������Ӧ��ͷ��Ϣ
        response.setHeader("Content-disposition", "attachment;filename=yetmanuscript.xls");  
        //ͨ����������ļ�������ͻ���
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  
	}
		
	}


