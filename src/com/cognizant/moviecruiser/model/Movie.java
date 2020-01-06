package com.cognizant.moviecruiser.model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
	private long id;
	private String title;
	private long boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long id, String title, long boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String details = String.format("%-20s $%-20s %-5s %-18s %-15s %-5s Edit", title, df.format(boxOffice),
				active ? "Yes" : "No", sdf.format(dateOfLaunch), genre, hasTeaser ? "Yes" : "No");
		return details;

	}

	public String getCustomerDetails() {
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String details = String.format("%-20s $%-20s  %-15s %-5s Add to Favorite", title, df.format(boxOffice), genre,
				hasTeaser ? "Yes" : "No");
		return details;
	}

	public String addFav() {
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String details = String.format("%-20s $%-20s  %-15s %-5s Add to Favorite", title, df.format(boxOffice), genre,
				hasTeaser ? "Yes" : "No");
		return details;
	}

	public String deleteFav() {
		String pattern = "#,###,###,###";
		DecimalFormat df = new DecimalFormat(pattern);
		String details = String.format("%-20s $%-20s  %-15s %-5s Delete", title, df.format(boxOffice), genre,
				hasTeaser ? "Yes" : "No");
		return details;
	}

	public double getNoOffavorite() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
