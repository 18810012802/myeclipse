package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.lichao.InfoService;

public class DelInfosServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得out对象
		PrintWriter out=response.getWriter();
		//获得稿件id
		InfoService info=new InfoServiceImpl();
		String qid=request.getParameter("qid");
		String [] qids= qid.split(",");
		int r=0;
		if(qid!=null){
			for (int i = 0; i < qids.length; i++) {
				r=info.delInfo(Integer.parseInt(qids[i]));
			}
				if(r>0){
					out.print("<script>alert('删除成功！');location.href='ShowServlet'</script>");
				}else{
					out.print("<script>alert('删除失败！');location.href='ShowServlet'</script>");
			}
		}
		
	}

}
