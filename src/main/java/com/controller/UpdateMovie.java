package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.AdminDao;
import com.dto.Movie;
@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize = 5* 1024* 1024)
public class UpdateMovie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int mid= Integer.parseInt(req.getParameter("mid"));
	       String mname=req.getParameter("mname");
	       double mprice=Double.parseDouble(req.getParameter("mprice"));
	       double mrating=Double.parseDouble(req.getParameter("mrating"));
	       String mlan=req.getParameter("mlan");
	       Part mimg=req.getPart("mimg");
	       
	       Movie movie= new Movie();
	       movie.setId(mid);
	       movie.setName(mname);
	       movie.setPrice(mprice);
	       movie.setRate(mrating);
	       movie.setLanguage(mlan);
	       movie.setImage(mimg.getInputStream().readAllBytes());
	       
	       AdminDao amd= new AdminDao();
	       try {
			amd.updateMovie(movie);
			req.setAttribute("movies", amd.getAllMovies());
			RequestDispatcher rsp = req.getRequestDispatcher("Home.jsp");
			rsp.include(req, resp);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		
		
	}
}
