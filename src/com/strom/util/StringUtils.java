package com.strom.util;

public class StringUtils {
	
	private static StringUtils stringUtils = null;
	public static StringUtils instance() {
		if (stringUtils==null) stringUtils = new StringUtils();
		return stringUtils;
	}
	
	/**
	 * �ַ�����Ϊ��
	 * @param str
	 * @return
	 */
	public boolean isNotEmpty(String str) {
		return str!=null&&!"".equals(str)&&str.trim().length()>=1?true:false;
	}
	
	/**
	 * �ַ���Ϊ��
	 * @param str
	 * @return
	 */
	public boolean isEmpty(String str) {
		return str==null&&"".equals(str);
	}

}
