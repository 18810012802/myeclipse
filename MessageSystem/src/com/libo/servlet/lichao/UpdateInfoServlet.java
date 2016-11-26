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
			//��Ӹ�������ı���
			String pa="";
			int mid=11;
			String fname="";
			String ftype="";
			//����ҵ���߼���
			InfoService ser=new InfoServiceImpl();
			//1.����FileItemFactory
			FileItemFactory factory=new DiskFileItemFactory(4096, new File("D:/Temp"));
			//�����ļ��ϴ��ĵ�ַ��
			String path="D:/upload";
			//�涨�ļ��ϴ��Ĵ�С
			long maxSize=2048000l;
			//�涨�ļ��ĵ�����
			List<String> types=new ArrayList<String>();
			types.add(".jpg");
			types.add(".JPG");
			types.add(".doc");
			types.add(".zip");
			types.add(".ZIP");
			types.add(".txt");
			types.add(".TXT");
			//2.����ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//3.�ж���������ǲ���һ��  enctype="mutilpart/form-data"
			boolean flag=ServletFileUpload.isMultipartContent(request);
			if(flag){
				//4��ȡ���еı��ֶ�
				List<FileItem> fileds= upload.parseRequest(request);
				for (FileItem f : fileds) {
					//5.�ж�����ֶ��ǲ�����ͨ�ֶ�
					boolean isForm=f.isFormField();
					if(isForm){
						//��ͨ��Ԫ��
						String inputName=f.getFieldName();//��Ԫ�ص�name����ֵ
						//��ͨ���ֶλ�ȡʱ��Ҫ���봦��
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
						//�ļ�
						long size=f.getSize();//�ļ��Ĵ�С��
						String fileName=f.getName();//�ļ���
						//�ϴ��Ĺ���
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
								out.print("<script>alert('�����ϴ��ɹ�����');</script>");
							}else{
								if(pa!=""){
								out.print("<script>alert('������ʽ����ȷ����');</script>");
								}
							}
						}else{
							if(pa!=""){
							out.print("<script>alert('�ļ�̫�󣡣�');</script>");
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
				out.print("<script>alert('�޸ĳɹ���');location.href='ShowServlet'</script>");
			} else {
				out.print("<script>alert('�޸�ʧ�ܣ�');location.href='ShowServlet'</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}


