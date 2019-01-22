package com.deus.store.web.servlet;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deus.store.domain.User;
import com.deus.store.serviceimp.UserServiceImp;
import com.deus.store.utils.MyBeanUtils;
import com.deus.store.utils.UUIDUtils;
import com.deus.store.web.base.BaseServlet;

public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = -8057060053077972860L;
	public void checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		 String username = req.getParameter("username");
		 UserServiceImp userServiceImp = new UserServiceImp();
		 boolean isExisted = userServiceImp.checkUsername(username);
		 resp.setContentType("application/json;charset=utf-8");
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
	public String regist(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, String[]> map = req.getParameterMap();
		User user;
		try {
			user = MyBeanUtils.populate(User.class,map);
			user.setUid(UUIDUtils.getUUID());
			user.setState(0);
			user.setCode(UUIDUtils.getUUID64());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		UserServiceImp userServiceImp = new UserServiceImp();
		userServiceImp.regist(user);
		req.setAttribute("msg", "注册成功，请邮箱验证后登陆");
		return "/jsp/login.jsp";
	}
	public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/login.jsp";
	}
	public String registUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/register.jsp";
	}
}
