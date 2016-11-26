package com.libo.dao.impl.yetong;

import java.sql.SQLException;

import com.libo.dao.yetong.AttachDao;
import com.libo.entity.Attach;
import com.libo.util.BaseDao;

public class AttachDaoImpl extends BaseDao implements AttachDao {
	// 上传文件的方法 添加文件表
	public int addattach(Attach a) {
		int rows = 0;
		try {
			String sql = "INSERT INTO file_attach (createDate,path,menuID,fileID) values (now(),?,19,?)";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, a.getPath());
			pst.setInt(2, a.getFileid());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

}
