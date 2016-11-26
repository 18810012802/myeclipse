package com.libo.dao.impl.yetong;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.libo.dao.yetong.MailBoxDao;
import com.libo.entity.Attach;
import com.libo.entity.Box;
import com.libo.entity.File_attach;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class MailBoxDaoImpl extends BaseDao implements MailBoxDao {

	@Override
	public List<Org_employee> getOthersByUserId(int uid) {
		List<Org_employee> oList = new ArrayList<Org_employee>();
		Org_employee orgEmployee = null;
		String sql = "select * from org_employee";
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				orgEmployee = new Org_employee();
				orgEmployee.setId(rs.getInt("id"));
				orgEmployee.setUsername(rs.getString("username"));
				oList.add(orgEmployee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return oList;
	}

	@Override
	public int sendEMail(Mail_box mailBox, int suid, int ruid) {
		int lastid = 0;
		String sql = "INSERT into mail_box(title,content,"
				+ "sendUserid,senddate,sendstate,receiveUserid)"
				+ " VALUE(?,?,?,NOW(),?,?)";
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mailBox.getTitle());
			pst.setString(2, mailBox.getContent());
			pst.setInt(3, suid);
			pst.setString(4, mailBox.getSendstate());
			pst.setInt(5, ruid);
			pst.executeUpdate();
			// 查询最后一次插入的数据的id
			String sql2 = "select LAST_INSERT_ID() lastid FROM mail_box;";
			pst = conn.prepareStatement(sql2);
			rs = pst.executeQuery();
			if (rs.next()) {
				lastid = rs.getInt("lastid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return lastid;
	}

	@Override
	public int countEmails(int uid, int re, Mail_box mailBox) {
		int num = 0;
		String sql = "select count(*) num from mail_box where";
		if (re == 0) {
			sql += " sendUserid=? and sendState=?";
		} else {
			sql += " sendUserid=?";
		}
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			if (re == 0) {
				pst.setString(2, mailBox.getSendstate());
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return num;
	}

	@Override
	public List<Mail_box> getByLike(int pageNum, int pageSize, int uid,
			Mail_box mailBox, int re) {
		List<Mail_box> mbList = new ArrayList<Mail_box>();
		Org_employee orgEmployee = null;
		String sql = "select mb.id as mbid, mb.title as title, "
				+ "mb.content as content,mb.sendDate as sendDate,"
				+ "mb.receiveDate as receiveDate,";
		if (re == 0) {
			// 是查发送的邮件
			sql += "oe.id as ruid,oe.username as receiveName"
					+ " FROM mail_box as mb"
					+ " INNER JOIN org_employee as oe on mb.receiveUserID=oe.id"
					+ " where sendUserid=? and sendState=?";
		} else {
			// 查接收的邮件
			sql += "mb.sendUserID as suid,oe.username as sendName,mb.receiveDate as receiveDate"
					+ " FROM mail_box as mb"
					+ " INNER JOIN org_employee as oe on mb.sendUserID=oe.id"
					+ " where receiveUserid=?";
		}
		if (StringUtils.isNotEmpty(mailBox.getTitle())) {
			if (StringUtils.isNotEmpty(mailBox.getContent())) {
				sql += " and mb.title like ? and mb.content like ?";
			} else {
				sql += " and mb.title like ?";
			}
		}
		sql += " limit ?,?";
		System.out.println("Sql语句是：" + sql);
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			if (re == 0) {
				pst.setString(2, mailBox.getSendstate());
				if (StringUtils.isNotEmpty(mailBox.getTitle())) {
					if (StringUtils.isNotEmpty(mailBox.getContent())) {
						pst.setString(3, "%" + mailBox.getTitle() + "%");
						pst.setString(4, "%" + mailBox.getContent() + "%");
						pst.setInt(5, (pageNum - 1) * pageSize);
						pst.setInt(6, pageSize);

					} else {
						pst.setString(3, "%" + mailBox.getTitle() + "%");
						pst.setInt(4, (pageNum - 1) * pageSize);
						pst.setInt(5, pageSize);
					}
				} else {
					pst.setInt(3, (pageNum - 1) * pageSize);
					pst.setInt(4, pageSize);
				}
			} else {
				pst.setInt(2, (pageNum - 1) * pageSize);
				pst.setInt(3, pageSize);
			}

			rs = pst.executeQuery();
			while (rs.next()) {
				orgEmployee = new Org_employee();
				if (re == 0) {
					orgEmployee.setId(rs.getInt("ruid"));
					orgEmployee.setUsername(rs.getString("receiveName"));
				} else {
					orgEmployee.setId(rs.getInt("suid"));
					orgEmployee.setUsername(rs.getString("sendName"));
				}

				mailBox = new Mail_box();
				mailBox.setId(rs.getInt("mbid"));
				mailBox.setTitle(rs.getString("title"));
				mailBox.setContent(rs.getString("content"));
				mailBox.setSendDate(rs.getDate("sendDate"));
				mailBox.setReceiveDate(rs.getDate("receiveDate"));
				mailBox.setOe(orgEmployee);
				mbList.add(mailBox);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return mbList;
	}

	@Override
	public Mail_box getById(int mbid, int re) {
		Mail_box mailBox = null;
		Org_employee orgEmployee = null;
		File_attach fileAttach = null;
		String sql = "SELECT mb.title as title,mb.sendDate as sendDate, mb.content as content,"
				+ "fa.`name` as fname,fa.filetype as ftype,fa.path as fpath,";
		if (re == 0) {// 是发件箱，要有收件人字段
			sql += "oe.username as ReceiveName";

		} else {
			sql += "oe.username as sendName";
		}
		sql += " from mail_box as mb";
		if (re == 0) {
			sql += " INNER JOIN org_employee oe on ReceiveUserId=oe.id";
		} else {
			sql += " INNER JOIN org_employee oe on sendUserId=oe.id";
		}
		sql += " INNER JOIN file_attach fa on fa.fileid=mb.id WHERE mb.id=?";
		System.out.println("info_sql:" + sql);
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mbid);
			rs = pst.executeQuery();
			if (rs.next()) {
				orgEmployee = new Org_employee();
				if (re == 0) {
					orgEmployee.setUsername(rs.getString("receiveName"));
				} else {
					orgEmployee.setUsername(rs.getString("sendName"));
				}
				fileAttach = new File_attach();
				fileAttach.setName(rs.getString("fname"));
				fileAttach.setFiletype(rs.getString("ftype"));
				fileAttach.setPath(rs.getString("fpath"));

				mailBox = new Mail_box();
				mailBox.setTitle(rs.getString("title"));
				mailBox.setContent(rs.getString("content"));

				mailBox.setOe(orgEmployee);
				mailBox.setFileAttach(fileAttach);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mailBox;
	}

	@Override
	public int deleteById(int mbid, int re) {
		int rows = 0;
		String sql = "update mail_box";
		if (re == 0) {// 发送方删邮件
			sql += " SET sendstate='"+re+"'";

		} else {
			sql += " set receiveState=1";
		}
		sql += " where id=?";
		getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mbid);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public List<Box> selectbox() {
		// 查询全部mail_box
		List<Box> list = new ArrayList<Box>();
		try {
			String sql = "SELECT * FROM mail_box ";
			getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Box box = new Box(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8),
						rs.getInt(9));
				list.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 添加邮件
	public int addbox(Box b) {
		int rows = 0;
		try {
			String sql = "INSERT INTO mail_box (title,content,sendUserID,sendDate,sendstate,ReceiveUserId,ReceiveDate,ReceiveState) VALUES(?,?,?,now(),?,?,now(),?)";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getContent());
			pst.setInt(3, b.getSenduserid());
			pst.setString(4, b.getSendstate());
			pst.setInt(5, b.getReceiveuserid());
			pst.setInt(6, b.getReceivestate());
			rows = pst.executeUpdate();
			if (rows > 0) {
				sql = "select LAST_INSERT_ID()";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				if (rs.next()) {
					rows = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

	// 模糊查询邮件
	public List<Box> mohubox(String clom, String key, String order,
			int currentpage, int pagesize, int receiveuserid) {
		List<Box> list = new ArrayList<Box>();
		try {
			String sql = "SELECT * FROM mail_box where ReceiveUserId=?";
			if (clom != null && !clom.equals("")) {
				sql += " and " + clom + " like ? ";
			}
			if (order != null && !order.equals("")) {
				sql += " order by " + order;
			}
			sql += " limit ?,?";
			getConnection();
			pst = conn.prepareStatement(sql);
			int num = 1;
			pst.setInt(num, receiveuserid);
			num++;
			if (clom != null && !clom.equals("")) {
				pst.setString(num, "%" + key + "%");
				num++;
			}
			pst.setInt(num, pagesize * (currentpage - 1));
			num++;
			pst.setInt(num, pagesize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Box box = new Box(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8),
						rs.getInt(9));
				list.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 按ID查询新闻
	public Box selectbox(int id) {
		Box box = null;
		try {
			String sql = "SELECT * FROM mail_box where id=? ";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				box = new Box(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getDate(5), rs.getString(6),
						rs.getInt(7), rs.getDate(8), rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return box;
	}

	// 删除邮件
	public int deletebox(int id) {
		int rows = 0;
		try {
			String sql = "delete from mail_box where id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

	@Override
	public int countbox(String clom, String key, int receiveuserid) {
		int rows = 0;
		try {
			String sql = "SELECT count(id) FROM mail_box where ReceiveUserId=?";
			if (clom != null && !clom.equals("")) {
				sql += " and " + clom + " like ?";
			}
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, receiveuserid);
			if (clom != null && !clom.equals("")) {
				pst.setString(2, "%" + key + "%");
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

	@Override
	public List<Box> selectreceiveuserid(int receiveuserid) {
		List<Box> list = new ArrayList<Box>();
		try {
			String sql = "select * from mail_box where ReceiveUserId=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, receiveuserid);
			rs = pst.executeQuery();
			while (rs.next()) {
				Box box = new Box(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8),
						rs.getInt(9));
				list.add(box);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public Attach selectattach(int fileid) {
		Attach attach = null;
		try {
			String sql = "SELECT * FROM file_attach WHERE menuID=19 AND fileID=? ";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fileid);
			rs = pst.executeQuery();
			while (rs.next()) {
				attach = new Attach(rs.getInt(1), rs.getDate(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return attach;
	}

	@Override
	public List<Box> senduseridmohu(String clom, String key, String order,
			int currentpage, int pagesize, int senduserid) {
		List<Box> list = new ArrayList<Box>();
		try {
			String sql = "SELECT * FROM mail_box where senduserid=? and sendState=1";
			if (clom != null && !clom.equals("")) {
				sql += " and " + clom + " like ? ";
			}
			if (order != null && !order.equals("")) {
				sql += " order by " + order;
			}
			sql += " limit ?,?";
			getConnection();
			pst = conn.prepareStatement(sql);
			int num = 1;
			pst.setInt(num, senduserid);
			num++;
			if (clom != null && !clom.equals("")) {
				pst.setString(num, "%" + key + "%");
				num++;
			}
			pst.setInt(num, pagesize * (currentpage - 1));
			num++;
			pst.setInt(num, pagesize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Box box = new Box(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8),
						rs.getInt(9));
				list.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public int countsendbox(String clom, String key, int senduserid) {
		int rows = 0;
		try {
			String sql = "SELECT count(id) FROM mail_box where sendUserID=? and sendState=1";
			if (clom != null && !clom.equals("")) {
				sql += " and " + clom + " like ?";
			}
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, senduserid);
			if (clom != null && !clom.equals("")) {
				pst.setString(2, "%" + key + "%");
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

}
