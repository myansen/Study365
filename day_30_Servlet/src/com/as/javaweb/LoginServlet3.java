package com.as.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.corba.se.pept.transport.Connection;

public class LoginServlet3 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		java.sql.Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///192.168.31.211/kerry";
			String user = "Ansen";
			String password2 = "kerry2017!";

			connection = DriverManager.getConnection(url, user, password2);
			String sql = "SELECT COUNT(1) FROM USERS WHERE user =?" + " AND password=?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password2);

			resultSet = statement.executeQuery();
			PrintWriter out = resp.getWriter();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count > 0) {

					out.print("Hello:" + username);
				} else {

					out.print("Sorry:" + username);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
