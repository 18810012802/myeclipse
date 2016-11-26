package com.lib.dao.impl.t;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.dao.t.Msg_ManuscriptsDao;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class Msg_ManuscriptsDaoimpl extends BaseDao implements
		Msg_ManuscriptsDao {

	//约稿信息查询
	public List<Msg_manuscripts> selectAllByName(int currPage, int pageSize, String name, String number) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		Org_employee or=null;
		try {
			String sql="SELECT m.id,m.createdate,m.name,m.number,m.content,m.enddate,m.senduserid,m.state,m.flag,o.loginname,o.username FROM msg_manuscripts m INNER JOIN org_employee o ON m.senduserid=o.id WHERE  m.state=1  AND m.id NOT IN(SELECT manuscriptsid FROM msg_receive)  ";
			if(name!=null||number!=null){
				sql+=" and m.name like '%"+name+"%' and m.number like '%"+number+"%'";
			}
			if(currPage>0){
				sql+=" limit ?,? ";
			}
			getConnection();
			pst=conn.prepareStatement(sql);
			if(currPage>0){
				pst.setInt(1, (currPage-1)*pageSize);
				pst.setInt(2, pageSize);
			}
			rs=pst.executeQuery();
			while(rs.next()){
				or=new Org_employee(rs.getString(10), rs.getString(11));
				Msg_manuscripts ma=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),or);
				list.add(ma);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		return list;
	}

	@Override
	public List<Msg_manuscripts> selectAll() {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		try {
			String sql="select * from msg_manuscripts where state=1 and flag=0";
			getConnection();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts ma=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(ma);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		return list;
	}

	@Override
	public List<Msg_manuscripts> selectAllByMid(int msid) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		try {
			String sql="select * from msg_manuscripts where id=?";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, msid);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts ma=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(ma);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		return list;
	}

	@Override
	public List<Msg_manuscripts> selectAllByMid(int currPage, int pageSize) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		try {
			String sql="select * from msg_manuscripts where state=1 and flag=0";
			sql+=" limit ?,? ";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currPage-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts ma=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(ma);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		return list;
	}

	@Override
	public List<Msg_manuscripts> selectAllByRMid(int currPage, int pageSize,int userid,
			String name, String number, Date sendDate, Date receDate) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		try {
		String sql="SELECT m.id,m.createdate,m.name,m.number,m.content,m.enddate,m.senduserid,m.state,m.flag FROM msg_manuscripts m INNER JOIN msg_receive ms ON m.id=ms.manuscriptsid WHERE m.flag=0 AND m.state=1 AND ms.state=0 ";
		if(name!=null){
			sql+=" and m.name like '%"+name+"%'";
		}
		if(number!=null){
			sql+=" and m.number like '%"+number+"%'";
		}
		if(sendDate!=null){
			sql+=" and m.createdate like '%"+sendDate+"%'";
		}
		if(userid>0){
			sql+=" and ms.editUserId="+userid;
		}
		if(receDate!=null){
			sql+=" and ms.editdate like '%"+receDate+"%'";
		}
		if(currPage>0){
			sql+=" limit ?,? ";
		}
		getConnection();
		pst=conn.prepareStatement(sql);
		if(currPage>0){
			pst.setInt(1, (currPage-1)*pageSize);
			pst.setInt(2, pageSize);
		}
		rs=pst.executeQuery();
		while(rs.next()){
			Msg_manuscripts ma=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			list.add(ma);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public Msg_manuscripts selectAllByMdid(int msid) {
		Msg_manuscripts list=null;
		try {
			String sql="select * from msg_manuscripts where id=?";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, msid);
			rs=pst.executeQuery();
			while(rs.next()){
				list=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
		return list;
	}

	
}
