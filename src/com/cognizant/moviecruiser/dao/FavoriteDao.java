package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavoriteDao   {
 public void addFavorite(long userId, long MovieId);
 public List<Movie> getAllFavorites(long userId) throws FavoriteEmptyException;
	public void removeFavorites(long userId, long movieId);
	public String size();
 
}
