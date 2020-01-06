package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class Favorite{
	private List<Movie> movieItem;


	public Favorite() {
		super();
		movieItem = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Favorite(List<Movie> movieItem, int noofFavorites) {
		super();
		this.movieItem = movieItem;

	}

	public List<Movie> getMovieItem() {
		return movieItem;
	}

	public void setMovieItem(List<Movie> movieItem) {
		this.movieItem = movieItem;
	}

	
}
