package com.libo.dao.impl.lichao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.lichao.InfoDao;
import com.libo.entity.Msg_manuscripts;
import com.libo.util.BaseDao;


public class InfoDaoImpl extends BaseDao implements InfoDao {

	/**
	 * 发布稿件
	 */
	public int addInfo(Msg_manuscripts ms) {
		int rows=0;
		String sql="INSERT INTO msg_manuscripts(createDate,NAME,number,content,endDate,senduserId,state,flag)" +
				"VALUE(NOW(),?,?,?,?,?,?,0)";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ms.getName());
			pst.setString(2, ms.getNumber());
			pst.setString(3, ms.getContent());
			pst.setDate(4, ms.getEndDate());
			pst.setInt(5, ms.getSendUserId());
			pst.setInt(6, ms.getState());
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return rows;
	}

	/**
	 * 显示稿件
	 */
	public List<Msg_manuscripts> queryInfo(int currentPage, int pageSize,String name,String number,Date newDate,Date endDate) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		String sql="SELECT *FROM msg_manuscripts where 1=1";
		if(name!=null){
			sql+=" and NAME LIKE '%"+name+"%'";
		}
		if(number!=null){
			sql+=" and number like '%"+number+"%'";
		}
		if(newDate!=null){
			sql+=" and createDate like '%"+newDate+"%'";
		}
		if(endDate!=null){
			sql+=" and endDate like '%"+endDate+"%'";
		}
		sql+=" LIMIT ?,? ";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currentPage-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts m= new Msg_manuscripts(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取总条数的方法
	 */
	public int getPageCout(String name,String number,Date newDate,Date endDate) {
		int rows=0;
			String sql="select count(id) from msg_manuscripts where 1=1";
			if(name!=null){
				sql+=" and NAME LIKE '%"+name+"%'";
			}
			if(number!=null){
				sql+=" and number like '%"+number+"%'";
			}
			if(newDate!=null){
				sql+=" and createDate like '%"+newDate+"%'";
			}
			if(endDate!=null){
				sql+=" and endDate like '%"+endDate+"%'";
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
			}finally{
				close();
			}	
		return rows;
	}

	/**
	 * 获取文件id的放法
	 */
	public int getFileId() {
		int fid=0;
		String sql="SELECT LAST_INSERT_ID() FROM msg_manuscripts";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				fid=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return fid;
	}

	/**
	 * 添加附件管理
	 */
	public int addFile(String fname, String path, String ftype, int mid,int fid) {
		int rows=0;
		String sql="INSERT INTO file_attach(createDate,NAME,path,fileType,menuId,fileId)" +
				"VALUE(NOW(),?,?,?,?,?)";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,fname);
			pst.setString(2, path);
			pst.setString(3, ftype);
			pst.setInt(4, mid);
			pst.setInt(5, fid);
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	/**
	 * 删除稿件
	 */
	public int delInfo(int id) {
		int rows =0;
		String sq="delete from file_attach where fileid=?";
		String sql="delete from msg_manuscripts where id=?";
		getConnection();
		try {
			pst=conn.prepareStatement(sq);
			pst.setInt(1, id);
			rows=pst.executeUpdate();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/**
	 * 按id查询稿件
	 */
	public List<Msg_manuscripts> selectInfo(int id) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		String sql="SELECT *FROM msg_manuscripts ";
		if(id!=0){
			sql+=" where id ='"+id+"'";
		}
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts m= new Msg_manuscripts(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按稿件id修改稿件
	 */
	public int updateInfo(Msg_manuscripts ms) {
		int rows =0;
		String sql="UPDATE msg_manuscripts SET createDate=NOW(),NAME=?,number=?,content=?,endDate=?,sendUserid=?,state=?,flag=NULL WHERE id=?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ms.getName());
			pst.setString(2, ms.getNumber());
			pst.setString(3, ms.getContent());
			pst.setDate(4, ms.getEndDate());
			pst.setInt(5, ms.getSendUserId());
			pst.setInt(6, ms.getState());
			pst.setInt(7, ms.getId());
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	public List<Msg_manuscripts> selectInfoByExcel(int id) {
		List<Msg_manuscripts> list=new ArrayList<Msg_manuscripts>();
		String sql="SELECT *FROM msg_manuscripts ";
		if(id!=0){
			sql+=" where id ='"+id+"'";
		}
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Msg_manuscripts m= new Msg_manuscripts(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(8));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询附件名称
	 */

	@Override
	public String QueryFlieNmae(int mid, int fid) {
		String fname="";
		String sql="SELECT*FROM file_attach WHERE menuid=? AND fileid=?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mid);
			pst.setInt(2, fid);
			rs=pst.executeQuery();
			if(rs.next()){
				fname=rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fname;
	}
	
}
