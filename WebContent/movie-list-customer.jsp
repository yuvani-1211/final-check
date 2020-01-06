<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Customer</title>
<link type="text/css" rel="stylesheet" href="./style/style.css">
</head>
<body>
	<header> <span class="h1">Movie Cruiser</span> <span><img
		src="./images/logo.png" /></span> <span> <nav> <a
			href="ShowFavorite" class="fav">Favorites</a> <a
			href="ShowMovieListCustomer" class="move">Movies</a> </nav>
	</span> </header>
	<div>
		<h2>Movie</h2>
		<h3>${mes}</h3>
		<table>

			<tr>
				<th class="left">Title</th>
				<th class="right">Box Office</th>
				<th class="center">Genre</th>
				<th class="center">Has Teaser</th>
				<th class="center">Action</th>
			</tr>
			<c:forEach items="${movieList}" var="fav">
				<tr>
					<td class="left">${fav.title}</td>
					<td class="right">$ ${fav.boxOffice}</td>
					<td class="center">${fav.genre}</td>
					<td class="center">${fav.hasTeaser?'yes':'No'}</td>
					<td class="center"><a href="AddToFavorites?movieId=${fav.id}"
						class="black">Add to Favorite</a></td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<footer>
	<h4 class="black">Copyright &copy 2019</h4>
	</footer>
</body>
</html>
