package com.deus.store.web.base;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = -3304988132615787375L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String methodName = req.getParameter("method");
			if (methodName == null) {
				methodName = "execute";
			}
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			String jspPath = (String)method.invoke(this, req, resp);
			if (jspPath != null) {
				req.getRequestDispatcher(jspPath).forward(req, resp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
}
