package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		//testGetAllFavorites();
		testAddFavorite();
		//testRemoveFavorites();
	}

	public static void testGetAllFavorites() throws FavoriteEmptyException {
		FavoriteDao favDao = new FavoriteDaoSqlImpl();
		List<Movie> moviecust = favDao.getAllFavorites(1l);
		System.out.println("Favorite list*********************");
		for (Movie move : moviecust) {
			System.out.println(move.deleteFav());
		}

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao fav = new FavoriteDaoSqlImpl();
		long totalGross = 0l;
		fav.addFavorite(1, 2l);
		fav.addFavorite(1, 4l);
		fav.addFavorite(2, 5l);
		fav.addFavorite(2, 3l);
		List<Movie> moviecust = fav.getAllFavorites(1l);
		System.out.println("user added a Favorites********************");
		for (Movie move : moviecust) {
			System.out.println(move.addFav());
			totalGross += move.getBoxOffice();
		}

	}

	public static void testRemoveFavorites() throws FavoriteEmptyException {
		FavoriteDao favDao = new FavoriteDaoSqlImpl();
		long totalGross = 0l;
		favDao.removeFavorites(1, 2l);
		List<Movie> moviecust = favDao.getAllFavorites(1l);
		System.out.println("user remove a Favorites********************");

		for (Movie move : moviecust) {
			System.out.println(move.addFav());
			totalGross += move.getBoxOffice();
		}

	}

}
