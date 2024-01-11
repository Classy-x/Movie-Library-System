package com.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.dto.Movie;
import com.dto.admin;

public class AdminDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ownproject", "root", "root");
	}

	public int saveAdmin(admin Admin) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into foradmin values(?,?,?,?,?)");
		pst.setInt(1, Admin.getAid());
		pst.setString(2, Admin.getAname());
		pst.setLong(3, Admin.getAmob());
		pst.setString(4, Admin.getAmail());
		pst.setString(5, Admin.getApass());

		return pst.executeUpdate();

	}

	public admin findBymail(String mail) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from foradmin where mail=? ");
		pst.setString(1, mail);
		ResultSet rs = pst.executeQuery();

		admin Admin = new admin();
		if (rs.next()) {
			Admin.setAid(rs.getInt(1));
			Admin.setAname(rs.getString(2));
			Admin.setAmob(rs.getLong(3));
			Admin.setAmail(rs.getString(4));
			Admin.setApass(rs.getString(5));

			return Admin;
		} else {
			return null;
		}

	}

	public int savemovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into formovie values(?,?,?,?,?,?)");
		pst.setInt(1, movie.getId());
		pst.setString(2, movie.getName());
		pst.setDouble(3, movie.getPrice());
		pst.setDouble(4, movie.getRate());
		pst.setString(5, movie.getLanguage());

		Blob imageblob = new SerialBlob(movie.getImage());
		pst.setBlob(6, imageblob);

		return pst.executeUpdate();

	}

	public List<Movie> getAllMovies() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from formovie");
		ResultSet rs = pst.executeQuery();
		List<Movie> movie = new ArrayList<Movie>();
		while (rs.next()) {
			Movie m = new Movie();
			m.setId(rs.getInt(1));
			m.setName(rs.getString(2));
			m.setPrice(rs.getDouble(3));
			m.setRate(rs.getDouble(4));
			m.setLanguage(rs.getString(5));

			Blob b = rs.getBlob(6);
			byte[] img = b.getBytes(1, (int) b.length());
			m.setImage(img);
			movie.add(m);
		}
		return movie;

	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from formovie where mid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}

	public Movie findMovieById(int id) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from formovie where mid=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Movie m = new Movie();

		rs.next();
		m.setId(rs.getInt(1));
		m.setName(rs.getString(2));
		m.setPrice(rs.getDouble(3));
		m.setRate(rs.getDouble(4));
		m.setLanguage(rs.getString(5));

		Blob b = rs.getBlob(6);
		byte[] img = b.getBytes(1, (int) b.length());
		m.setImage(img);
		return m;
	}

	public int updateMovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("update formovie set mname=?,mprice=?,mrating=?,mlan=?,mimg=? where mid=?");

		
		pst.setString(1, movie.getName());
		pst.setDouble(2, movie.getPrice());
		pst.setDouble(3, movie.getRate());
		pst.setString(4, movie.getLanguage());
		
		Blob img = new SerialBlob(movie.getImage());
		if(img.length()>0)
		{
			pst.setBlob(5, img);
		}
		else
		{
			Movie m = findMovieById(movie.getId());
			Blob b1 = new SerialBlob(m.getImage());
			pst.setBlob(5, b1);
			
		}
		pst.setInt(6, movie.getId());
		return pst.executeUpdate();
	}

}
