package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;
import com.cognizant.moviecruiser.dao.MovieDao;

public class MovieDaoSqlImplTest {

	public static void main(String[] args) throws ParseException {
		System.out.println("*********************admin movie list********************");
		testGetMovieListAdmin();
		System.out.println("*********************customer movie list*****************");
		testtGetMovieListCustomer();
		testModifyMovie();
		System.out.println("********************Modified  movie list*****************");
		testGetMovieListAdmin();
	}

	

	private static void testModifyMovie() throws ParseException {
		Movie movie = new Movie(1, "Bigil", 234566774, true, DateUtil.convertToDate("11/02/2020"), "sentiment", true);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovieItem(movie);

		
	}



	private static void testtGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		for (Movie x : movieList) {
			System.out.println(x.getCustomerDetails());
		}		
	}

	private static void testGetMovieListAdmin() throws ParseException {
		// TODO Auto-generated method stub
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}
		
	
		
	}

}
