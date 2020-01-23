package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long MovieId) {

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "INSERT INTO favorite(fv_us_id,fv_mv_id) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, MovieId);
			int count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Movie> getAllFavorites(long userId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		Favorite favorite = new Favorite();
		String sql = "select me_title,me_boxOffice,me_active,me_genre,me_hasTeaser from movie_item join favorite on fv_mv_id=me_id where fv_us_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setTitle(rs.getString(1));
				m.setBoxOffice(rs.getLong(2));
				m.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
				m.setDateOfLaunch(rs.getDate(4));
				m.setGenre(rs.getString(5));
				m.setHasTeaser(rs.getString(6).equalsIgnoreCase("Yes"));
				favorite.getMovieItem().add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return favorite.getMovieItem();

	}

	@Override
	public void removeFavorites(long userId, long movieId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "delete from favorite  where fv_us_id=? and fv_mv_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			int count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

	}

	@Override
	public String size() {
		// TODO Auto-generated method stub
		return null;
	}



}
