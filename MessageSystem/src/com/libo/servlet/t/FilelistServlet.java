package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.Msg_ReceiveService;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_receive;
import com.libo.service.impl.t.Msg_ReceiveServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;
import com.libo.util.PageUtil;


public class FilelistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*String fid=request.getParameter("fid");
		int ffid=0;
		if(fid!=null){
			ffid=Integer.parseInt(fid);
		}
		Msg_ReceiveService msr=new Msg_ReceiveServiceImpl();
		List<Msg_receive> mrlist=msr.selectByUserId(ffid);*/
		
		Msg_fileService f=new Msg_fileServiceImpl();
		int currPage=1;
		String strcurrent=request.getParameter("current");
		if(strcurrent!=null){
			currPage=Integer.parseInt(strcurrent);
		}
		
		String title="";
		String type="";
		String wordType="";
		String tit=request.getParameter("title");
		if(tit!=null){
			title=tit;
		}
		String typ=request.getParameter("type");
		if(typ!=null){
			type=typ;
		}	
		String filet=request.getParameter("filety");
		if(filet!=null){
			wordType=filet;
		}
		List<Msg_file> file=f.selectAllbyFid(currPage, title, type, wordType);
		int count=f.selectAllbyFilid( title, type, wordType);
		int pagecount=0;
		if(count%PageUtil.PAGESIZE==0){
			pagecount=count/PageUtil.PAGESIZE;
		}else{
			pagecount=count/PageUtil.PAGESIZE+1;
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("file", file);
		request.setAttribute("coun", count);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("wordType", wordType);
		
		request.getRequestDispatcher("MyFile/filelist.jsp").forward(request, response);
	}

}
