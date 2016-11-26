package com.lib.dao.t;

import java.util.List;

import com.libo.entity.Msg_file;

public interface Msg_fileDao {
	public List<Msg_file> selectAllbyFid(int currentPage,int pageSize,String title, String type, String wordType);
	public List<Msg_file> selectAllbyFid();
	public List<Msg_file> selectAllbyFid(int id);
	public int addSPart(Msg_file msfil);
	public int updSPart(Msg_file msfil,int id,int flag);
	public int delSPart(int id);
	public List<Msg_file> selectAllByMuch(int currentPage,int pageSize,String title, String author, String number, String name);
	public int addAll(Msg_file msfil);
	public int selectFid();
	public List<Msg_file> selectAllbyFfid(int fid);
	public Msg_file selectAllByfid(int fid);
	public int updaAPart(Msg_file msfil);
}
