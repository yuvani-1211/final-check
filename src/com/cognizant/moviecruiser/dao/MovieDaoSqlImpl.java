package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.dao.ConnectionHandler;

public class MovieDaoSqlImpl implements MovieDao  {

	@Override
	public List<Movie> getMovieListAdmin() {
		List<Movie> movie = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "select * from movie_item";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie mov =new Movie();
				mov.setId(rs.getLong(1));
				mov.setTitle(rs.getString(2));
				mov.setBoxOffice(rs.getLong(3));
				mov.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mov.setDateOfLaunch(rs.getDate(5));
				mov.setGenre(rs.getString(6));
				mov.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				movie.add(mov);
				
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}}
		
		return movie;
	}

	@Override
	public List<Movie> getMovieListCustomer()  {
		List<Movie> movie = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_item where me_active=? and me_date_of_launch=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Yes");
			stmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie mov =new Movie();
				mov.setId(rs.getLong(1));
				mov.setTitle(rs.getString(2));
				mov.setBoxOffice(rs.getLong(3));
				mov.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mov.setDateOfLaunch(rs.getDate(5));
				mov.setGenre(rs.getString(6));
				mov.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				movie.add(mov);
				
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}}
		
		
		
		return movie;
	}

	@Override
	public void modifyMovieItem(Movie movieId) {
		List<Movie> movie = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "update movie_item \r\n" + 
					"set me_title=?,\r\n" + 
					"me_boxOffice=?,\r\n" + 
					"me_active=?,\r\n" + 
					"me_date_of_launch=?,\r\n" + 
					"me_genre=?,\r\n" + 
					"me_hasTeaser=? where me_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, movieId.getTitle());
			stmt.setLong(2, movieId.getBoxOffice());
			stmt.setString(3, movieId.isActive()? "yes" : "No");
			stmt.setDate(4, new java.sql.Date(movieId.getDateOfLaunch().getTime()));
			stmt.setString(5, movieId.getGenre());
			stmt.setString(6, movieId.isHasTeaser()? "yes" : "No");
            int count=stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}}
	
	}

	@Override
	public Movie getMovie(long movieId) {
		Movie mov=new Movie();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from movie_item";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				mov.setId(rs.getLong(1));
				mov.setTitle(rs.getString(2));
				mov.setBoxOffice(rs.getLong(3));
				mov.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mov.setDateOfLaunch(rs.getDate(5));
				mov.setGenre(rs.getString(6));
				mov.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return mov;
	}


	@Override
	public Movie getMovieList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
