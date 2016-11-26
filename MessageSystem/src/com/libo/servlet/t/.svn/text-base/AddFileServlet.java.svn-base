package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dao.impl.t.Msg_fileDaoImpl;
import com.lib.dao.t.Msg_fileDao;
import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;

public class AddFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Msg_fileService mmsg=new Msg_fileServiceImpl();
		//判断选择
		String cho=request.getParameter("chose");
		
		if(cho.equals("cha")){
		String fid=request.getParameter("fid");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String from=request.getParameter("from");
		String type=request.getParameter("type");
		String filetyp=request.getParameter("filetype");
		String content=request.getParameter("content");
		//String m=request.getParameter("msg");
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("org_id");
		String uid="";
		if(obj==null){
			uid="";
		}else{
			uid=obj.toString();
		}
		int uuid=Integer.parseInt(uid);
		int ffid=0;
		if(fid!=null){
			ffid=Integer.parseInt(fid);
		}
		
		Msg_file msfile=new Msg_file();
		msfile.setId(ffid);
		msfile.setTitle(title);
		msfile.setAuthor(author);
		msfile.setFrom(from);
		msfile.setType(type);
		msfile.setFiletype(filetyp);
		msfile.setContent(content);
		msfile.setFlag(0);
		msfile.setCreateUserId(uuid);
		msfile.setSendUser(uuid);
		/*
		 * 在提交和保存之前还需要获取很多其他信息
		 * */
		Msg_fileDao mmgg=new Msg_fileDaoImpl();
		int rows=mmgg.updSPart(msfile, ffid, 0);
		if(rows>0){
			out.print("<script>alert('保存成功！');location.href='FilelistServlet';</script>");
		}else{
			out.print("<script>alert('保存失败！');location.href='FilelistServlet';</script>");
		}
		}
		//提交
		if(cho.equals("chose")){
			String midd=request.getParameter("msg");
			String fid=request.getParameter("fid");
			int mmid=0;
			if(midd!=null){
				mmid=Integer.parseInt(midd);
			}
			System.out.println("mmid:"+mmid);
			Msg_ManuscriptsService mms=new Msg_ManuscriptsServiceImpl();
			List<Msg_manuscripts> mminfo=mms.selectAllByMid(mmid);
			System.out.println("预告信息表里内容："+mminfo);
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("org_id");
			String uid="";
			if(obj==null){
				uid="";
			}else{
				uid=obj.toString();
			}
			int uuid=Integer.parseInt(uid);
			int ffid=0;
			if(fid!=null){
				ffid=Integer.parseInt(fid);
			}
			
			//String mid=request.getParameter("mid");
			String title=request.getParameter("title");
			String author=request.getParameter("author");
			String from=request.getParameter("from");
			String type=request.getParameter("type");
			String filetyp=request.getParameter("filetype");
			String content=request.getParameter("content");
			//String m=request.getParameter("msg");
			
			Msg_file msfile=new Msg_file();
			msfile.setId(ffid);
			msfile.setTitle(title);
			msfile.setAuthor(author);
			msfile.setFrom(from);
			msfile.setType(type);
			msfile.setFiletype(filetyp);
			msfile.setContent(content);
			msfile.setFlag(1);
			msfile.setCreateUserId(uuid);
			msfile.setSendUser(uuid);
			msfile.setMaId(mminfo.get(0).getId());
			msfile.setNumber(mminfo.get(0).getNumber());
			/*
			 * 在提交和保存之前还需要获取很多其他信息
			 * */
			Msg_fileDao mmgg=new Msg_fileDaoImpl();
			int rows=mmgg.updaAPart(msfile);
			if(rows>0){
				out.print("<script>alert('提交成功！');location.href='FilelistServlet';</script>");
			}else{
				out.print("<script>alert('提交失败！');location.href='FilelistServlet';</script>");
			}
		}
	}	
	}
