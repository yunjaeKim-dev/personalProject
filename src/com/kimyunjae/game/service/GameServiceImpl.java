package com.kimyunjae.game.service;

import java.util.List;

import com.kimyunjae.game.dao.GameDao;
import com.kimyunjae.game.vo.Game;
import com.kimyunjae.member.vo.Member;

public class GameServiceImpl implements GameService{
	
	GameDao dao = new GameDao();
	
	@Override
	public boolean add() {
		return dao.add();
	}

	@Override
	public Game getGame(int gno) {
		return dao.getGame(gno);
	}

	@Override
	public List<Game> getGames(String gamecategory, String keyword) {
		return dao.getGames(gamecategory,keyword);
	}

	@Override
	public boolean buy(int gno,Member member) {
		return dao.buy(gno,member);
	}

	@Override
	public boolean modify(Game vo) {
		return dao.modify(vo);
	}

	@Override
	public boolean remvoe(int gno) {
		return dao.remvoe(gno);
	}
	
	@Override
	public List<Game> getGamesByEmail(Member member) {
		return dao.getGamesByEmail(member);
	}

}
