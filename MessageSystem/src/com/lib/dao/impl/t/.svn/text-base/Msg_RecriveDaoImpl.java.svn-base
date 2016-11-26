package com.lib.dao.impl.t;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.dao.t.Msg_ReceiveDao;
import com.libo.entity.Msg_receive;
import com.libo.util.BaseDao;

public class Msg_RecriveDaoImpl extends BaseDao implements Msg_ReceiveDao {

	@Override
	public int addRece(Msg_receive msRece) {
		int rows=0;
		try {
		String sql="INSERT INTO msg_receive (editdate,edituserid,manuscriptsid,state) VALUE (NOW(),?,?,?) ";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, msRece.getEditUserId());
		pst.setInt(2, msRece.getManuscriptsId());
		pst.setInt(3, msRece.getState());
		rows=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return rows;
	}

	@Override
	public List<Msg_receive> selectByUserId(int uid,int userid) {
		List<Msg_receive> list=new ArrayList<Msg_receive>();
		try {
		String sql="select * from Msg_receive where manuscriptsid=? and edituserid=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, uid);
		pst.setInt(2, userid);
		rs=pst.executeQuery();
		while(rs.next()){
			Msg_receive ms=new Msg_receive(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			list.add(ms);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	//ÉÏ´«ÐÞ¸Ä×´Ì¬
	public int update(int userid, int manid) {
		int rows=0;
		try {
		String sql="update msg_receive set state=2 where edituserid=? and manuscriptsid=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, userid);
		pst.setInt(2,manid);
		rows=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return rows;
	}

}
