package com.kimyunjae.basket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.basket.service.BasketServiceImpl;
import com.kimyunjae.game.vo.Game;

@WebServlet("/addBasket")
public class BasketAdd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int gno = Integer.parseInt(req.getParameter("gno"));
		List<Game> basket = new BasketServiceImpl().addBasket(gno, email);
		if(!basket.isEmpty()) {
			req.getSession(true).setAttribute("basket", basket);
			resp.getWriter().print(1);
		}
				
	}

}
