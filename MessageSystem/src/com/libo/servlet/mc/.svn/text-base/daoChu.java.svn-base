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

import com.lib.dao.impl.t.Msg_ManuscriptsDaoimpl;
import com.lib.dao.impl.t.Msg_fileDaoImpl;
import com.lib.dao.t.Msg_ManuscriptsDao;
import com.lib.dao.t.Msg_fileDao;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;


public class daoChu extends HttpServlet {
		
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
		if(type.equals("1")){
			daoChu1(request,response);
		}else if(type.equals("2")){
			daoChu2(request,response);
		}else if(type.equals("3")){
			daoChu3(request,response);
		}else{
			daoChu4(request,response);
		}
	}
	public void daoChu1(HttpServletRequest request, HttpServletResponse response){
				String idstr=request.getParameter("id");
				System.out.println("1561616"+idstr);
				String [] id=idstr.split(",");
				String[] excelHeader = { "刊物名称", "期号", "内容","上报截止时间","发布时间","发布人"};
				Msg_ManuscriptsDao dao=new Msg_ManuscriptsDaoimpl();
				List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
				for(int i=0;i<id.length;i++){
					Msg_manuscripts m =dao.selectAllByMdid(Integer.parseInt(id[i]));
					list.add(m);
				}
		        HSSFWorkbook wb = new HSSFWorkbook();  
		        HSSFSheet sheet = wb.createSheet("约稿信息");  
		        HSSFRow row = sheet.createRow((int) 0);  
		        HSSFCellStyle style = wb.createCellStyle();  
		        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		        for (int i = 0; i < excelHeader.length; i++) {  
		            HSSFCell cell = row.createCell(i);  
		            cell.setCellValue(excelHeader[i]);  
		            cell.setCellStyle(style);  
		            sheet.autoSizeColumn(i);  
		        }  
		  
		        for (int i = 0; i < list.size(); i++) {  
		            row = sheet.createRow(i + 1);  
		            Msg_manuscripts m= list.get(i);  
		            row.createCell(0).setCellValue(m.getName());  
		            row.createCell(1).setCellValue(m.getNumber());  
		            row.createCell(2).setCellValue(m.getContent());
		            row.createCell(3).setCellValue(m.getEndDate().toString()); 
		            row.createCell(4).setCellValue(m.getCreateDate().toString()); 
		            row.createCell(5).setCellValue(m.getSendUserId()); 
		        }  
		        response.setContentType("application/vnd.ms-excel");  
		        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
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
	public void daoChu2(HttpServletRequest request, HttpServletResponse response){
		String idstr=request.getParameter("id");
		String [] id=idstr.split(",");
		String[] excelHeader = {"刊物期号", "刊物名", "约稿信息","约稿发布时间","约稿截止时间"};
		Msg_ManuscriptsDao dao=new Msg_ManuscriptsDaoimpl();
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		for(int i=0;i<id.length;i++){
			Msg_manuscripts m =dao.selectAllByMdid(Integer.parseInt(id[i]));
			list.add(m);
		}
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("约稿信息");  
        HSSFRow row = sheet.createRow((int) 0);  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
        }  
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            Msg_manuscripts m= list.get(i);  
            row.createCell(0).setCellValue(m.getNumber());  
            row.createCell(1).setCellValue(m.getName());  
            row.createCell(2).setCellValue(m.getContent());
            row.createCell(3).setCellValue(m.getCreateDate().toString()); 
            row.createCell(4).setCellValue(m.getEndDate().toString());  
        }  
        response.setContentType("application/vnd.ms-excel");  
        response.setHeader("Content-disposition", "attachment;filename=student.xls");  
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
        public void daoChu3(HttpServletRequest request, HttpServletResponse response){
        	String idstr=request.getParameter("id");
    		String [] id=idstr.split(",");
    		String[] excelHeader = {"文件标题", "作者", "类型","文体","上传时间","刊物名称","期号","审核状态"};
    		Msg_fileDao dao=new Msg_fileDaoImpl();
    		Msg_ManuscriptsDao mdao=new Msg_ManuscriptsDaoimpl();
    		List<Msg_file> list=new ArrayList<Msg_file>();
    		List<Msg_manuscripts> listm=new ArrayList<Msg_manuscripts>();
    		for(int i=0;i<id.length;i++){
    			Msg_file m =dao.selectAllByfid((Integer.parseInt(id[i])));
    			Msg_manuscripts ma=mdao.selectAllByMdid(m.getMaId());
    			listm.add(ma);
    			list.add(m);
    		}
            HSSFWorkbook wb = new HSSFWorkbook();  
            HSSFSheet sheet = wb.createSheet("约稿信息");  
            HSSFRow row = sheet.createRow((int) 0);  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            for (int i = 0; i < excelHeader.length; i++) {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(excelHeader[i]);  
                cell.setCellStyle(style);  
                sheet.autoSizeColumn(i);  
            }  
      
            for (int i = 0; i < list.size(); i++) {  
                row = sheet.createRow(i + 1);  
                Msg_file m= list.get(i);  
                Msg_manuscripts maa= listm.get(i);
                row.createCell(0).setCellValue(m.getTitle());  
                row.createCell(1).setCellValue(m.getAuthor());  
                row.createCell(2).setCellValue(m.getType());
                row.createCell(3).setCellValue(m.getFiletype()); 
                row.createCell(4).setCellValue(m.getSendDate());
                row.createCell(5).setCellValue(maa.getName());
                row.createCell(6).setCellValue(m.getNumber());
                row.createCell(7).setCellValue(m.getState());
            }  
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-disposition", "attachment;filename=student.xls");  
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
        public void daoChu4(HttpServletRequest request, HttpServletResponse response){
        	String idstr=request.getParameter("id");
    		String [] id=idstr.split(",");
    		String[] excelHeader = {"标题", "类别", "文体","作者","来源"};
    		Msg_fileDao dao=new Msg_fileDaoImpl();
    		List<Msg_file> list=new ArrayList<Msg_file>();
    		for(int i=0;i<id.length;i++){
    			Msg_file m =dao.selectAllByfid((Integer.parseInt(id[i])));
    			list.add(m);
    		}
            HSSFWorkbook wb = new HSSFWorkbook();  
            HSSFSheet sheet = wb.createSheet("我的稿件");  
            HSSFRow row = sheet.createRow((int) 0);  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            for (int i = 0; i < excelHeader.length; i++) {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(excelHeader[i]);  
                cell.setCellStyle(style);  
                sheet.autoSizeColumn(i);  
            }  
      
            for (int i = 0; i < list.size(); i++) {  
                row = sheet.createRow(i + 1);  
                Msg_file m= list.get(i);  
                row.createCell(0).setCellValue(m.getTitle());  
                row.createCell(1).setCellValue(m.getType());  
                row.createCell(2).setCellValue(m.getFiletype());
                row.createCell(3).setCellValue(m.getAuthor()); 
                row.createCell(4).setCellValue(m.getFrom());
            }  
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-disposition", "attachment;filename=student.xls");  
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
