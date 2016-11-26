package com.lib.service.t;

import java.util.List;

import com.libo.entity.Msg_receive;

public interface Msg_ReceiveService {
	public int addRece(Msg_receive msRece);
	public List<Msg_receive> selectByUserId(int uid,int userid);
}
