package com.deus.store.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	/**
	 * 简单封装
	 * 将数据封装到JavaBean并且
	 * 支持时间转换 
	 * 使用BeanUtils的DateConverter对象设置时间转换格式
	 * ConvertUtils注册转换
	 * @param bean
	 * @param properties
	 * 
	 */
	public static void populate(Object bean, Map<String,String[]> properties) {
		//1.创建时间转换器
		DateConverter converter = new DateConverter();
		//2.设置转换的格式
		converter.setPatterns(new String[] {"yyyy-mm-dd","yyyy-mm-dd hh:mm:ss"});
		//3.注册转换器到工具类
		ConvertUtils.register(converter, Date.class);
		//4.将properties填入bean中
		try {
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 高级封装（使用泛型方法） 
	 * @param beanClass
	 * @param properties
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * 
	 */
	public static <T> T populate(Class<T> beanClass, Map<String,String[]> properties) throws InstantiationException, IllegalAccessException, InvocationTargetException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		//1.利用反射技术创建bean对象
		T bean = beanClass.getDeclaredConstructor().newInstance();
		//2.重复注册时间转换器的步骤
		DateConverter c = new DateConverter();
		c.setPatterns(new String[] {"yyyy-mm-dd","yyyy-mm-dd hh:mm:ss"});
		ConvertUtils.register(c, Date.class);
		//3.填入数据
		BeanUtils.populate(bean, properties);
		return bean;
	}
}
