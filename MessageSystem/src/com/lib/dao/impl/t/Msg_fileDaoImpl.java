package com.lib.dao.impl.t;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.dao.t.Msg_fileDao;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class Msg_fileDaoImpl extends BaseDao implements Msg_fileDao {

	/**
	 * 分页 
	 * */
	public List<Msg_file> selectAllbyFid(int currentPage, int pageSize,
			String title, String type, String wordType) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		try {
		String sql="SELECT * FROM msg_file WHERE flag=0 ";
		if(title!=null){
			sql+=" and title like '%"+title+"%'";
		}
		if(type!=null){
			sql+=" and type like '%"+type+"%'";
		}
		if(wordType!=null){
			sql+=" and filetype like '%"+wordType+"%'";
		}
		if(currentPage>0){
		sql+="  limit ?,? ";
		}
		getConnection();
		pst=conn.prepareStatement(sql);
		if(currentPage>0){
		pst.setInt(1, (currentPage-1)*pageSize);
		pst.setInt(2, pageSize);
		}
		rs=pst.executeQuery();
		while(rs.next()){
			Msg_file file=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15));
			list.add(file);
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
	public List<Msg_file> selectAllbyFid() {
		List<Msg_file> list=new ArrayList<Msg_file>();
		try {
		String sql="SELECT * FROM msg_file WHERE flag=0 ";
		getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			Msg_file file=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15));
			list.add(file);
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
	public int addSPart(Msg_file msfil) {
		int rows=0;
		try {
		String sql="INSERT INTO msg_file(createuserid,createdate,title,author,`FROM`,`TYPE`,filetype,content,sendUser,flag) VALUE(?,now(),?,?,?,?,?,?,?,?) ";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, msfil.getCreateUserId());
		pst.setString(2, msfil.getTitle());
		pst.setString(3, msfil.getAuthor());
		pst.setString(4, msfil.getFrom());
		pst.setString(5, msfil.getType());
		pst.setString(6, msfil.getFiletype());
		pst.setString(7, msfil.getContent());
		pst.setInt(8, msfil.getSendUser());
		pst.setInt(9, msfil.getFlag());
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
	public int updSPart(Msg_file msfil,int id,int flag) {
		int rows=0;
		try {
		String sql="UPDATE msg_file SET createuserid=?,title=?,author=?,`FROM`=?,`TYPE`=?,filetype=?,content=? WHERE id=? AND flag=? ";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, msfil.getCreateUserId());
		pst.setString(2, msfil.getTitle());
		pst.setString(3, msfil.getAuthor());
		pst.setString(4, msfil.getFrom());
		pst.setString(5, msfil.getType());
		pst.setString(6, msfil.getFiletype());
		pst.setString(7, msfil.getContent());
		pst.setInt(8, id);
		pst.setInt(9, flag);
		rows=pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}	
		return rows;
	}
	/*
	 * 已提交稿件查询
	 * */
	@Override
	public List<Msg_file> selectAllbyFid(int id) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		Org_employee ee=null;
		try {
		String sql="SELECT ms.id,ms.createuserid,ms.createdate,ms.title,ms.author,ms.from,ms.type,ms.filetype,ms.content,ms.maid,ms.number,ms.state,ms.senddate,ms.senduser,ms.flag,o.loginname,o.username from msg_file ms inner join org_employee o on ms.senduser=o.id where  ms.flag=1 and ms.id=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		rs=pst.executeQuery();
		while(rs.next()){
			ee=new Org_employee(rs.getString(16), rs.getString(17));
			Msg_file file=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15),ee);
			list.add(file);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	//我的稿件里的删除
	public int delSPart(int id) {
		int rows=0;
		try {
		String sql="delete from msg_file where id=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		rows=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return rows;
	}
	/**
	 * 已提交稿件模糊查询
	 * */
	@Override
	public List<Msg_file> selectAllByMuch(int currentPage, int pageSize,
			String title, String author, String number, String name) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		Msg_file file=null;
		Msg_manuscripts msgman=null;
		try{
		String sql="SELECT ms.id,ms.createuserid,ms.createdate,ms.title,ms.author,ms.from,ms.type,ms.filetype,ms.content,ms.maid,ms.number,ms.state,ms.senddate,ms.senduser,ms.flag, m.id,m.createdate,m.name,m.number,m.content,m.enddate,m.senduserid,m.state,m.flag  FROM msg_manuscripts m INNER JOIN msg_file ms ON m.id=ms.maid WHERE ms.flag=1 ";
		if(title!=null){
			sql+=" and ms.title like '%"+title+"%'";
		}
		if(author!=null){
			sql+=" and ms.author like '%"+author+"%'";
		}
		if(number!=null){
			sql+=" and m.number like '%"+number+"%'";
		}
		if(name!=null){
			sql+=" and m.name like '%"+name+"%'";
		}
		if(currentPage>0){
			sql+="  limit ?,? ";
		}
		getConnection();
		pst=conn.prepareStatement(sql);
		if(currentPage>0){
		pst.setInt(1, (currentPage-1)*pageSize);
		pst.setInt(2, pageSize);
		}
		rs=pst.executeQuery();
		while(rs.next()){
			msgman=new Msg_manuscripts(rs.getInt(16), rs.getDate(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getDate(21), rs.getInt(22), rs.getInt(23), rs.getInt(24));
			file=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15),msgman);
			list.add(file);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	
	}

	@Override
	public int addAll(Msg_file msfil) {
		int rows=0;
		try {
		String sql="INSERT INTO msg_file(createuserid,createdate,title,author,`FROM`,`TYPE`,filetype,content,maid,number,state,senddate,sendUser,flag) VALUE(?,NOW(),?,?,?,?,?,?,?,?,0,NOW(),?,1)";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, msfil.getCreateUserId());
		pst.setString(2, msfil.getTitle());
		pst.setString(3, msfil.getAuthor());
		pst.setString(4, msfil.getFrom());
		pst.setString(5, msfil.getType());
		pst.setString(6, msfil.getFiletype());
		pst.setString(7, msfil.getContent());
		pst.setInt(8, msfil.getMaId());
		pst.setString(9, msfil.getNumber());
		pst.setInt(10, msfil.getSendUser());
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
	public int selectFid() {
		int fid=0;
		String sql="SELECT LAST_INSERT_ID() FROM msg_file";
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

	@Override
	public List<Msg_file> selectAllbyFfid(int fid) {
		List<Msg_file> list=new ArrayList<Msg_file>();
		try {
		String sql="SELECT * from msg_file where id=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, fid);
		rs=pst.executeQuery();
		while(rs.next()){
			Msg_file file=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15));
			list.add(file);
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
	public Msg_file selectAllByfid(int fid) {
		Msg_file msg=null;
		try {
		String sql="select * from msg_file where id=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, fid);
		rs=pst.executeQuery();
		while(rs.next()){
			msg=new Msg_file(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDate(13), rs.getInt(14), rs.getInt(15));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public int updaAPart(Msg_file msfil) {
		int rows=0;
		String sql="UPDATE msg_file SET createuserid=?,title=?,author=?,`FROM`=?,`TYPE`=?,filetype=?,content=?,maid=?,number=?,state=0 WHERE id=? and senduser=? AND flag=1 ";
		getConnection();
		try {
		pst=conn.prepareStatement(sql);
		pst.setInt(1, msfil.getCreateUserId());
		pst.setString(2, msfil.getTitle());
		pst.setString(3, msfil.getAuthor());
		pst.setString(4, msfil.getFrom());
		pst.setString(5, msfil.getType());
		pst.setString(6, msfil.getFiletype());
		pst.setString(7, msfil.getContent());
		pst.setInt(8, msfil.getMaId());
		pst.setString(9, msfil.getNumber());
		pst.setInt(10, msfil.getId());
		pst.setInt(11, msfil.getSendUser());
		rows=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

}
