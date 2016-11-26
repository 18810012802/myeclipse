package com.libo.servlet.lichao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.lichao.InfoService;
import com.libo.util.Da;

public class UpdateInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			String name = "";
			String number = "";
			String content = "";
			Date endDate=null;
			int state=0;
			int id=0;
			int oid=0; 
			//添加附件管理的变量
			String pa="";
			int mid=11;
			String fname="";
			String ftype="";
			//调用业务逻辑层
			InfoService ser=new InfoServiceImpl();
			//1.创建FileItemFactory
			FileItemFactory factory=new DiskFileItemFactory(4096, new File("D:/Temp"));
			//设置文件上传的地址：
			String path="D:/upload";
			//规定文件上传的大小
			long maxSize=2048000l;
			//规定文件的的类型
			List<String> types=new ArrayList<String>();
			types.add(".jpg");
			types.add(".JPG");
			types.add(".doc");
			types.add(".zip");
			types.add(".ZIP");
			types.add(".txt");
			types.add(".TXT");
			//2.创建ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//3.判断这个请求是不是一个  enctype="mutilpart/form-data"
			boolean flag=ServletFileUpload.isMultipartContent(request);
			if(flag){
				//4获取所有的表单字段
				List<FileItem> fileds= upload.parseRequest(request);
				for (FileItem f : fileds) {
					//5.判断这个字段是不是普通字段
					boolean isForm=f.isFormField();
					if(isForm){
						//普通表单元素
						String inputName=f.getFieldName();//表单元素的name属性值
						//普通表单字段获取时需要乱码处理
						String value=f.getString("UTF-8");
						if(inputName.equals("name")){
							name=value;
						}
						if(inputName.equals("number")){
							number=value;
						}
						if(inputName.equals("content")){
							content=value;
						}
						if(inputName.equals("endDate")){
							endDate = Da.toDate(value);
						}
						if(inputName.equals("state")){
							state = Integer.parseInt(value);
						}
						if(inputName.equals("id")){
							id = Integer.parseInt(value);
							
						}
						if(inputName.equals("oid")){
							oid = Integer.parseInt(value);
							System.out.println(oid);
						}
					}else{
						//文件
						long size=f.getSize();//文件的大小；
						String fileName=f.getName();//文件名
						//上传的功能
						if(size<=maxSize){
							boolean format=false;
							for (String s : types) {
								if(fileName.contains(s)){
									f.write(new File(path+"\\"+f.getName()));
									pa=path+"\\"+f.getName();
									fname=f.getName();
									ftype=s;
									format=true;									
								}
							}
							if(format){
								out.print("<script>alert('附件上传成功！！');</script>");
							}else{
								if(pa!=""){
								out.print("<script>alert('附件格式不正确！！');</script>");
								}
							}
						}else{
							if(pa!=""){
							out.print("<script>alert('文件太大！！');</script>");
							}
						}
					}
				}
			}else{
				 state = Integer.parseInt(request.getParameter("state"));
				 number = request.getParameter("number");
				 content = request.getParameter("content");
				 endDate = Da.toDate(request.getParameter("endDate"));
				 name = request.getParameter("name");
				 id =Integer.parseInt(request.getParameter("id"));
			}
			int rows=ser.updateInfo(name, number, content, endDate, oid, state, id);
			ser.addFile(fname, pa, ftype, mid,id);
			if (rows > 0) {
				out.print("<script>alert('修改成功！');location.href='ShowServlet'</script>");
			} else {
				out.print("<script>alert('修改失败！');location.href='ShowServlet'</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}


