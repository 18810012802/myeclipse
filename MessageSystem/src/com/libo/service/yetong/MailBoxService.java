package com.libo.service.yetong;

import java.util.List;

import com.libo.entity.Attach;
import com.libo.entity.Box;
import com.libo.entity.File_attach;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;

public interface MailBoxService {

	public List<Org_employee> getOthersByUserId(int uid);

	public int sendEMail(Mail_box mailBox, File_attach fileAttach, int suid,
			int ruid);

	public int countEmails(int uid, int re, Mail_box mailBox);

	public List<Mail_box> getByLike(int pageNum, int pageSize, int suid,
			Mail_box mailBox, int re);

	public Mail_box getById(int mbid, int re);

	public int deleteById(int mbid, int re);

	public List<Box> selectbox();

	public int addbox(Box b);

	public List<Box> mohubox(String clom, String key, String order,
			int currentpage, int receiveuserid);

	public Box selectbox(int id);

	public int deletebox(int id);

	public int countbox(String clom, String key, int receiveuserid);

	public List<Box> selectreceiveuserid(int receiveuserid);

	public int addattach(Attach a);

	public Attach selectattach(int fileid);

	public List<Box> senduseridmohu(String clom, String key, String order,
			int currentpage, int pagesize, int senduserid);

	public int countsendbox(String clom, String key, int senduserid);
}
