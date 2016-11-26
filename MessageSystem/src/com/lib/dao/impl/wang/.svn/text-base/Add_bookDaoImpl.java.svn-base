package com.lib.dao.impl.wang;

import java.util.ArrayList;
import java.util.List;

import com.lib.dao.wangchangcheng.Add_bookDao;
import com.libo.entity.Add_book;
import com.libo.util.BaseDao;

 

public class Add_bookDaoImpl extends BaseDao implements Add_bookDao {
	// 闁跨喐鏋婚幏鐑芥晸闁扮偣鍓抽崼鐢点�閹风兘鏁撴潏鍐挎嫹
	public int add(Add_book book) {
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

	// 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柅姘愁唵瑜版洟鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归幁锟�	
		public int updateById(Add_book book) {
		int rows = 0;
		try {
			String sql = "update add_book set createDate=now(),name=?,telephone=?,sex=?,birthday=? email=? address=? state=?  where createUserId=?";
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

	// 閸掔娀鏁撻弬銈嗗闁跨喐鏋婚幏閿嬩紖
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

	}

	// 闁跨喐鏋婚幏椋庛仛闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹烽攱浼�
	public List<Add_book> select(int currentPage, int pageSize, int userId) {
		List<Add_book> list = new ArrayList<Add_book>();
		Add_book books=null;
		try {
			if(userId==0){String sql = "SELECT distinct * FROM add_book limit ?,?";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currentPage-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();}
			else{
				String sql="select * from add_book where createUserId=? limit ?,?";
				getConnection();
				pst=conn.prepareStatement(sql);
				pst.setInt(1, userId);
				pst.setInt(2, (currentPage-1)*pageSize);
				pst.setInt(3, pageSize);
				rs=pst.executeQuery();
			}
			while (rs.next()) {
				books=new Add_book(rs.getInt("id"),rs.getDate("createDate"), rs.getInt("createUserId"), rs.getString("NAME"), rs.getString("telphone"), rs.getString("sex"),rs.getString("Birthday"), rs.getString("email"), rs.getString("address"), rs.getInt("state"));
				
				list.add(books);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//闁跨喎褰ㄧ拋瑙勫闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹凤拷
	public int selectRows(int userid) {
		// TODO Auto-generated method stub
		int rows=0;
		try {
			String sql = "select count(id) from add_book";
			if (userid != 0) {
				sql = " where CreateUserId=" + userid;

			}
			getConnection();
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close();
		}
		return rows;
	}
	public Add_book selectById(int id){
		Add_book book=null;
		try {
			
			String sql = "select * from add_book where id=?";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				book=new Add_book(rs.getDate("createDate"), rs.getInt("createUserId"),
	rs.getString("name"), rs.getString("telphone"), rs.getString("sex"),
	rs.getString("birthday"), rs.getString("email"), rs.getString("address"),
	rs.getInt("state"));}} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close();
		}
		return book;}
	// 濡繝鏁撻弬銈嗗闁跨喓鐛ら敓锟�
		public List<Add_book> query(String str,int i) {
		List<Add_book> list = new ArrayList<Add_book>();
		Add_book book = new Add_book();
		try {
			String sql = "select * from add_book where name like '?' or where telphone like '?'";
			getConnection();
			if(str!=null){
				pst.setString(1, "%" + str + "%");
			if(i!=0){
				pst.setString(2, "%" + str + "%");
			}else{
				pst.setString(2, null);
			}
			}else{
				if(i!=0){
					pst.setString(2, "%" + i + "%");
				}
			}
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				book = new Add_book(rs.getDate("createDate"), rs.getInt("createUserId"), rs.getString("NAME"), rs.getString("telphone"), rs.getString("sex"),rs.getString("Birthday"), rs.getString("email"), rs.getString("address"), rs.getInt("state"));
			list.add(book);}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
		return list;
		
	}
}
