package com.deus.store.web.filter;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * MyRequest 继承  HttpServletRequestWrapper 
 * 通过对项目常用到的getParamer(),getParameterValues()以及
 * getParameterMap()重写来解决中文乱码问题
 * 乱码解决实现主要在getParameterMap()方法内其他方法直接间接调用该方法
 * @author deus321
 */

public class MyRequest extends HttpServletRequestWrapper{
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
	 * 获取指定名称的全部参数 
	 * 
	 */
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}
	/**
	 * 中文乱码实现方法 
	 * 
	 * 
	 */
	@Override
	public Map<String, String[]> getParameterMap(){
		Map<String, String[]> map = super.getParameterMap();
		if("GET".equalsIgnoreCase(super.getMethod())) {
				for (Entry<String, String[]> entry : map.entrySet()) {
					String[] value = entry.getValue();
					for (String str : value) {
						try {
							str = new String(str.getBytes("IS0-8859-1"),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							throw new RuntimeException(e);
						}
					}
					
				}
			}
		return map;
	}
	
}
