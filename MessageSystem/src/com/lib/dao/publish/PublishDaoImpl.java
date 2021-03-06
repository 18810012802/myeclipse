package com.lib.dao.publish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.libo.entity.Msg_file_list;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.PublishDetail;
import com.libo.util.BaseDao;

public class PublishDaoImpl extends BaseDao implements PublishDao {

	@Override
	public List<Msg_manuscripts> queryManuscripts(int page, int pageSize,
			Map<String, String> condition) {
		// TODO Auto-generated method stub
		/**
		 * ��ѯ��ͨ������������˵�Լ���б�
		 */
		List<Msg_manuscripts> list = new ArrayList<Msg_manuscripts>();
		try {
			String sql = "select id,createDate,name,number,content,endDate,sendUserId,state,flag from msg_manuscripts where state=1 and flag <> 0";
			if (condition.size() > 0) {
				sql += " and";
				for (String key : condition.keySet()) {
					sql += " " + key + " like '%" + condition.get(key)
							+ "%' and";
				}
				sql = sql.substring(0, sql.length() - 3);
			}
			if (page > 0) {
				sql += " limit ?,?";
			}

			getConnection();
			pst = conn.prepareStatement(sql);
			if (page > 0) {
				pst.setInt(1, (page - 1) * pageSize);
				pst.setInt(2, pageSize);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Msg_manuscripts mm = new Msg_manuscripts(rs.getInt(1),
						rs.getDate(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9));
				list.add(mm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	/**
	 * ��ѯ��ͨ������������˵�Լ���б��¼����
	 */
	public int queryManuscriptsCount(Map<String, String> condition) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			String sql = "select count(*) from msg_manuscripts where state=1 and flag <> 0";
			if (condition.size() > 0) {
				sql += " and";
				for (String key : condition.keySet()) {
					sql += " " + key + " like '%" + condition.get(key)
							+ "%' and";
				}
				sql = sql.substring(0, sql.length() - 3);
			}
			getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			count = Integer.parseInt(rs.getString(1));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}

	/**
	 * ��ѯԼ������
	 */
	public PublishDetail queryDetailById(int id) {
		PublishDetail pd = null;
		try {
			String sql = "SELECT mm.id,mf.createDate,mm.name,mm.number,mm.content,mm.endDate,mm.state,oe.username,fa.name,fa.path FROM msg_manuscripts mm,msg_file mf,org_employee oe,file_attach fa WHERE mf.maid=mm.id AND mm.sendUserId=oe.id AND mm.id=fa.fileID AND mm.id="
					+ id;

			getConnection();
			pst = conn.prepareStatement(sql);
			// pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next())
				pd = new PublishDetail(rs.getInt(1), rs.getDate(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getString(8),
						rs.getString(9), rs.getString(10));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return pd;
	}

	/**
	 * ��ѯ�����ύ�ġ������������ϱ��ĸ���б�
	 */
	@Override
	public List<Msg_file_list> queryFileList(int page, int pageSize,
			Map<String, String> condition) {
		// TODO Auto-generated method stub

		List<Msg_file_list> list = new ArrayList<Msg_file_list>();
		try {
			String sql = "SELECT mf.id,mf.title,mf.type,mf.filetype,mf.sendDate,oe.username FROM msg_file mf,org_employee oe WHERE mf.flag=1 and mf.state <> 0 and mf.sendUser=oe.id";
			if (condition.size() > 0) {
				sql += " and";
				for (String key : condition.keySet()) {
					if ("maId".equals(key)) {
						sql += " maId=" + condition.get(key) + " and";
					} else {
						if ("sendUser".equals(key)) {
							sql += " username like '%" + condition.get(key)
									+ "%' and";
						} else {
							sql += " " + key + " like '%" + condition.get(key)
									+ "%' and";
						}
					}
				}
				sql = sql.substring(0, sql.length() - 3);
			}
			if (page > 0) {
				sql += " limit ?,?";
			}
			getConnection();
			pst = conn.prepareStatement(sql);
			if (page > 0) {
				pst.setInt(1, (page - 1) * pageSize);
				pst.setInt(2, pageSize);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Msg_file_list mfl = new Msg_file_list(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getString(6));
				list.add(mfl);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
		return list;
	}

	/**
	 * ��ѯ�����ύ�ġ������������ϱ��ĸ���б��¼����
	 */
	public int queryFileListCount(Map<String, String> condition) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			String sql = "select count(*) FROM msg_file mf,org_employee oe WHERE mf.flag=1 and mf.state <> 0 and mf.sendUser=oe.id and mf.state=1";
			if (condition.size() > 0) {
				sql += " and";
				for (String key : condition.keySet()) {

					if ("maId".equals(key)) {
						sql += " maId=" + condition.get(key) + " and";
					} else {
						if ("sendUser".equals(key)) {
							sql += " username like '%" + condition.get(key)
									+ "%' and";
						} else {
							sql += " " + key + " like '%" + condition.get(key)
									+ "%' and";
						}
					}
				}
				sql = sql.substring(0, sql.length() - 3);
			}
			getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			count = Integer.parseInt(rs.getString(1));
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
		return count;
	}

	/**
	 * ͨ��ID��ѯ�������
	 */
	public Msg_file_list queryFileDetailById(int id) {
		Msg_file_list mfl = null;
		try {
			String sql = "SELECT mf.id,mf.title,mf.type,mf.filetype,mm.createDate,mf.author,mm.content,mf.state FROM msg_file mf,msg_manuscripts mm WHERE mf.maId=mm.id AND mf.id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next())
				mfl = new Msg_file_list(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return mfl;
	}

	/**
	 * ���״̬��Ϣ
	 */
	@Override
	public String check(String table, String field, int value, int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE " + table + " SET " + field + "=? WHERE id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, value);
			pst.setInt(2, id);
			int re = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return "����ʧ�ܣ�";
		} finally {
			close();
		}
		return "�����ɹ���";
	}

	/**
	 * ���Լ��ID��ĸ��״̬��Ϣ
	 * 
	 * @return
	 */
	@Override
	public boolean checkFile(int maId, String field, int value) {

		try {
			String sql = "UPDATE msg_file SET " + field
					+ " = ? WHERE flag = 1 and state <> 0 and maId=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, value);
			pst.setInt(2, maId);
			int re = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
			close();
		}
		return true;
	}

}
