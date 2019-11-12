package com.kimyunjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.game.service.GameServiceImpl;

@WebServlet("/index")
public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameServiceImpl service = new GameServiceImpl();
		String category = null;
		String keyword = null;
		req.setAttribute("gameList", service.getGames(category,keyword));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}

