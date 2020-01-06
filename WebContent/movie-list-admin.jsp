<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List admin</title>
<link type="text/css" rel="stylesheet" href="./style/style.css">
</head>
<body>
	<header> <span class="h1">Movie Cruiser</span> <span><img
		src="./images/logo.png" /></span> <span> <nav> <a
			href="ShowMovieListAdmin" class="move">Movies</a> </nav>
	</span> </header>
	<div>
		<h2>Movie</h2>
		<table>
			<tr>
				<th class="left">Title</th>
				<th class="right">Box Office</th>
				<th class="center">Active</th>
				<th class="center">Date of Launch</th>
				<th class="center">Genre</th>
				<th class="center">Has Teaser</th>
				<th class="center">Action</th>
			</tr>

			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="left"><c:out value="${movie.title}"></c:out></td>
					<td class="right">$<c:out value="${movie.boxOffice}"></c:out></td>
					<td class="center"><c:out
							value="${movie.active? 'Yes' : 'No'}"></c:out></td>
					<td class="center"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateOfLaunch}" /></td>
					<td class="center"><c:out value="${movie.genre}"></c:out></td>
					<td class="center"><c:out
							value="${movie.hasTeaser? 'Yes' : 'No'}"></c:out></td>
					<td class="center"><a href="ShowEditMovie?movieId=${movie.id}"
						class="black">Edit</a></td>
				</tr>
			</c:forEach>


		</table>
	</div>
	<footer>
	<h4 class="black">Copyright &copy 2019</h4>
	</footer>
</body>
</html>
