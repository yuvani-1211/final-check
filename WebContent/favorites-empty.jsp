<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>favorites empty</title>
<link type="text/css" rel="stylesheet" href="./style/style.css">
</head>
<body>
	<header> <span class="h1">Movie Cruiser</span> <span><img
		src="./images/logo.png" /></span> <a href="ShowFavorite" class="fav">Favorites</a>
	<a href="ShowMovieListCustomer" class="move">Movies</a> </header>
	<div>
		<h2>Favorites</h2>
		<h3 class="gray">${mes}
			<a href="ShowMovieListCustomer" class="blue">Movie List.</a>
		</h3>
	</div>
	<footer>
	<h4 class="black">Copyright &copy 2019</h4>
	</footer>
</body>
</html>