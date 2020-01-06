package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditMovieServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			long id = Long.parseLong(request.getParameter("movieId"));
			String title = request.getParameter("title");
			long boxOffice = Long.parseLong(request.getParameter("gross1"));
			boolean active = Boolean.parseBoolean(request.getParameter("rd"));
			;

			String date = request.getParameter("date");

			String genre = request.getParameter("genre");
			boolean hasTeaser = Boolean.parseBoolean(request.getParameter("check"));

			Movie movie = new Movie(id, title, boxOffice, active, DateUtil.convertToDate(date), genre, hasTeaser);
			MovieDao movieDao = new MovieDaoCollectionImpl();
			movieDao.modifyMovieItem(movie);
			request.setAttribute("mes", "Movie details saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
