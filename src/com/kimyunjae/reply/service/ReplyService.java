package com.kimyunjae.reply.service;

import java.util.List;

import com.kimyunjae.board.vo.Criteria;
import com.kimyunjae.reply.vo.Reply;

public interface ReplyService {
	boolean add(Reply vo,int boardno);
	int getCount(String category,String keyword);
	List<Reply> getReplys(int boardno);
	boolean modify(Reply vo);
	boolean remove(int replyno);
	
}
