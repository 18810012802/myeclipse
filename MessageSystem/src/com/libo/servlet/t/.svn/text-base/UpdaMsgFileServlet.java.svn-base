package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.service.impl.t.Msg_fileServiceImpl;

public class UpdaMsgFileServlet extends HttpServlet {

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
		String chan=request.getParameter("chan");
		if(chan.equals("cha")){
		String mid=request.getParameter("mid");
		int mmid=0;
		if(mid!=null){
			mmid=Integer.parseInt(mid);
		Msg_fileService msfile=new Msg_fileServiceImpl();
		List<Msg_file> filelist=msfile.selectAllbyFid(mmid);
		request.setAttribute("filelist", filelist);
		request.getRequestDispatcher("MyFile/addfile.jsp").forward(request, response);
		}
		}
		
		if(chan.equals("chan")){
			int fid=Integer.parseInt(request.getParameter("fid"));
			String typ=request.getParameter("typ");
			String title= request.getParameter("title");
			String author=request.getParameter("author");
			String from= request.getParameter("from");
			String type=request.getParameter("type");
			String filetype=request.getParameter("filetype");
			String content=request.getParameter("content");
			String msg=request.getParameter("msg");
			
			Msg_file mmsg=new Msg_file();
			mmsg.setTitle(title);
			mmsg.setAuthor(author);
			mmsg.setFrom(from);
			mmsg.setType(type);
			mmsg.setType(filetype);
			mmsg.setFiletype(filetype);
			mmsg.setContent(content);
			//msg需要判断一下
			Msg_fileService mmfile=new Msg_fileServiceImpl();
			int yugaid=0;
			
			if(type.equals("2")){

			if(msg==null||msg.equals("")){
				yugaid=1;
				int rows=mmfile.updSPart(mmsg, fid, 0);
				if (rows > 0) {
					// 添加成功
					out.print("<script>alert('编辑成功1!');location.href='FileListServlet';</script>");
				} else {
					// 添加失败；
					out.print("<script>alert('编辑失败1!');location.href='FileListServlet';</script>");
				}		
			}else{
				yugaid=Integer.parseInt(msg);
				
				int rows=mmfile.updSPart(mmsg, fid, yugaid);
				if (rows > 0) {
					// 添加成功
					out.print("<script>alert('编辑成功2!');location.href='FileListServlet';</script>");
				} else {
					// 添加失败；
					out.print("<script>alert('编辑失败2!');location.href='FileListServlet';</script>");
				}	
			}

			}else if(type.equals("1")){
				
			
			}
		}
		
	}

}
