package com.deus.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deus.store.serviceimp.UserServiceImp;
import com.deus.store.web.base.BaseServlet;

public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = -8057060053077972860L;
	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("findAll execute");
	}
	public void checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		 String username = req.getParameter("username");
		 UserServiceImp userServiceImp = new UserServiceImp();
		 boolean isExisted = userServiceImp.checkUsername(username);
		 try {
			 if(isExisted) {
				 resp.getWriter().write("{\"result\":\"成功\"}");
			 }else {
				 resp.getWriter().write("{\"result\":\"失败\"}");
			 }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/jsp/login.jsp";
	}
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/register.jsp";
	}
}
