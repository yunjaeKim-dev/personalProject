package com.kimyunjae.basket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.basket.service.BasketServiceImpl;
import com.kimyunjae.game.vo.Game;

@WebServlet("/removeBasket")
public class BasketRemove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String basketno = req.getParameter("basketno");
		System.out.println(basketno);
		String email = req.getParameter("email");
		BasketServiceImpl service = new BasketServiceImpl();
		if (basketno != null) {
			List<Game> basket = service.removeBasket(email, Integer.parseInt(basketno));
			if(basket != null) {
				req.getSession(true).setAttribute("basket", basket);
				resp.getWriter().print(1);
			}
		}else {
			service.removeBasketAll(email);
			req.getSession(true).setAttribute("basket", null);
			resp.getWriter().print(1);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] tmp = req.getParameterValues("basketnos");
		String email = req.getParameter("email");
		List<Integer> basketnos = new ArrayList<>();
		for (int i = 0; i < tmp.length; i++) {
			basketnos.add(Integer.parseInt(tmp[i]));
		}
		
		if(new BasketServiceImpl().removeSelectedBasket(email, basketnos)) {
			resp.getWriter().print(1);
		}
	}
}
