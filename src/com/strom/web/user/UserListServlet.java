package com.strom.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.strom.dao.user.UserDao;
import com.strom.util.MessageUtils;
import com.strom.util.Page;

public class UserListServlet extends HttpServlet {

	public UserListServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Page page = new Page();
		page.setCurrPage(Integer.parseInt(request.getParameter("page")));
		page.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		page.setKey(request.getParameter("key"));
		System.out.println(page);
		JSONArray jsonArray = UserDao.instance().getUserList(page);
		int total = UserDao.instance().getTotalCount(page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", jsonArray);
		jsonObject.put("total", total);
		MessageUtils.instance().write(response, jsonObject);
	}

	/**
	 * ∑÷“≥≤È—Ø
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Page page = new Page();
		page.setCurrPage(Integer.parseInt(request.getParameter("page")));
		page.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		page.setKey(request.getParameter("key"));
		System.out.println(page);
		JSONArray jsonArray = UserDao.instance().getUserList(page);
		int total = UserDao.instance().getTotalCount(page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", jsonArray);
		jsonObject.put("total", total);
		MessageUtils.instance().write(response, jsonObject);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
