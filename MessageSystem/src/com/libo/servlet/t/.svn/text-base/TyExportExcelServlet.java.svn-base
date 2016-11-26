package com.libo.servlet.t;

import java.io.IOException;
import java.io.OutputStream;
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

import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.lichao.InfoService;

public class TyExportExcelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//创建excel表头部分
		String[] excelHeader = { "刊物名称","期号", "内容", "上报截止时间","发布时间","发布人"};
		//创建集合（从数据库中查询出来）
		Msg_ManuscriptsService msgd=new Msg_ManuscriptsServiceImpl();
		List<Msg_manuscripts> list = msgd.selectAllByNam(0, 0, null, null);
        //创建Excel对象
        HSSFWorkbook wb = new HSSFWorkbook();  
        //创建sheet
        HSSFSheet sheet = wb.createSheet("约稿信息");  
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
            Msg_manuscripts msg = list.get(i);  
            row.createCell(0).setCellValue(msg.getName());  
            row.createCell(1).setCellValue(msg.getNumber());  
            row.createCell(2).setCellValue(msg.getContent());
            row.createCell(4).setCellValue(msg.getEndDate());
            row.createCell(5).setCellValue(msg.getCreateDate());  
            row.createCell(6).setCellValue(msg.getEndDate());   
        }  
        //设置响应信息类型
        response.setContentType("application/vnd.ms-excel");  
        //设置响应的头信息
        response.setHeader("Content-disposition", "attachment;filename=issuemanuscript.xls");  
        //通过输出流将文件输出到客户端
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  
	}

}
