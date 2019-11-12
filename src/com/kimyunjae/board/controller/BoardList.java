package com.kimyunjae.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.service.BoardService;
import com.kimyunjae.board.service.BoardServiceImpl;
import com.kimyunjae.board.vo.Criteria;
import com.kimyunjae.board.vo.PageDTO;

@WebServlet("/boardList")
public class BoardList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		if(req.getParameter("page") != null) {
			cri.setPage(Integer.parseInt(req.getParameter("page")));
		}
		if(req.getParameter("amount") != null) {
			cri.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		

		BoardServiceImpl service =  new BoardServiceImpl();
		req.setAttribute("list", service.getBoards(cri,category,keyword));
		req.setAttribute("pagination", new PageDTO(cri,service.getCount(category,keyword)));
		req.getRequestDispatcher("board/list.jsp").forward(req, resp);;
	}
	
}
