package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet({ "/RemoveFavoriteServlet", "/RemoveFavorite" })
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RemoveFavoriteServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			long movieId = Long.parseLong(request.getParameter("movieId"));
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
			favoriteDao.removeFavorites(1, movieId);

			request.setAttribute("mes", "Movie removed from Favorites Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowFavorite");
			rd.forward(request, response);

		} catch (FavoriteEmptyException e) {

			request.setAttribute("mes", "No items in Favorites. Use 'Add to Favorite'option in");
			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
