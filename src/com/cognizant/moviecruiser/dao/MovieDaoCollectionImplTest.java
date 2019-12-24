package com.cognizant.moviecruiser.dao;

import java.text.ParseException;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;

public class MovieDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("*********************admin movie list********************");
			testGetMovieListAdmin();
			System.out.println("*********************customer movie list*****************");
			testtGetMovieListCustomer();
			testModifyMovie();
			System.out.println("********************Modified  movie list*****************");
			testGetMovieListAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}

	}

	public static void testtGetMovieListCustomer() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		for (Movie x : movieList) {
			System.out.println(x.getCustomerDetails());
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie movie = new Movie(1, "Bigil", 234566774, true, DateUtil.convertToDate("11/02/2020"), "sentiment", true);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovieItem(movie);

	}

	public void testGetMovie() {

	}
}