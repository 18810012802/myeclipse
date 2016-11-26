package com.libo.dao.impl.lichao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.lichao.MsgFileDao;
import com.libo.entity.Msg_file;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class MsgFileDaoImpl extends BaseDao implements MsgFileDao {

	@Override
	public List<Msg_file> selectMinuteInfo(int currentPage,int pageSize,int maid,String title,String user) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		Org_employee orgem =null;
		String sql="SELECT  mf.id,mf.title,oe.username,mf.sendDate,mf.type,mf.filetype FROM msg_file mf INNER JOIN org_employee oe ON mf.sendUser =oe.id WHERE mf.maId=?";
		if(title!=null){
			sql+=" AND mf.title LIKE '%"+title+"%'";
		}
		if(user!=null){
			sql+=" AND oe.username LIKE '%"+user+"%'";
		}
		sql+=" LIMIT ?,?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maid);
			pst.setInt(2, (currentPage-1)*pageSize);
			pst.setInt(3, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				orgem=new Org_employee(rs.getString(3));
				Msg_file ms=new Msg_file(rs.getInt(1), rs.getString(2), rs.getString(6), rs.getString(5), rs.getDate(4), orgem);
				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getMinute(int maid, String title, String user)  {
		int rows=0;
		String sql="SELECT  COUNT(mf.id)FROM msg_file mf INNER JOIN org_employee oe ON mf.sendUser =oe.id WHERE mf.maId=?";
		if(title!=null){
			sql+=" AND mf.title LIKE '%"+title+"%'";
		}
		if(user!=null){
			sql+=" AND oe.username LIKE '%"+user+"%'";
		}
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maid);
			rs=pst.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

}
