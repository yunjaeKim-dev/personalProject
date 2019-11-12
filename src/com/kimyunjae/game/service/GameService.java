package com.kimyunjae.game.service;

import java.util.List;

import com.kimyunjae.game.vo.Game;
import com.kimyunjae.member.vo.Member;

public interface GameService {
	boolean add();
	Game getGame(int gno);
	List<Game> getGames(String gamecategory,String keyword);
	boolean modify(Game vo);
	boolean remvoe(int gno);
	boolean buy(int gno,Member member);
	List<Game> getGamesByEmail(Member member);
	
	
	
}
