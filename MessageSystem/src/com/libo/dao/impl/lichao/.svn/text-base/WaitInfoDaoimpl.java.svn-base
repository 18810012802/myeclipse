package com.libo.dao.impl.lichao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.lichao.WaitInfoDao;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class WaitInfoDaoimpl extends BaseDao implements WaitInfoDao {

	/**
	 * 查询待审核的稿件
	 */
	public List<Msg_file> selectWaitInfo(int currentPage,int pageSize, String name,
			String number, String title) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		Msg_manuscripts msg=null;
		Org_employee og=null;
		try {
		String sql="SELECT mf.id,mf.title,mf.sendDate,mf.type,mf.filetype,mm.name,mf.number ,oe.username FROM msg_file mf INNER JOIN msg_manuscripts mm ON mf.maId=mm.id INNER JOIN org_employee oe ON oe.id=mf.sendUser WHERE mf.flag=1 and mf.state=2 or mf.state=0 ";
		if(name!=null){
			sql+=" AND mm.name LIKE '%"+name+"%'";
		}
		if(number!=null){
			sql+=" AND  mf.number LIKE '%"+number+"%'";
		}
		if(title!=null){
			sql+=" AND mf.title LIKE '%"+title+"%'";
		}
		sql+=" LIMIT ?,?";
		getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currentPage-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				msg=new Msg_manuscripts(rs.getString(6));
				og=new Org_employee(rs.getString(8));
				Msg_file ms=new Msg_file(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDate(3), og, msg);
				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 获取待审核的稿件总数
	 */

	@Override
	public int getWaitInfoCount(String name, String number, String title) {
		int rows=0;
		String sql="SELECT COUNT(mf.id) FROM msg_file mf INNER JOIN msg_manuscripts mm ON mf.maId=mm.id WHERE mf.flag= 1 and mf.state=0 ";
		if(name!=null){
			sql+=" AND mm.name LIKE '%"+name+"%'";
		}
		if(number!=null){
			sql+=" AND  mf.number LIKE '%"+number+"%'";
		}
		if(title!=null){
			sql+=" AND mf.title LIKE '%"+title+"%'";
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
	/**
	 * 按id查询位审核稿件的详情
	 */
	public List<Msg_file> selectWaitInfoById(int id) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		Msg_manuscripts msgman=null;
		Org_employee orgem=null;
		String sql="SELECT mf.number,mm.name,mf.author,mf.title,mf.type,mf.filetype,mf.content ,mf.sendDate,oe.username FROM msg_file mf INNER JOIN msg_manuscripts mm ON mf.maId=mm.id INNER JOIN org_employee oe ON oe.id=mf.sendUser WHERE mf.id=?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				msgman=new Msg_manuscripts(rs.getString(2));
				orgem=new Org_employee(rs.getString(9));
				Msg_file ms=new Msg_file( rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(1), rs.getDate(8), msgman, orgem);
				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 审核稿件
	 */
	public int checkWaitInfo(int id, int state) {
		int rows=0;
		String sql="UPDATE msg_file SET state=? WHERE id=?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setInt(2, id);
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
}
