package com.kimyunjae.board.service;

import java.util.List;

import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.board.vo.Criteria;

public interface BoardService {
	boolean add(BoardVo vo);
	int getCount(String category,String keyword);
	List<BoardVo> getBoards(Criteria cri, String category, String keyword);
	BoardVo getBoard(int boardno);
	boolean modify(BoardVo vo);
	boolean remove(int boardno);
	
}
