package com.lib.dao.impl.t;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.dao.t.File_attachDao;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_file;
import com.libo.util.BaseDao;

public class File_attachDaoImpl extends BaseDao implements File_attachDao {

	@Override
	public List<File_attach> selectAllByMenuId(int mid) {
		List<File_attach> list=new ArrayList<File_attach>();
		try {
		String sql="select * from file_attach where menuid=? ";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, mid);
		rs=pst.executeQuery();
		while(rs.next()){
			File_attach f=new File_attach(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
			list.add(f);
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
	public int addAll(File_attach fie) {
		int rows=0;
		//¿Ó≥¨–¥¡À
		return rows;
	}

	@Override
	public File_attach selectAllByMFid(File_attach file) {
		File_attach list=null;
		try {
		String sql="select * from file_attach where menuid=? and fileid=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, file.getMenuId());
		pst.setInt(2, file.getFileId());
		rs=pst.executeQuery();
		while(rs.next()){
		list=new File_attach(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
