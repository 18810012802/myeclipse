package com.lib.dao.wangchangcheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.libo.entity.Add_book;
import com.libo.util.BaseDao;

public class InnerDaoImpl extends BaseDao{
	public List<Add_book> queryInnerList(int page, int pageSize,
			Map<String,String> condition){
		List<Add_book> list = new ArrayList<Add_book>();
		try {
			String sql = "select id,name,sex,birthday,telphone,address,email from add_book";
			if (condition.size() > 0) {
				sql += " where";
				for (String key : condition.keySet()) {
					/*sql += " " + key + " like '%" + condition.get(key)
							+ "%' and";*/
					if ("createUserId".equals(key)) {
						sql += " "+key+" = " + condition.get(key)
								+ " and";
					} else {
						sql += " " + key + " like '%" + condition.get(key)
								+ "%' and";
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
				Add_book mm = new Add_book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				list.add(mm);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
		return list;
	}
	public int[] queryInnerCount(int pageSize,Map<String, String> condition) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			String sql = "select count(*) from add_book";
			if (condition.size() > 0) {
				sql += " where";
				for (String key : condition.keySet()) {
					if ("createUserId".equals(key)) {
						sql += " "+key+" = " + condition.get(key)
								+ " and";
					} else {
						sql += " " + key + " like '%" + condition.get(key)
								+ "%' and";
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
		return new int[] {
				count % pageSize == 0 ? count / pageSize : count / pageSize + 1,
				count };
	}
	
	public int deleteById(int id) {
		int rows = 0;
		try {
			String sql = "delete from add_book where id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rows = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rows;

	}public int add(Add_book book) {
		int rows = 0;
		try {
			String sql = "insert into add_book(createDate,createUserId,name,telephone,sex,birthday,email,address,state)  values(now(),?,?,?,?,?,?,?,?)";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, book.getCreateUserId());
			pst.setString(2, book.getName());
			pst.setString(3, book.getTelphone());
			pst.setString(4, book.getSex());
			pst.setString(5, book.getBirthday());
			pst.setString(6, book.getEmail());
			pst.setString(7, book.getAddress());
			pst.setInt(8, book.getState());
			rows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return rows;

	}

	// ����ͨѶ¼������Ϣ
	public int updateById(Add_book book) {
		int rows = 0;
		try {
			String sql = "update add_book set createDate=now(),name=?,telphone=?,sex=?,birthday=? email=? address=? state=?  where createUserId=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setString(2, book.getTelphone());
			pst.setString(3, book.getSex());
			pst.setString(4, book.getBirthday());
			pst.setString(5, book.getEmail());
			pst.setString(6, book.getAddress());
			pst.setInt(7, book.getState());
			pst.setInt(8, book.getCreateUserId());
			rows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return rows;

	}

}
