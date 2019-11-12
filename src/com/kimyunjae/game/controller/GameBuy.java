package com.kimyunjae.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.game.service.GameServiceImpl;
import com.kimyunjae.game.vo.Game;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.util.common.BeanPropertySetter;

@WebServlet("/gameBuy")
public class GameBuy extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int gno = Integer.parseInt(req.getParameter("gno"));
		req.setAttribute("game", new GameServiceImpl().getGame(gno));
		req.getRequestDispatcher("game/buy.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)req.getSession().getAttribute("user");
		int gno = Integer.parseInt(req.getParameter("gno"));
		new GameServiceImpl().buy(gno, member);
		resp.sendRedirect("index");
	}
	
	
	
}
