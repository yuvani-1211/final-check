<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Favorites</title>
<link type="text/css" rel="stylesheet" href="./style/style.css">
</head>
<body>
	<header> <span class="h1">Movie Cruiser</span> <span><img
		src="./images/logo.png" /></span> <span> <nav> <a
			href="ShowFavorite" class="fav">Favorites</a> <a
			href="ShowMovieListCustomer" class="move">Movies</a> </nav>
	</span> </header>
	<div>
		<h2>Favorites</h2>
		<table>
			<tr>
				<th class="left">Title</th>
				<th class="right">Box Office</th>
				<th class="center">Genre</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="left">${movie.title}</td>
					<td class="right">$ ${movie.boxOffice}</td>
					<td class="center">${movie.genre}</td>
					<td class="center"><a
						href="RemoveFavorite?movieId=${movie.id}" class="black">Delete</a>

					</td>
				</tr>
			</c:forEach>
			<tr>
			<tr>
				<th class="left">No.of Favorites:${fav}</th>
			</tr>
		</table>
	</div>
	<footer>
	<h4 class="black">Copyright &copy 2019</h4>
	</footer>
</body>
</html>
