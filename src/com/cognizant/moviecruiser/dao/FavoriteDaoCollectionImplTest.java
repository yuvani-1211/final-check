package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		
		testGetAllFavorites();
		testAddFavorite();
		testGetAllFavorites();
		testRemoveFavorites();
		testGetAllFavorites();
	}

	public static void testGetAllFavorites() throws FavoriteEmptyException {
		FavoriteDao favDao = new FavoriteDaoCollectionImpl();
		List<Movie> moviecust = favDao.getAllFavorites(1l);
		System.out.println("Favorite list*********************");
		for (Movie move : moviecust) {
			System.out.println(move.deleteFav());
		}
		
	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao fav = new FavoriteDaoCollectionImpl();
		System.out.println("user added a Favorites********************");
		List<Movie> moviecust = fav.getAllFavorites(1l);
		fav.addFavorite(1, 2l);
		fav.addFavorite(1, 3l);

		for (Movie move : moviecust) {
			System.out.println(move.addFav());
		}

	}

	public static void testRemoveFavorites() throws FavoriteEmptyException {
		FavoriteDao favDao = new FavoriteDaoCollectionImpl();
		List<Movie> moviecust = favDao.getAllFavorites(1l);
		System.out.println("user remove a Favorites********************");

		for (Movie move : moviecust) {
			favDao.removeFavorites(1, 2l);
			System.out.println(move.addFav());
		}

	}
}
