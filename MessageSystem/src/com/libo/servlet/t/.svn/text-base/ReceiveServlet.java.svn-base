package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_ReceiveService;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Msg_receive;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_ReceiveServiceImpl;

public class ReceiveServlet extends HttpServlet {

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
		
		Msg_ManuscriptsService msg=new Msg_ManuscriptsServiceImpl();
		Msg_ReceiveService ms=new Msg_ReceiveServiceImpl();
		Msg_receive msRece=new Msg_receive();
		String chan=request.getParameter("chan");
		if(chan.equals("cha")){
		//接受
		int rows=0;
		String fid=request.getParameter("fid");
		String [] fdd=fid.split(",");
		System.out.println(fid);
		int ffid=0;
		if(fid!=null){
			
			for (int i = 0; i < fdd.length; i++) {
					ffid=Integer.parseInt(fdd[i]);
		
					String uid=request.getParameter("uid");
					int userid=0;
					if(uid==null){
						userid=0;
					}else{
						userid=Integer.parseInt((String)uid);
					}
					
					msRece.setEditUserId(userid);
					msRece.setManuscriptsId(ffid);
					msRece.setState(0);
					rows=ms.addRece(msRece);
			}
		
		if(rows>0){
			out.print("<script>alert('接收成功！');location.href='MyFileMesServlet';</script>");
		}else{
			out.print("<script>alert('接收失败！');location.href='MyFileMesServlet';</script>");
		}
		}
		
		}else if(chan.equals("chan")){
			//拒收
			String fid=request.getParameter("fid");
			int ffid=0;
			if(fid!=null){
				ffid=Integer.parseInt(fid);
			}
			
			List<Msg_manuscripts> mmsg=msg.selectAllByMid(ffid);
			
			String uid=request.getParameter("uid");
			int userid=0;
			if(uid==null){
				userid=0;
			}else{
				userid=Integer.parseInt((String)uid);
			}
			
			msRece.setEditUserId(userid);
			msRece.setManuscriptsId(mmsg.get(0).getId());
			msRece.setState(1);
			int rows=ms.addRece(msRece);
			//request.setAttribute("fid", fid);
			
			if(rows>0){
				out.print("<script>alert('拒收成功！');location.href='MyFileMesServlet';</script>");
			}else{
				out.print("<script>alert('拒收失败！');location.href='MyFileMesServlet';</script>");
			}
			
		}
		
	}

}
