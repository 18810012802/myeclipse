package com.lib.servlet.publish;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.publish.PublishService;
import com.lib.service.publish.PublishServiceImpl;
import com.libo.entity.Msg_file_list;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.PublishDetail;
import com.libo.util.FileLoadUtil;
import com.libo.util.JxlExcelUtil;
import com.libo.util.PageSize;

public class PublishServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��ҳ��С
		int pageSize = PageSize.PAGE_SIZE;
		String type = request.getParameter("type");
		// ¼�ø��
		if("download".equals(type)){
			String from=request.getParameter("path");
			String[] froms=from.split("/");
			String to="D:/download/"+Calendar.getInstance().getTimeInMillis()+froms[froms.length-1];
			String result=FileLoadUtil.DownloadFile(from, to);
			response.getWriter().write(result);
		}else if ("review".equals(type)) {
			int id = Integer.parseInt(request.getParameter("id"));
			PublishService ps = new PublishServiceImpl();
			String result = ps.check("Msg_file", "state", 3, id);
			response.getWriter().write(result);
			// ��¼�ø��
		} else if ("unreview".equals(type)) {
			int id = Integer.parseInt(request.getParameter("id"));
			PublishService ps = new PublishServiceImpl();
			String result = ps.check("Msg_file", "state", 2, id);
			response.getWriter().write(result);
			// ͨ�����
		} else if ("check".equals(type)) {
			int id = Integer.parseInt(request.getParameter("maId"));
			PublishService ps = new PublishServiceImpl();
			String res = ps.check("Msg_manuscripts", "flag", 2, id);
			String result = ps.checkFile(id,"state",3);
			response.getWriter().write(result);
			// ��ͨ�����
		} else if ("reject".equals(type)) {
			int id = Integer.parseInt(request.getParameter("maId"));
			PublishService ps = new PublishServiceImpl();
			String res = ps.check("Msg_manuscripts", "flag", 3, id);
			String result = ps.checkFile(id,"state",2);
			response.getWriter().write(result);
			// ����excel
		} else if ("export".equals(type)) {
			Map<String, String> condition = new HashMap<String, String>();
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			if (name != null && !("null".equals(name))
					&& !("".equals(name.trim()))) {
				condition.put("name", name);
			}
			if (number != null && !("null".equals(number))
					&& !("".equals(number.trim()))) {
				condition.put("number", number);
			}
			PublishService ps = new PublishServiceImpl();
			List<Msg_manuscripts> msg = ps.queryManuscripts(0, pageSize,
					condition);
			Map<String, String> titles = Collections
					.synchronizedMap(new LinkedHashMap<String, String>());
			titles.put("id", "ID");
			titles.put("createDate", "����ʱ��");
			titles.put("name", "�������");
			titles.put("number", "�ں�");
			titles.put("content", "Լ������");
			titles.put("endDate", "��ֹʱ��");
			titles.put("flag", "״̬");

			String result = JxlExcelUtil.excleOutWithTitle(msg,
					"D:\\�?���\\excel\\publish.xls", titles);
			response.getWriter().write(result);
			// request.getRequestDispatcher("/PublishServlet").forward(request,
			// response);
			// Լ����ϸ��Ϣ
		} else if ("look".equals(type)) {
			int id = Integer.parseInt(request.getParameter("id"));
			PublishService ps = new PublishServiceImpl();
			PublishDetail msg = ps.queryDetailById(id);
			System.out.println("msg��ID��"+msg.getId());
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Journal/look.jsp").forward(request,
					response);
			// �����ϸ��Ϣ
		} else if ("look2".equals(type)) {
			int maId = Integer.parseInt(request.getParameter("maId"));
			int id = Integer.parseInt(request.getParameter("id"));
			PublishService ps = new PublishServiceImpl();
			Msg_file_list msg = ps.queryFileDetailById(id);
			request.setAttribute("msg", msg);
			request.setAttribute("maId", maId);
			request.getRequestDispatcher("Journal/look2.jsp").forward(request,
					response);
			// Լ������ĸ���б�
		} else if ("filelist".equals(type)) {
			Map<String, String> condition = new HashMap<String, String>();
			String title = request.getParameter("title");
			String sendUser = request.getParameter("sendUser");
			String maId = request.getParameter("maId");
			if (title != null && !("null".equals(title))
					&& !("".equals(title.trim()))) {
				condition.put("title", title);
			}
			if (sendUser != null && !("null".equals(sendUser))
					&& !("".equals(sendUser.trim()))) {
				condition.put("sendUser", sendUser);
			}
			if (maId != null && !("null".equals(maId))
					&& !("".equals(maId.trim()))) {
				condition.put("maId", maId.toString());
			}
			int page = Integer
					.parseInt(request.getParameter("page") == null ? "1"
							: request.getParameter("page"));
			PublishService ps = new PublishServiceImpl();

			List<Msg_file_list> msg = ps.queryFileList(page, pageSize,
					condition);

			int[] counts = ps.queryFileListCount(pageSize, condition);
			int pageCount = counts[0];
			int count = counts[1];
			request.setAttribute("msg", msg);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("count", count);
			request.setAttribute("title", title);
			request.setAttribute("sendUser", sendUser);
			request.setAttribute("maId", maId);
			request.getRequestDispatcher("Journal/filelist.jsp").forward(
					request, response);
			// Լ����Ϣ�б�
		} else {
			Map<String, String> condition = new HashMap<String, String>();
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			if (name != null && !("null".equals(name))
					&& !("".equals(name.trim()))) {
				condition.put("name", name);
			}
			if (number != null && !("null".equals(number))
					&& !("".equals(number.trim()))) {
				condition.put("number", number);
			}
			int page = Integer
					.parseInt(request.getParameter("page") == null ? "1"
							: request.getParameter("page"));
			PublishService ps = new PublishServiceImpl();

			List<Msg_manuscripts> msg = ps.queryManuscripts(page, pageSize,
					condition);
			int[] counts = ps.queryManuscriptsCount(pageSize, condition);
			int pageCount = counts[0];
			int count = counts[1];
			request.setAttribute("msg", msg);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("count", count);
			request.setAttribute("name", name);
			request.setAttribute("number", number);
			request.getRequestDispatcher("Journal/listinfo3.jsp").forward(
					request, response);
		}

	}

}