package com.team404.reply.service;

import java.util.ArrayList;

import com.team404.command.FreeReplyVO;

public interface ReplyService {

	public int regist(FreeReplyVO vo);
	public ArrayList<FreeReplyVO> getList(int bno);
	
}
