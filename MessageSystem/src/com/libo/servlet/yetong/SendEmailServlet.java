package com.libo.servlet.yetong;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.libo.entity.File_attach;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.yetong.MailBoxService;

public class SendEmailServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Org_employee oEmployee=(Org_employee) request.getSession().getAttribute("org_employee");
		Integer uid=0;
		if (oEmployee!=null) {
			uid=oEmployee.getId();
		}
		MailBoxService mailBoxService = new MailBoxServiceImpl();

		List<Org_employee> list = mailBoxService.getOthersByUserId(uid);
		PrintWriter out = response.getWriter();
		if (list.size() > 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("Email/sendemail.jsp").forward(
					request, response);
		} else {
			out.print("<script>location.href='Email/sendemail.jsp';alert('通讯录中没有任何好友，无法发送邮件!!');</script>");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		MailBoxService mailBoxService = new MailBoxServiceImpl();

		// 准备工作
		// 1、设置上传路径不存在则新建路径
		String filePath = this.getServletContext().getRealPath("/upload");
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 2、设置缓存目录,不存在则新建
		String tempPath = this.getServletContext().getRealPath("/temp");
		File tempFile = new File(tempPath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}

		// 3、设置上传文件大小<5m
		long fileSize = 1024 * 1024 * 5;
		// 4、设置上传文件类型
		List<String> types = new ArrayList<String>();
		types.add("txt");
		types.add("doc");
		types.add("gif");
		// 准备结束，开始上传
		// 1、获得上传组件
		FileItemFactory fif = new DiskFileItemFactory(4096, tempFile);
		ServletFileUpload sfu = new ServletFileUpload(fif);
		// 2、开始校验
		String reStr=null;
		// 菜单id在插入文件信息的时候使用
		String mnid = null;
		int menuid = 0;
		// 发送邮件的人的id
		String sid = null;
		int suid = 0;
		// 接收邮件的人的id
		String rid = null;
		int ruid = 0;
		// 邮件标题与内容
		String title = null;
		String content = null;
		// 上传文件类型
		String type = null;
		// 文件名
		String fileName = null;
		// 验证是不是正常的上传表单
		if (sfu.isMultipartContent(request)) {
			try {
				List<FileItem> files = sfu.parseRequest(request);
				// 循环判断上传的数据是普通数据，还是上传文件数据
				for (FileItem fileItem : files) {
					if (fileItem.isFormField()) {
						if (fileItem.getFieldName().equals("menuid")) {
							mnid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("suid")) {
							sid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("ruid")) {
							rid = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("title")) {
							title = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("reStr")) {
							reStr = fileItem.getString("utf-8");
						}
						if (fileItem.getFieldName().equals("content")) {
							content = fileItem.getString("utf-8");
						}
					} else {
						// 是上传文件数据的情况，则接受文件名
						fileName = fileItem.getName();
						if (fileName != null) {
							// 如果fileName不等于null,截取类型验证是否为可上传类型
							type = fileName
									.substring(fileName.lastIndexOf(".") + 1);
							if (!types.contains(type)) {
								// 不可上传类型提示
								out.print("<script>location.href=location.href='SendEmailServlet?suid="
										+ suid
										+ "';alert('文件类型只能是gif、doc、txt');</script>");
							} else {
								// 可上传类型，验证文件大小是否超限
								if (fileItem.getSize() < fileSize) {
									// 上传文件
									File finalPath = new File(filePath + "//"
											+ fileName);
									fileItem.write(finalPath);
									//调用添加附件方法！！！！！！
									out.print("<script>alert('上传成功！！');</script>");
								} else {
									out.print("<script>location.href='SendEmailServlet?suid="
											+ suid
											+ "';alert('上传文件不得大于5m');</script>");
								}
							}

						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 拿到msgFile的id和uid以便类型或大小不合适时返回上传界面
		//int id=Integer.parseInt(request.getParameter("sid"));
		//suid = Integer.parseInt("sid");
		//ruid = Integer.parseInt("rid");
		//menuid=Integer.parseInt("mnid");
		if (StringUtils.isEmpty(title)) {
			out.print("<script>location.href='SendEmailServlet?suid=" + suid
					+ "';alert('标题不能为空！！');</script>");
		} else {
			if(sid!=null){
				suid=Integer.parseInt(sid);
			}
			if(rid!=null){
				ruid=Integer.parseInt(rid);
			}
			//
			Mail_box mailBox=new Mail_box();
			mailBox.setTitle(title);
			mailBox.setContent(content);
			mailBox.setSendstate("1");

			// 附件
			File_attach fileAttach = new File_attach();
			String path = filePath + "/" + fileName;
			fileAttach.setPath(path);
			fileAttach.setName(fileName);
			fileAttach.setFiletype(type);
			fileAttach.setMenuId(menuid);
			System.out.println("munuid="+menuid);
			//
			//传递mailbox、fileAttach、发送人id 、接收人id
			//suid = Integer.parseInt("suid");
			//ruid = Integer.parseInt("");
			int row = mailBoxService.sendEMail(mailBox,fileAttach,suid,ruid);
			
				if (StringUtils.isEmpty(reStr)) {
					reStr="1";
				}
				int re=Integer.valueOf(reStr);
			if (row > 0) {
				if (re==0) {
					//收件箱                                                                                                                       
					out.print("<script>location.href='ShowReceiveEmailsServlet';alert('发送成功！！');</script>");
				}else {
					out.print("<script>location.href='ShowEmailsByLikeServlet';alert('发送成功！！');</script>");
				}
			} else {
				out.print("<script>location.href='SendEmailServlet?suid=" + suid
						+ "';alert('发送失败！');</script>");
			}
		}

	}

}
