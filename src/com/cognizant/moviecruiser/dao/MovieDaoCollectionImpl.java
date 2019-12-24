package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() throws ParseException {

		if (movieList == null) {
			movieList = new ArrayList<>();
			movieList.add(new Movie(1, "Avatar", 278796508, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 1518812988, true, DateUtil.convertToDate("23/12/2017"),
					"Superher", false));
			movieList.add(
					new Movie(3, "TItanic", 218746394, true, DateUtil.convertToDate("21/08/2017"), "Romance", false));
			movieList.add(new Movie(4, "Jurassic World", 1671713208, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "Avengers: End Game", 275076034, true, DateUtil.convertToDate("02/11/2020"),
					"Superher", false));

		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> movie = new ArrayList<>();
		Date d = new Date();
		for (Movie x : movieList) {
			if (x.isActive() && x.getDateOfLaunch().before(d)) {
				movie.add(x);
			}

		}
		return movie;
	}

	public void modifyMovieItem(Movie movieId) {
		// TODO Auto-generated method stub
		Movie movie = getMovie(movieId.getId());
		movie.setTitle(movieId.getTitle());
		movie.setBoxOffice(movieId.getBoxOffice());
		movie.setActive(movieId.isActive());
		movie.setDateOfLaunch(movieId.getDateOfLaunch());
		movie.setGenre(movieId.getGenre());
		movie.setHasTeaser(movieId.isHasTeaser());
	}

	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		Movie movie = null;
		for (Movie x : movieList) {
			if (x.getId() == movieId) {
				movie = x;
				break;
			}
		}
		return movie;

	}

}
