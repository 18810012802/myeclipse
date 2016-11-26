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

public class AddOrg_EmployeeServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Org_RoleService_fan roleService=new Org_RoleServiceImpl_fan();
		List<Org_role> list=roleService.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("User/addUser.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
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
		   String fileName = null;
		   //1.设置上传文件目录
		   String filePath = this.getServletContext().getRealPath("/upload");
		   File file = new File(filePath);
		// 文件不存在时候，要创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			// 2.设置缓存目录
			File tempFile = new File("D:/temp");
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			// 3.设置上传文件的大小
			long fileSize = 1024 * 1024 * 5;
			// 4.设置上传文件的类型
			List<String> fileType = new ArrayList<String>();
			fileType.add("jpg");
			fileType.add("png");
			fileType.add("gif");
			// 可以准备上传了！获得上传组件
			FileItemFactory fif = new DiskFileItemFactory(4096, tempFile);
			ServletFileUpload sfu = new ServletFileUpload(fif);
			// 开始校验
			if (sfu.isMultipartContent(request)) {
				// 是正常的可以上传文件的表单
				//获取了所有表单数据
				try {
					List<FileItem> files = sfu.parseRequest(request);
					// 判断是普通表单数据还是上传的文件
					for (FileItem fileItem : files) {
					//	System.out.println(fileItem.getFieldName());
						if (fileItem.isFormField()) {
							// 普通表单数据
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
							
						}else{
							fileName = fileItem.getName();
							if (fileName != null&&fileName != "") {
								String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
								System.out.println(ext);
								if (!fileType.contains(ext)) { // 判断文件类型是否在允许范围内
									out.print("<script>location.href='AddOrg_EmployeeServlet_fan';alert('文件类型只能是gif、bmp、jpg');</script>");
								} else {
									// 上传文件
									if (fileItem.getSize() < fileSize) {
										// 真正的可以上传了！
										File trueFile = new File(filePath+"/"+fileName);
										fileItem.write(trueFile);
										out.print("<script>alert('上传成功！！');</script>");
									} else {
										out.print("<script>location.href='AddOrg_EmployeeServlet_fan';alert('上传失败');</script>");
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
         Org_employee orgEmployee = new Org_employee();
         orgEmployee.setLoginname(username);
          /*MD5Util md5 = new MD5Util();
          System.out.println("============"+password);
 			password = md5.encrypByMd5(password);
 			md5.encrypByMd5Jar(password);*/
         orgEmployee.setLoginpassword(password);
         orgEmployee.setUsername(realname);
         orgEmployee.setSex(Integer.valueOf(sex));
         orgEmployee.setEmail(email);
         orgEmployee.setTelphone(tel);
         orgEmployee.setIdcaid(idcard);
         orgEmployee.setAddress(address);
         orgEmployee.setState(Integer.valueOf(status));
         orgEmployee.setRoleid(Integer.valueOf(role));
         orgEmployee.setPhoto("upload/"+fileName);
         int count = ediService.addOrgEmployee(orgEmployee);
         if(count>0){
      	   out.print("<script>location.href='Org_EmployeeServlet_fan';alert('添加成功！');</script>");
         }else{
    		 out.print("<script>location.href='Org_EmployeeServlet_fan';alert('添加失败！');</script>");
		 }
	}
	}


