package com.libo.dao.impl.lichao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.lichao.YetInfoDao;
import com.libo.entity.Msg_manuscripts;
import com.libo.util.BaseDao;

public class YetInfoDaoImpl extends BaseDao implements YetInfoDao {
	/**
	 * 查询意审核的约稿
	 */
	public List<Msg_manuscripts> queryYetInfo(int currentPage,int pageSize,String name,String number) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		String sql="SELECT*FROM msg_manuscripts WHERE state =1";
		if(name!=null){
			sql+=" AND  NAME LIKE '%"+name+"%' ";
		}
		if(number!=null){
			sql+=" AND number LIKE '%"+number+"%'";
		}
		sql+=" LIMIT ?,?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currentPage-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts msg=new Msg_manuscripts(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获得已审核约稿的总数
	 */
	public int getYetInfoCount(String name,String number) {
		int rows =0;
		String sql="SELECT count(id) FROM msg_manuscripts WHERE state =1";
		if(name!=null){
			sql+=" AND  NAME LIKE '%"+name+"%' ";
		}
		if(number!=null){
			sql+=" AND number LIKE '%"+number+"%'";
		}
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}


	public int subCheck(int id) {
		int rows=0;
		String sql="UPDATE msg_manuscripts SET flag=1  WHERE id =?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public List<Msg_manuscripts> selectYetInfoByExcel(int id) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		String sql="SELECT *FROM msg_manuscripts where flag=1 ";
		if(id!=0){
			sql+=" and id ='"+id+"'";
		}
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts m= new Msg_manuscripts(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}


