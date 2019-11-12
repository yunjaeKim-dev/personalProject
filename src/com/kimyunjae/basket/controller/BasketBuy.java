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


@WebServlet("/buyBasket")
public class BasketBuy extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] tmp = req.getParameterValues("gnos");
		String email = req.getParameter("email");
		String[] tmp2 = req.getParameterValues("basketnos");
		List<Integer> gnos= new ArrayList<>();
		List<Integer> basketnos= new ArrayList<>();
		for (int i = 0; i < tmp.length; i++) {
			gnos.add(Integer.parseInt(tmp[i]));
			System.out.println(gnos.get(i));
		}
		for (int i = 0; i < tmp2.length; i++) {
			basketnos.add(Integer.parseInt(tmp2[i]));
			System.out.println(basketnos.get(i));
		}
		
		if(new BasketServiceImpl().buyBasket(email, gnos,basketnos)) {
			resp.getWriter().print(1);
		}
	}

}
