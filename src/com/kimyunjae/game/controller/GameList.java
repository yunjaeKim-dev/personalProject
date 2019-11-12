package com.kimyunjae.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.game.service.GameServiceImpl;
import com.kimyunjae.member.vo.Member;

@WebServlet("/gameList")
public class GameList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameServiceImpl service = new GameServiceImpl();
		String gamecategory = req.getParameter("gamecategory");
		String keyword = req.getParameter("keyword");
		if(req.getParameter("nickname") != null) {
			Member member = (Member)req.getSession().getAttribute("user");
			req.setAttribute("games", service.getGamesByEmail(member));
			req.getRequestDispatcher("game/list.jsp").forward(req, resp);
		}else {
			req.setAttribute("games", service.getGames(gamecategory, keyword));
			req.getRequestDispatcher("game/list.jsp").forward(req, resp);
			
		}
	}
}
