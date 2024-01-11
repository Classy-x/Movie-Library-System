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
import com.dto.admin;

@WebServlet("/admin")
public class AdminDaoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("aid"));
		String name = req.getParameter("aname");
		long mob = Long.parseLong(req.getParameter("amob"));
		String mail = req.getParameter("amail");
		String pass = req.getParameter("apass");

		admin Admin = new admin();
		Admin.setAid(id);
		Admin.setAname(name);
		Admin.setAmob(mob);
		Admin.setAmail(mail);
		Admin.setApass(pass);

		AdminDao dao = new AdminDao();

		try {
			
			int res=dao.saveAdmin(Admin);
			if (res>=1) {
				RequestDispatcher rsp=req.getRequestDispatcher("adminlogin.jsp");
				rsp.include(req, resp);
			}
			else {
				RequestDispatcher rsp=req.getRequestDispatcher("admin.jsp");
				rsp.include(req, resp);
			}
			
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
