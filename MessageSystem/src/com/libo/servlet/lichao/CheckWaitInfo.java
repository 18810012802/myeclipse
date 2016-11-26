package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.lichao.WaitInfoServiceImpl;
import com.libo.service.lichao.WaitInfoService;

public class CheckWaitInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("xid"));
		int state=Integer.parseInt(request.getParameter("state"));
		String maid=request.getParameter("maid");
		WaitInfoService wait=new WaitInfoServiceImpl();
		int rows=wait.checkWaitInfo(id, state);
		if(maid==null){
			if (rows > 0) {
				out.print("<script>alert('ÉóºË³É¹¦£¡');location.href='QueryWaitInfoServlet'</script>");
			} else {
				out.print("<script>alert('ÉóºËÊ§°Ü£¡');location.href='QueryWaitInfoServlet'</script>");
			}
		}else{
			if (rows > 0) {
				out.print("<script>alert('ÉóºË³É¹¦£¡');location.href='QueryMinuteBution?maid="+maid+"'</script>");
			} else {
				out.print("<script>alert('ÉóºËÊ§°Ü£¡');location.href='QueryMinuteBution'</script>");
			}
		}
	}

}
