package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dto.Movie;
import com.dto.admin;

@WebServlet("/alogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amail = req.getParameter("adminmail");
		String pass = req.getParameter("adminpass");

		AdminDao dao = new AdminDao();

		try {
			admin Admin = dao.findBymail(amail);
			if (Admin != null) {
				if (Admin.getApass().equals(pass)) {
					List<Movie> movie=dao.getAllMovies();
					req.setAttribute("movies", movie);
					RequestDispatcher rsp = req.getRequestDispatcher("Home.jsp");
					rsp.include(req, resp);
				} else {
					req.setAttribute("message", "Password is wrong");
					RequestDispatcher rssp = req.getRequestDispatcher("adminlogin.jsp");
					rssp.include(req, resp);
				}
			} else {
				req.setAttribute("message", "Email is wrong");
				RequestDispatcher rssp = req.getRequestDispatcher("adminlogin.jsp");
				rssp.include(req, resp);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
