package com.libo.servlet.fan;

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


import com.libo.entity.Org_employee;
import com.libo.entity.Org_role;

import com.libo.service.fan.Org_EmployeeService_fan;
import com.libo.service.fan.Org_RoleService_fan;
import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;
import com.libo.service.impl.fan.Org_RoleServiceImpl_fan;
import com.libo.util.MD5Util;

public class UpdateOrg_EmployeeServlet_fan extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id=request.getParameter("orgid");
		Org_EmployeeService_fan ediService=new Org_EmployeeServiceImpl_fan();
		Org_RoleService_fan roleService = new Org_RoleServiceImpl_fan();
		Org_employee orgEmployee=ediService.getOrgEmployeeById(Integer.valueOf(id));
		List<Org_role> olist=roleService.getAll();
		request.setAttribute("orgEmployee", orgEmployee);
		request.setAttribute("olist", olist);
		request.getRequestDispatcher("User/editUser.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		   String username = null;
		   String password = null;
		   String realname = null;
		   String sex = null;
		   String email = null;
		   String tel = null;
		   String idcard = null;
		   String address = null;
		   String status = null;
		   String role = null;
		   String photo = null;
		   String path = null;
		   String fileName = null;
		   String id = null;
      //1.�����ϴ��ļ�Ŀ¼
		   String filePath = this.getServletContext().getRealPath("/upload");
		   File file = new File(filePath);
		// �ļ�������ʱ��Ҫ�����ļ���
			if (!file.exists()) {
				file.mkdirs();
			}
			// 2.���û���Ŀ¼
			File tempFile = new File("D:/temp");
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			// 3.�����ϴ��ļ��Ĵ�С
			long fileSize = 1024 * 1024 * 5;
			// 4.�����ϴ��ļ�������
			List<String> fileType = new ArrayList<String>();
			fileType.add("jpg");
			fileType.add("png");
			fileType.add("gif");
			// ����׼���ϴ��ˣ�����ϴ����
			FileItemFactory fif = new DiskFileItemFactory(4096, tempFile);
			ServletFileUpload sfu = new ServletFileUpload(fif);
			// ��ʼУ��
			if (sfu.isMultipartContent(request)) {
				// �������Ŀ����ϴ��ļ��ı�
				//��ȡ�����б�����
				try {
					List<FileItem> files = sfu.parseRequest(request);
					// �ж�����ͨ�����ݻ����ϴ����ļ�
					for (FileItem fileItem : files) {
					//	System.out.println(fileItem.getFieldName());
						if (fileItem.isFormField()) {
							// ��ͨ������
							if(fileItem.getFieldName().equals("username")){
								username = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("password")){
								password = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("realname")){
								realname = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("sex")){
								sex = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("email")){
								email = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("tel")){
								tel = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("idcard")){
								idcard = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("address")){
								address = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("status")){
								status = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("role")){
								role = fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("id")){
								id= fileItem.getString("utf-8");
							}
							if(fileItem.getFieldName().equals("path")){
								path = fileItem.getString("utf-8");
								System.out.println("��ʼ��"+path);
							}
							
						}else{
							fileName = fileItem.getName();
							if (fileName != null&&fileName != "") {
								String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
								System.out.println(ext);
								if (!fileType.contains(ext)) { // �ж��ļ������Ƿ�������Χ��
									out.print("<script>location.href='Org_EmployeeServlet_fan';alert('�ļ�����ֻ����gif��bmp��jpg');</script>");
								} else {
									// �ϴ��ļ�
									if (fileItem.getSize() < fileSize) {
										// �����ϴ��ˣ�
										File trueFile = new File(filePath+"/"+fileName);
										fileItem.write(trueFile);
										out.print("<script>alert('�ϴ��ɹ�����');</script>");
									} else {
										out.print("<script>location.href='Org_EmployeeServlet_fan';alert('�ļ��е�󣡱���վֻ���ϴ�5MB��С���Լ����µ��ļ�');</script>");
									}
							}
						}
						}	
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
      Org_EmployeeService_fan ediService = new Org_EmployeeServiceImpl_fan();
      Org_employee oldOrgemployee = ediService.getOrgEmployeeById(Integer.valueOf(id));
      Org_employee orgEmployee = new Org_employee();
      orgEmployee.setLoginname(username);
      System.out.println(orgEmployee);
      if(!oldOrgemployee.getLoginpassword().equals(password)){
    	  MD5Util md5 = new MD5Util();
		 password = md5.encrypByMd5(password);
	     md5.encrypByMd5Jar(password);
      }
      orgEmployee.setLoginpassword(password);
      orgEmployee.setUsername(realname);
      orgEmployee.setSex(Integer.valueOf(sex));
      orgEmployee.setEmail(email);
      orgEmployee.setTelphone(tel);
      orgEmployee.setIdcaid(idcard);
      orgEmployee.setAddress(address);
      orgEmployee.setState(Integer.valueOf(status));
      orgEmployee.setRoleid(Integer.valueOf(role));
      if(fileName==null||fileName==""){
      orgEmployee.setPhoto(path);
      }else{
      orgEmployee.setPhoto("upload/"+fileName);
      }
      orgEmployee.setId(Integer.valueOf(id));
      int count = ediService.updateOrgEmployee(orgEmployee);
      if(count>0){
   	   out.print("<script>location.href='Org_EmployeeServlet_fan';alert('�޸ĳɹ���');</script>");
      }else{
 		 out.print("<script>location.href='Org_EmployeeServlet_fan';alert('�޸�ʧ�ܣ�');</script>");
		 }
	}
	}


