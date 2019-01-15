package com.deus.store.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		MyRequest myRequest = new MyRequest(request);
		arg2.doFilter(myRequest, response);
		
	}
}
