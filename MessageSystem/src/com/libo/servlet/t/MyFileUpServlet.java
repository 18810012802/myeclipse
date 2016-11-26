package com.libo.servlet.t;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lib.dao.impl.t.Msg_RecriveDaoImpl;
import com.lib.dao.t.Msg_ReceiveDao;
import com.lib.service.t.File_attachService;
import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_fileService;
import com.lib.service.t.Org_employeeService;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Org_employee;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.t.File_attachServiceImpl;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;
import com.libo.service.impl.t.Org_employeeServiceImpl;
import com.libo.service.lichao.InfoService;

public class MyFileUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String chose=request.getParameter("chose");
		String mid=request.getParameter("mid");
		String uid=request.getParameter("userid");
		if(chose.equals("cho")){
			//���������Ҫ��Լ����Ϣ
			int msid=0;
			if(mid!=null){
				msid=Integer.parseInt(mid);
			}
			Msg_ManuscriptsService m=new Msg_ManuscriptsServiceImpl();
			List<Msg_manuscripts> msg=m.selectAllByMid(msid);
			//���ϱ��˺�������Ϣ
			int uuid=0;
			if(uid!=null){				
				uuid=Integer.parseInt(uid);
			}
			System.out.println("msid==="+msid);
			System.out.println("uuid==="+uuid);
			Org_employeeService org=new Org_employeeServiceImpl();
			List<Org_employee> ore=org.SelectAllByOid(uuid);
			/*//��msg_receive״̬
			Msg_ReceiveDao mr=new Msg_RecriveDaoImpl();
			mr.update(uuid, msid);*/
			//��ʾ����
			Date date =new Date();
			String aa=date.toString();
			request.setAttribute("date", aa);
			request.setAttribute("ore", ore);
			request.setAttribute("msg", msg);
			request.setAttribute("mid", msid);
			request.getRequestDispatcher("MyManuscripts/add.jsp").forward(request, response);
		}
		if(chose.equals("chose")){
			
			Msg_fileService mf=new Msg_fileServiceImpl();
			Msg_file mfil=new Msg_file();
			PrintWriter out=response.getWriter();
			File_attachService info=new File_attachServiceImpl();
			File_attach fil=new File_attach();
			
			try{
			String utid=request.getParameter("userid");
			int userid=0;
			if(utid!=null){
				userid=Integer.parseInt(utid);
			}

			String mdid=request.getParameter("mid");
			int msid=0;
			if(mdid!=null){
				msid=Integer.parseInt(mdid);
			}

			String title="";
			String author="";
			String namenu="";
			String from="";
			String type="";
			String filetype="";
			String content="";
			String file="";
			
			//1.����FileItemFactory
			FileItemFactory factory=new DiskFileItemFactory(4096, new File("D:/html"));
			//�����ļ��ϴ��ĵ�ַ��
			String path="D:/upload";
			//�涨�ļ��ϴ��Ĵ�С
			long maxSize=2048000l;
			//�涨�ļ��ĵ�����
			List<String> types=new ArrayList<String>();
			types.add(".jpg");
			types.add(".JPG");
			types.add(".png");
			types.add(".PNG");
			types.add(".gif");
			types.add(".GIF");
			types.add(".zip");
			types.add(".ZIP");
			types.add(".txt");
			types.add(".TXT");
			types.add(".doc");
			types.add(".DOC");
			//2.����ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//3.�ж���������ǲ���һ��  enctype="multipart/form-data"
			boolean flag=ServletFileUpload.isMultipartContent(request);
			
			
			if(flag){
				//System.out.println("˵����һ���ϴ��ļ�������");
				//4��ȡ���еı����ֶ�
				List<FileItem> fileds= upload.parseRequest(request);
				for (FileItem f : fileds) {
					//5.�ж�����ֶ��ǲ�����ͨ�ֶ�
					boolean isForm=f.isFormField();
					if(isForm){
						//��ͨ����Ԫ��
						//�������
						String inputName=f.getFieldName();//����Ԫ�ص�name����ֵ
						//��ͨ�����ֶλ�ȡʱ��Ҫ���봦��
						String value=f.getString("UTF-8");
						System.out.println(inputName+":"+value);
						if(inputName.equals("namenu")){
							namenu=value;
						}
						if(inputName.equals("title")){
							title=value;
						}
						if(inputName.equals("author")){
							author=value;
						}
						if(inputName.equals("from")){
							from=value;
						}
						if(inputName.equals("type")){
							type=value;
						}
						if(inputName.equals("filetype")){
							filetype=value;
						}
						if(inputName.equals("content")){
							content=value;
						}
						if(inputName.equals("file")){
							file=value;
						}
						if(inputName.equals("mid")){
							msid=Integer.parseInt(value);
						}
					}else{
						//�ļ�
						long size=f.getSize();//�ļ��Ĵ�С��
						String fileName=f.getName();//�ļ���
						System.out.println("�ļ�����"+fileName+";�ļ���С��"+size);
						//�ϴ��Ĺ���
						
						file=path+"//"+fileName;
						String typ="";
						if(size<=maxSize){
							boolean format=false;
							for (String s : types) {
								if(fileName.contains(s)){
									typ=s;
									f.write(new File(path+"\\"+f.getName()));
									format=true;
								}
							}
							if(format){
								fil.setName(fileName);
								fil.setPath(file);
								fil.setFiletype(typ);
								fil.setMenuId(3);
								int r=info.addAll(fil);
								if(r>0){
									//out.print("<script>alert('���ݲ���ɹ�����');</script>");
								}else{
									out.print("<script>alert('���ݲ���ʧ�ܣ���');</script>");
								}
								//out.print("<script>alert('�ļ��ϴ��ɹ�����');</script>");
							}else{
								//out.print("<script>alert('�ļ���ʽ����ȷ����');</script>");
							}
						}else{
							out.print("<script>alert('�ļ�̫�󣡣�');</script>");
						}
					}
				}
				mfil.setCreateUserId(userid);
				mfil.setTitle(title);
				mfil.setAuthor(author);
				mfil.setFrom(from);
				mfil.setType(type);
				mfil.setFiletype(filetype);
				mfil.setContent(content);
				mfil.setMaId(msid);
				mfil.setNumber(namenu);
				mfil.setSendUser(userid);
				
				//��msg_receive״̬
				
				int uuid=0;
				if(uid!=null){				
					uuid=Integer.parseInt(uid);
				}
				Msg_ReceiveDao mr=new Msg_RecriveDaoImpl();
				int d=mr.update(uuid, msid);
				System.out.println("msid==="+msid);
				System.out.println("uuid==="+uuid);
				System.out.println("�޸�"+d+"������");
				int rows=mf.addAll(mfil);
				if(rows>0){
					out.print("<script>alert('�ϱ��ɹ���');location.href='MyFileMesTwoServlet'</script>");
				}else{
					out.print("<script>alert('�ϱ�ʧ�ܣ�');location.href='MyFileMesTwoServlet'</script>");
				}
				
			}else{
				System.out.println("����");
			}
			//3.����ÿ�������ֶ�
		} catch (Exception e){
			e.printStackTrace();
		}	
		}
	}

}