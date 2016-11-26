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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lib.dao.impl.t.Msg_RecriveDaoImpl;
import com.lib.dao.impl.t.Msg_fileDaoImpl;
import com.lib.dao.t.Msg_ReceiveDao;
import com.lib.dao.t.Msg_fileDao;
import com.lib.service.t.File_attachService;
import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.File_attachServiceImpl;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;

public class MyFileUpdaServlet extends HttpServlet {

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
		if(chose.equals("cho")){
			String mid=request.getParameter("mid");
			int msid=0;
			if(mid!=null){
				msid=Integer.parseInt(mid);
			}
			Msg_fileService file=new Msg_fileServiceImpl();
			List<Msg_file> fil=file.selectAllbyFid(msid);
			Msg_ManuscriptsService mman=new Msg_ManuscriptsServiceImpl();
			List<Msg_manuscripts> mmas=mman.selectAllByMid(fil.get(0).getMaId());
			Date date =new Date();
			String aa=date.toString();
			
			System.out.println("在查询内容："+mmas.get(0).getName());
			String ore=fil.get(0).getOrgem().getLoginname();
			request.setAttribute("ore", ore);
			request.setAttribute("date", aa);
			request.setAttribute("mmas", mmas);
			request.setAttribute("fil", fil);
			request.getRequestDispatcher("MyManuscripts/addagain.jsp").forward(request, response);
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
			if(utid!=null){
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
			int maid=0;
			
			//1.创建FileItemFactory
			FileItemFactory factory=new DiskFileItemFactory(4096, new File("D:/html"));
			//设置文件上传的地址：
			String path="D:/upload";
			//规定文件上传的大小
			long maxSize=2048000l;
			//规定文件的的类型
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
			//2.创建ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//3.判断这个请求是不是一个  enctype="multipart/form-data"
			boolean flag=ServletFileUpload.isMultipartContent(request);
			
			
			if(flag){
				//System.out.println("说明是一个上传文件的请求");
				//4获取所有的表单字段
				List<FileItem> fileds= upload.parseRequest(request);
				for (FileItem f : fileds) {
					//5.判断这个字段是不是普通字段
					boolean isForm=f.isFormField();
					if(isForm){
						//普通表单元素
						//输出就行
						String inputName=f.getFieldName();//表单元素的name属性值
						//普通表单字段获取时需要乱码处理
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
						if(inputName.equals("maid")){
							maid=Integer.parseInt(value);
						}
					}else{
						//文件
						long size=f.getSize();//文件的大小；
						String fileName=f.getName();//文件名
						System.out.println("文件名："+fileName+";文件大小："+size);
						//上传的功能
						
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
									//out.print("<script>alert('数据插入成功！！');</script>");
								}else{
									out.print("<script>alert('数据插入失败！！');</script>");
								}
								//out.print("<script>alert('文件上传成功！！');</script>");
							}else{
								//out.print("<script>alert('文件格式不正确！！');</script>");
							}
						}else{
							out.print("<script>alert('文件太大！！');</script>");
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
				mfil.setMaId(maid);
				mfil.setId(msid);
				mfil.setNumber(namenu);
				mfil.setSendUser(userid);
				
				Msg_fileDao mfff=new Msg_fileDaoImpl();
				
				//改msg_receive状态
		
				//Msg_ReceiveDao mr=new Msg_RecriveDaoImpl();
				//int d=mr.update(userid, msid);
				System.out.println("msid==="+msid);
				//System.out.println("修改"+d+"条数据");
				int rows=mfff.updaAPart(mfil);
				if(rows>0){
					out.print("<script>alert('上报成功！');location.href='MyFileMsgServlet'</script>");
				}else{
					out.print("<script>alert('上报失败！');location.href='MyFileMsgServlet'</script>");
				}
				
			}else{
				System.out.println("不是");
			}
			//3.解析每个表单字段
		} catch (Exception e){
			e.printStackTrace();
		}	
		
		}
	}

}
