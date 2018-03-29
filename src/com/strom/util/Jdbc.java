package com.strom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * jdbc 数据库连接
 * @author zhangtao
 *
 */
public class Jdbc {

	private static Jdbc jdbc = null;
	public static Jdbc instance() {
		if (jdbc==null) jdbc = new Jdbc();
		return jdbc;
	}

	/**
	 * 获取总条数
	 * @param sql
	 * @return
	 */
	public int getCount(String sql) {
		Connection conn = instance().getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) return rs.getInt("total");
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 保存(更新/删除/新增)
	 * @param sql
	 * @param strs
	 */
	public boolean save(String sql, String[] strs) {
		Connection conn = instance().getConn();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 1; i <= strs.length; i++) {
				pstm.setString(i-1, strs[i]);
			}
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("保存失败");
			e.printStackTrace();
			return false;
		} finally  {
			try {
				if (pstm!=null) pstm.close();
				instance().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**'
	 * 获取jsonObject
	 * @param sql
	 * @param strs
	 * @return
	 */
	public JSONObject getJSONObject(String sql) {
		JSONObject jsonObject = new JSONObject();
		Connection conn = instance().getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				jsonObject = getObject(rs);
			}
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)rs.close();
				if (pstm!=null) pstm.close();
				instance().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}

	/**
	 * 便利获取jsonObject
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private JSONObject getObject(ResultSet rs) throws SQLException {
		JSONObject jsonObject = new JSONObject();
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			jsonObject.put(rs.getMetaData().getColumnName(i), rs.getString(i));
		}
		return jsonObject;
	}

	/**
	 * 条件分页查询
	 * @param sql
	 * @param strs
	 * @return
	 */
	public JSONArray getJsonArray(String sql) {
		JSONArray jsonArray = new JSONArray();
		Connection conn = instance().getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				JSONObject jsonObject = getObject(rs);
				jsonArray.add(jsonObject);
			}
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)rs.close();
				if (pstm!=null) pstm.close();
				instance().close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jsonArray;
	}

	/**
	 * 获取连接
	 * @return
	 */
	public Connection getConn() {
		//		Properties prop = new Properties();
		try {
			//			String filePath = this.getClass().getResource("/").getPath()+"/jdbc.properties";
			//			System.out.println(filePath);
			//			prop.load(new FileInputStream(new File(filePath)));
			//			System.out.println(prop.get("url"));
			//			Class.forName(prop.getProperty("driverClass"));
			//			Connection conn = DriverManager.getConnection(prop.getProperty("url"), 
			//					prop.getProperty("user"), prop.getProperty("pwd"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/strom",
					"root","root");
			return conn;
			//		} catch (FileNotFoundException e) {
			//			System.out.println("没有找到配置文件");
			//			e.printStackTrace();
			//		} catch (IOException e) {
			//			System.out.println("文件加载失败");
			//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭连接
	 * @param conn
	 */
	public void close(Connection conn) {
		try {
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {


	}

}
