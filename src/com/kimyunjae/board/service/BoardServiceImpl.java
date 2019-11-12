package com.kimyunjae.board.service;

import java.util.List;

import com.kimyunjae.board.dao.BoardDao;
import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.board.vo.Criteria;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao = new BoardDao();
	@Override
	public boolean add(BoardVo vo) {
		return dao.add(vo);
	}

	@Override
	public List<BoardVo> getBoards(Criteria cri, String category, String keyword) {
		return dao.getBoards(cri, category, keyword);
	}

	@Override
	public int getCount(String category, String keyword) {
		return dao.getCount(category,keyword);
	}

	@Override
	public BoardVo getBoard(int boardno) {
		return dao.getBoard(boardno);
	}

	@Override
	public boolean modify(BoardVo vo) {
		return dao.modify(vo);
	}

	@Override
	public boolean remove(int boardno) {
		return dao.remove(boardno);
	}

	
}
