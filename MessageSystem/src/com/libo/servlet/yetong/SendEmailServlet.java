package com.libo.servlet.yetong;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.libo.entity.File_attach;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.yetong.MailBoxService;

public class SendEmailServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Org_employee oEmployee=(Org_employee) request.getSession().getAttribute("org_employee");
		Integer uid=0;
		if (oEmployee!=null) {
			uid=oEmployee.getId();
		}
		MailBoxService mailBoxService = new MailBoxServiceImpl();

		List<Org_employee> list = mailBoxService.getOthersByUserId(uid);
		PrintWriter out = response.getWriter();
		if (list.size() > 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("Email/sendemail.jsp").forward(
					request, response);
		} else {
			out.print("<script>location.href='Email/sendemail.jsp';alert('ͨѶ¼��û���κκ��ѣ��޷������ʼ�!!');</script>");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		MailBoxService mailBoxService = new MailBoxServiceImpl();

		// ׼������
		// 1�������ϴ�·�����������½�·��
		String filePath = this.getServletContext().getRealPath("/upload");
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 2�����û���Ŀ¼,���������½�
		String tempPath = this.getServletContext().getRealPath("/temp");
		File tempFile = new File(tempPath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}

		// 3�������ϴ��ļ���С<5m
		long fileSize = 1024 * 1024 * 5;
		// 4�������ϴ��ļ�����
		List<String> types = new ArrayList<String>();
		types.add("txt");
		types.add("doc");
		types.add("gif");
		// ׼����������ʼ�ϴ�
		// 1������ϴ����
		FileItemFactory fif = new DiskFileItemFactory(4096, tempFile);
		ServletFileUpload sfu = new ServletFileUpload(fif);
		// 2����ʼУ��
		String reStr=null;
		// �˵�id�ڲ����ļ���Ϣ��ʱ��ʹ��
		String mnid = null;
		int menuid = 0;
		// �����ʼ����˵�id
		String sid = null;
		int suid = 0;
		// �����ʼ����˵�id
		String rid = null;
		int ruid = 0;
		// �ʼ�����������
		String title = null;
		String content = null;
		// �ϴ��ļ�����
		String type = null;
		// �ļ���
		String fileName = null;
		// ��֤�ǲ����������ϴ���
		if (sfu.isMultipartContent(request)) {
			try {
				List<FileItem> files = sfu.parseRequest(request);
				// ѭ���ж��ϴ�����������ͨ���ݣ������ϴ��ļ�����
				for (FileItem fileItem : files) {
					if (fileItem.isFormField()) {
						if (fileItem.getFieldName().equals("menuid")) {
							mnid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("suid")) {
							sid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("ruid")) {
							rid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("title")) {
							title = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("reStr")) {
							reStr = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("content")) {
							content = fileItem.getString("utf-8");
						}
					} else {
						// ���ϴ��ļ����ݵ������������ļ���
						fileName = fileItem.getName();
						if (fileName != null) {
							// ���fileName������null,��ȡ������֤�Ƿ�Ϊ���ϴ�����
							type = fileName
									.substring(fileName.lastIndexOf(".") + 1);
							if (!types.contains(type)) {
								// �����ϴ�������ʾ
								out.print("<script>location.href=location.href='SendEmailServlet?suid="
										+ suid
										+ "';alert('�ļ�����ֻ����gif��doc��txt');</script>");
							} else {
								// ���ϴ����ͣ���֤�ļ���С�Ƿ���
								if (fileItem.getSize() < fileSize) {
									// �ϴ��ļ�
									File finalPath = new File(filePath + "//"
											+ fileName);
									fileItem.write(finalPath);
									//������Ӹ�������������������
									out.print("<script>alert('�ϴ��ɹ�����');</script>");
								} else {
									out.print("<script>location.href='SendEmailServlet?suid="
											+ suid
											+ "';alert('�ϴ��ļ����ô���5m');</script>");
								}
							}

						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// �õ�msgFile��id��uid�Ա����ͻ��С������ʱ�����ϴ�����
		//int id=Integer.parseInt(request.getParameter("sid"));
		//suid = Integer.parseInt("sid");
		//ruid = Integer.parseInt("rid");
		//menuid=Integer.parseInt("mnid");
		if (StringUtils.isEmpty(title)) {
			out.print("<script>location.href='SendEmailServlet?suid=" + suid
					+ "';alert('���ⲻ��Ϊ�գ���');</script>");
		} else {
			if(sid!=null){
				suid=Integer.parseInt(sid);
			}
			if(rid!=null){
				ruid=Integer.parseInt(rid);
			}
			//
			Mail_box mailBox=new Mail_box();
			mailBox.setTitle(title);
			mailBox.setContent(content);
			mailBox.setSendstate("1");

			// ����
			File_attach fileAttach = new File_attach();
			String path = filePath + "/" + fileName;
			fileAttach.setPath(path);
			fileAttach.setName(fileName);
			fileAttach.setFiletype(type);
			fileAttach.setMenuId(menuid);
			System.out.println("munuid="+menuid);
			//
			//����mailbox��fileAttach��������id ��������id
			//suid = Integer.parseInt("suid");
			//ruid = Integer.parseInt("");
			int row = mailBoxService.sendEMail(mailBox,fileAttach,suid,ruid);
			
				if (StringUtils.isEmpty(reStr)) {
					reStr="1";
				}
				int re=Integer.valueOf(reStr);
			if (row > 0) {
				if (re==0) {
					//�ռ���                                                                                                                       
					out.print("<script>location.href='ShowReceiveEmailsServlet';alert('���ͳɹ�����');</script>");
				}else {
					out.print("<script>location.href='ShowEmailsByLikeServlet';alert('���ͳɹ�����');</script>");
				}
			} else {
				out.print("<script>location.href='SendEmailServlet?suid=" + suid
						+ "';alert('����ʧ�ܣ�');</script>");
			}
		}

	}

}
