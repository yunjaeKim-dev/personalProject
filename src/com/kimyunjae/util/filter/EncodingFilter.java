package com.kimyunjae.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class EncodingFilter implements Filter{
	String encode;
	FilterConfig fc;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		fc = arg0;
		encode = "utf-8";
	}
	@Override
	public void destroy() {
		encode = null;
		fc = null;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding(encode);
		arg2.doFilter(arg0, arg1);
	}

	
}
