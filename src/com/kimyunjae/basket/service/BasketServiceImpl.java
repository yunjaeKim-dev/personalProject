package com.kimyunjae.basket.service;

import java.util.List;

import com.kimyunjae.basket.dao.BasketDao;
import com.kimyunjae.game.vo.Game;

public class BasketServiceImpl implements BasketService{
	
	BasketDao dao = new BasketDao();
	@Override
	public  List<Game> addBasket(int gno, String email) {
		return dao.addBasket(gno, email);
	}

	@Override
	public boolean buyBasket(String email, List<Integer> gnos,List<Integer> basketnos) {
		return dao.buyBasket(email, gnos, basketnos);
	}

	@Override
	public List<Game> removeBasket(String email, int basketno) {
		return dao.removeBasket(email, basketno);
	}
	@Override
	public boolean removeSelectedBasket(String email, List<Integer> basketno) {
		// TODO Auto-generated method stub
		return dao.removeSelectedBasket(email, basketno);
	}

	@Override
	public List<Game> getBasketList(String email) {
		// TODO Auto-generated method stub
		return dao.getBasketList(email);
	}
	
	@Override
	public boolean removeBasketAll(String email) {
		// TODO Auto-generated method stub
		return dao.removeBasketAll(email);
	}
}
