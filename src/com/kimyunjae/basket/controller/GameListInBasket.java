package com.kimyunjae.basket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.basket.service.BasketServiceImpl;
import com.kimyunjae.member.vo.Member;

@WebServlet("/gameListBasket")
public class GameListInBasket extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)req.getSession().getAttribute("user");
		req.getSession().setAttribute("basket", new BasketServiceImpl().getBasketList(member.getEmail()));
		req.getRequestDispatcher("game/basket.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
	}

}
