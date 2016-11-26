package com.libo.service.impl.yetong;

import java.util.List;

import com.libo.dao.impl.yetong.AttachDaoImpl;
import com.libo.dao.impl.yetong.MailBoxDaoImpl;
import com.libo.dao.impl.yetong.OrgEmployeeSearchDaoImpl;
import com.libo.dao.yetong.AttachDao;
import com.libo.dao.yetong.MailBoxDao;
import com.libo.dao.yetong.OrgEmployeeSearchDao;
import com.libo.entity.Attach;
import com.libo.entity.Box;
import com.libo.entity.File_attach;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.yetong.MailBoxService;
import com.libo.util.PageUtil;

public class MailBoxServiceImpl implements MailBoxService {
	MailBoxDao mailBoxDao=new MailBoxDaoImpl();
	OrgEmployeeSearchDao oed = new OrgEmployeeSearchDaoImpl();
	AttachDao attach = new AttachDaoImpl();
	@Override
	public List<Org_employee> getOthersByUserId(int uid) {
		// TODO Auto-generated method stub
		return mailBoxDao.getOthersByUserId(uid);
	}

	@Override
	public int sendEMail(Mail_box mailBox, File_attach fileAttach, int suid,
			int ruid) {
		// TODO Auto-generated method stub
		int lastid=mailBoxDao.sendEMail(mailBox,suid,ruid);
		//if (lastid>0) {
			//fileAttach.setFileId(lastid);
			//FileAttachDao fileAttachDao=new FileAttachDaoImpl();
			//return fileAttachDao.insertFileAttach(fileAttach);
		//}else {
			//return lastid;
		//}
		return lastid;
	}

	@Override
	public int countEmails(int uid, int re, Mail_box mailBox) {
		// TODO Auto-generated method stub
		return mailBoxDao.countEmails(uid, re, mailBox);
	}

	@Override
	public List<Mail_box> getByLike(int pageNum, int pageSize, int uid,
			Mail_box mailBox, int re) {
		// TODO Auto-generated method stub
		return mailBoxDao.getByLike(pageNum, pageSize, uid, mailBox, re);
	}

	@Override
	public Mail_box getById(int mbid, int re) {
		// TODO Auto-generated method stub
		return mailBoxDao.getById(mbid, re);
	}

	@Override
	public int deleteById(int mbid, int re) {
		// TODO Auto-generated method stub
		return mailBoxDao.deleteById(mbid, re);
	}

	public List<Box> selectbox() {
		// TODO Auto-generated method stub
		return mailBoxDao.selectbox();
	}
	@Override
	public int addbox(Box b) {
		// TODO Auto-generated method stub
		return mailBoxDao.addbox(b);
	}
	@Override
	public List<Box> mohubox(String clom,String key,String order,int currentpage,int receiveuserid) {
		// TODO Auto-generated method stub
		return mailBoxDao.mohubox(clom, key, order, currentpage, PageUtil.PAGESIZE,receiveuserid );
	}
	@Override
	public Box selectbox(int id) {
		// TODO Auto-generated method stub
		return mailBoxDao.selectbox(id);
	}
	@Override
	public int deletebox(int id) {
		// TODO Auto-generated method stub
		return mailBoxDao.deletebox(id);
	}
	@Override
	public int countbox(String clom,String key,int receiveuserid) {
		// TODO Auto-generated method stub
		return mailBoxDao.countbox(clom, key, receiveuserid);
	}
	@Override
	public List<Box> selectreceiveuserid(int receiveuserid) {
		// TODO Auto-generated method stub
		return mailBoxDao.selectreceiveuserid(receiveuserid);
	}
	@Override
	public int addattach(Attach a) {
		// TODO Auto-generated method stub
		return attach.addattach(a);
	}
	@Override
	public Attach selectattach(int fileid) {
		// TODO Auto-generated method stub
		return mailBoxDao.selectattach( fileid);
	}
	@Override
	public List<Box> senduseridmohu(String clom, String key, String order,
			int currentpage, int pagesize, int senduserid) {
		// TODO Auto-generated method stub
		return mailBoxDao.senduseridmohu(clom, key, order, currentpage, pagesize, senduserid);
	}
	@Override
	public int countsendbox(String clom, String key, int senduserid) {
		// TODO Auto-generated method stub
		return mailBoxDao.countsendbox(clom, key, senduserid);
	}



}
