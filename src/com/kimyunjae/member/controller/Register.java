package com.kimyunjae.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.member.service.MemberServiceImpl;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;
import com.kimyunjae.util.common.BeanPropertySetter;
import com.kimyunjae.util.common.FileUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/register")
public class Register extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("member/register.jsp").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = new Member();
		
		String path = getServletContext().getRealPath("upload");
//		System.out.println(path);
		int limit = 20 * 1024 * 1024;
		String upPath = FileUtils.createUploadFolder(path);
//		System.out.println(upPath);
		MultipartRequest multi = new MultipartRequest(req, path + File.separator + upPath, limit, "utf-8");
//		System.out.println("path + File.separator + upPath :: " + path + File.separator + upPath);
//		System.out.println("multi ::" + multi);
//		System.out.println("req.getContentType() :: " + req.getContentType());
		
		BeanPropertySetter.setProps(multi, member);
//		System.out.println("member :: " + member);
//		System.out.println("multi :: " + multi);
		
		String param = "file";
//		System.out.println("param :: " + param);
		
		String fileName = multi.getFilesystemName(param);
//		System.out.println("fileName :: " + fileName);
		
		MemberFile file = new MemberFile();
		if(fileName != null) {
			file.setOriginname(multi.getOriginalFileName(param));
			file.setFilename(fileName);
			file.setMimetype(multi.getContentType(param));
			file.setFilepath(upPath);
			file.setFilesize((int)multi.getFile(param).length());
		}else {
			file.setFilepath("upload");
			file.setFilename("man.png");
		}
//		System.out.println("file :: " + file);
		member.setFile(file);
//		System.out.println("member :: " + member);
		FileUtils.createUploadFolder(path);
		new MemberServiceImpl().signup(member);
		resp.sendRedirect("index");
//		System.out.println("req.getContentType() :: " + req.getContentType());
//		m.setFile(file);
//		FileUtils.createUploadFolder(path);
//		if(new MemberServiceImpl().signup(m)) {
//			resp.getWriter().println("<script>alert('회원가입 성공!')</script>");
//			System.out.println("회원 가입 성공");
//			resp.sendRedirect("index");
//		}else {
//			req.setAttribute("error", "회원가입 실패");
//			System.out.println("회원가입 실패");
//			req.getRequestDispatcher("index").forward(req, resp);
//		}
	
	}
	
}
