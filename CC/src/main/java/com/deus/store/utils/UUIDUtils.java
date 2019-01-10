package com.deus.store.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 获取32位长度的UUID字符串
	 * @return String 
	 * 
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 获取64位长度的UUID字符串 
	 * 
	 */
	public static String getUUID64() {
		return getUUID() + getUUID();
	}
}
