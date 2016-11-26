package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.yetong.MailBoxService;
import com.libo.util.PageSize;

public class ExcelReceiveEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String[] excelHeader = { "标题", "内容", "收件人", "发送时间" };
		// 创建集合（从数据库中查询出来）
		Org_employee oe = (Org_employee) request.getSession()
				.getAttribute("oe");
		int uid = 0;
		if (oe != null) {
			uid = oe.getId();

		}
		// 1、判断返回界面的值、判断是发送的邮件还是接收的邮件、
		String reStr = request.getParameter("reStr");
		if (StringUtils.isEmpty(reStr)) {
			reStr = "0";
		}
		int re = Integer.valueOf(reStr);
		// 根据页面跳转标识，判断查询人身份，设置对应身份的查询条件-state
		Mail_box mailBox = new Mail_box();
		mailBox.setSendstate("0");

		// 拿到接受的发送人id
		Org_employee oEmployee = (Org_employee) request.getSession()
				.getAttribute("oe");
		Integer userid = 0;
		if (oEmployee != null) {
			userid = oEmployee.getId();

		}
		// 分页查询
		String pages = request.getParameter("page");
		if (pages == null) {
			pages = "1";
		}
		int pageNum = 0;
		pageNum = Integer.valueOf(pages);
		// MailBox mailBox=new MailBox();
		MailBoxService mailBoxService = new MailBoxServiceImpl();
		List<Mail_box> mbList = mailBoxService.getByLike(pageNum,
				PageSize.PAGE_SIZE, userid, mailBox, re);
		// 创建Excel对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建sheet
		HSSFSheet sheet = wb.createSheet("我的稿件信息表");
		// 创建行
		HSSFRow row = sheet.createRow((int) 0);
		// 创建样式
		HSSFCellStyle style = wb.createCellStyle();
		// 居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}
		// "标题","内容", "收件人","发送时间"
		for (int i = 0; i < mbList.size(); i++) {
			row = sheet.createRow(i + 1);
			Mail_box msg = mbList.get(i);
			row.createCell(0).setCellValue(msg.getTitle());
			row.createCell(1).setCellValue(msg.getContent());
			row.createCell(2).setCellValue(msg.getOe().getUsername());
			row.createCell(3).setCellValue(msg.getSendDate());

		}
		// 设置响应信息类型
		response.setContentType("application/vnd.ms-excel");
		// 设置响应的头信息
		response.setHeader("Content-disposition",
				"attachment;filename=MsgFile.xls");
		// 通过输出流将文件输出到客户端
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();

	}

}