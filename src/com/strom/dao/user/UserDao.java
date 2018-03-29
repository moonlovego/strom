package com.strom.dao.user;

import com.strom.util.Jdbc;
import com.strom.util.Page;
import net.sf.json.JSONArray;

public class UserDao {
	
	private static UserDao userDao = null;
	public static UserDao instance() {
		if (userDao==null) userDao = new UserDao();
		return userDao;
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public JSONArray getUserList(Page page) {
		return Jdbc.instance().getJsonArray("select * from t_user where 1=1 and ("+
				" name like '"+page.getKey()+"' or phone like '"+page.getKey()+
				"' or email like '"+page.getKey()+"' or addr like '"+page.getKey()+"' or school "+
				" like '"+page.getKey()+"') limit "+page.getStarPage()+","+page.getPageSize()+"");
	}
	
	/**
	 * 获取总条数
	 * @param page
	 * @return
	 */
	public int getTotalCount(Page page) {
		return Jdbc.instance().getCount("select count(*) as total from t_user where 1=1 and ("+
				" name like '"+page.getKey()+"' or phone like '"+page.getKey()+
				"' or email like '"+page.getKey()+"' or addr like '"+page.getKey()+"' or school "+
				" like '"+page.getKey()+"')");
	}
	
}
