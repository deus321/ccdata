package com.deus.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deus.store.web.base.BaseServlet;

public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = -8057060053077972860L;
	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("findAll execute");
	}
	public void checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		 
		
	}
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/login.jsp";
	}
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/register.jsp";
	}
}
