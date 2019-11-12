package com.kimyunjae.basket.service;

import java.util.List;

import com.kimyunjae.game.vo.Game;

public interface BasketService {
	List<Game> addBasket(int gno, String email);
	boolean buyBasket(String email, List<Integer> gnos,List<Integer> basketnos);
	List<Game> removeBasket(String email, int basketno);
	boolean removeSelectedBasket(String email, List<Integer> basketno);
	List<Game> getBasketList(String email);
	boolean removeBasketAll(String email);
}
