package com.deus.store.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper{
	private boolean encoded = false;
	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	/**
	 * 获取制定名称的第一个参数
	 * @return String
	 * 
	 */
	
	@Override
	public String getParameter(String name) {
		String[] all = getParameterValues(name);
		if(all == null) {
			return null;
		}
		
		return all[0];
	}
	/**
	 *获取指定名称的全部参数 
	 * 
	 */
	public String getParameter()
	
}
