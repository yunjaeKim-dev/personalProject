package com.kimyunjae.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.reply.service.ReplyServiceImpl;

@WebServlet("/replyRemove")
public class ReplyRemove extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		int replyno = Integer.parseInt(req.getParameter("replyno"));
		new ReplyServiceImpl().remove(replyno);
		resp.sendRedirect("boardView?boardno="+boardno);
	}
	
}
