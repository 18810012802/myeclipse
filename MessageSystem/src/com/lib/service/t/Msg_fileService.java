package com.lib.service.t;

import java.util.List;

import com.libo.entity.Msg_file;

public interface Msg_fileService {
	public List<Msg_file> selectAllbyFid(int currentPage,String title, String type, String wordType);
	public int selectAllbyFid();
	public List<Msg_file> selectAllbyFid(int id);
	public int selectAllbyFilid(String title, String type, String wordType);
	public int addSPart(Msg_file msfil);
	public int updSPart(Msg_file msfil,int id,int flag);
	public int delSPart(int id);
	public List<Msg_file> selectAllByMuch(int currentPage,int pageSize,String title, String author, String number, String name);
	public int selectAllByMuch(String title, String author, String number, String name);
	public int addAll(Msg_file msfil);
	public List<Msg_file> selectAllbyFfid(int fid);
}
