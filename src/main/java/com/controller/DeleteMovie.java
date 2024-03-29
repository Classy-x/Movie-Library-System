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

@WebServlet("/deletemovie")
public class DeleteMovie extends HttpServlet {
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   int id = Integer.parseInt(req.getParameter("mid"));
    	   AdminDao dao=new AdminDao();
    	   
    	   try {
			dao.delete(id);
			req.setAttribute("movies", dao.getAllMovies());
			RequestDispatcher rsp=req.getRequestDispatcher("Home.jsp");
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
