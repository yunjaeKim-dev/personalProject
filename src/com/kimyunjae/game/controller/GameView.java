package com.kimyunjae.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.game.service.GameServiceImpl;

@WebServlet("/gameView")
public class GameView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int gno = Integer.parseInt(req.getParameter("gno"));
		req.setAttribute("game", new GameServiceImpl().getGame(gno));
		req.getRequestDispatcher("game/view.jsp").forward(req, resp);
	}
}
