package com.deus.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deus.store.web.base.BaseServlet;

public class IndexServlet extends BaseServlet{

	private static final long serialVersionUID = -9196467729013390274L;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/index.jsp";
	}
}
