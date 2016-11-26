package com.libo.servlet.lichao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_file;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.lichao.WaitInfoServiceImpl;
import com.libo.service.lichao.InfoService;
import com.libo.service.lichao.WaitInfoService;

public class SelectWaitInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String maid=request.getParameter("maid");
		int id=Integer.parseInt(request.getParameter("id"));
		WaitInfoService wait=new  WaitInfoServiceImpl();
		List<Msg_file> msg=wait.selectWaitInfoById(id);
		InfoService info=new InfoServiceImpl();
		String fname=info.QueryFlieNmae(3, id);
		request.setAttribute("fname",fname);
		request.setAttribute("msg", msg);
		request.setAttribute("id", id);
		if(maid==null){
		request.getRequestDispatcher("Manuscripts/look2.jsp").forward(request, response);
		}else{
		request.setAttribute("maid", maid);
		request.getRequestDispatcher("Manuscripts/look4.jsp?").forward(request, response);	
		}
		
	}

}
