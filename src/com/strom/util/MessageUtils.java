package com.strom.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class MessageUtils {
	
	private static MessageUtils messageUtils = null;
	public static MessageUtils instance() {
		if (messageUtils==null) messageUtils = new MessageUtils();
		return messageUtils;
	}
	
	public void write(HttpServletResponse response, Object obj) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
		out.flush();
		out.close();
	}

}
