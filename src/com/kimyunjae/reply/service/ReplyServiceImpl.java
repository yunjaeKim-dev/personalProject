package com.kimyunjae.reply.service;

import java.util.List;

import com.kimyunjae.board.vo.Criteria;
import com.kimyunjae.reply.dao.ReplyDao;
import com.kimyunjae.reply.vo.Reply;

public class ReplyServiceImpl implements ReplyService{
	ReplyDao dao = new ReplyDao();
	@Override
	public boolean add(Reply vo,int boardno) {
		return dao.add(vo,boardno);
	}

	@Override
	public int getCount(String category, String keyword) {
		return dao.getCount(category, keyword);
	}

	@Override
	public List<Reply> getReplys(int boardno) {
		return dao.getReplys(boardno);
	}


	@Override
	public boolean modify(Reply vo) {
		return dao.modify(vo);
	}

	@Override
	public boolean remove(int replyno) {
		return dao.remove(replyno);
	}

}
