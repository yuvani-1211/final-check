package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorite;

	public FavoriteDaoCollectionImpl() {
		if (userFavorite == null) {
			userFavorite = new HashMap<Long, Favorite>();
			userFavorite.put(1l, new Favorite());

		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovie(movieId);
			if (userFavorite.containsKey(userId)) {
				Favorite fav = userFavorite.get(userId);
				fav.getMovieItem().add(movie);
			} else {
				Favorite fav = new Favorite();
				fav.getMovieItem().add(movie);
				userFavorite.put(userId, fav);

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Movie> getAllFavorites(long userId) {
		// TODO Auto-generated method stub
		List<Movie> movieList = userFavorite.get(userId).getMovieItem();
		Favorite fav = userFavorite.get(userId);
		if (fav == null || fav.getMovieItem() == null || fav.getMovieItem().isEmpty()) {

			try {
				throw new FavoriteEmptyException();
			} catch (FavoriteEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else {
			System.out.println("No of Favorites :" + movieList.size());
		}
		return movieList;

	}

	@Override
	public void removeFavorites(long userId, long movieId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		List<Movie> movieList = userFavorite.get(userId).getMovieItem();
		if(movieList==null || movieList.isEmpty())
		{
			throw new FavoriteEmptyException();
		}
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
				break;
			}

		}
	}

	@Override
	public String size() {
		// TODO Auto-generated method stub
		return null;
	}

	
}