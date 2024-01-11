package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dto.Movie;

@WebServlet("/editmovie")
public class EditMovie extends HttpServlet {
      
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("mid"));
		AdminDao dao = new AdminDao();
		
		try {
			Movie movie=dao.findMovieById(id);
			req.setAttribute("movies", movie);
			RequestDispatcher rsp=req.getRequestDispatcher("Edit.jsp");
			rsp.include(req, resp);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
