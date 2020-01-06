<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title> Edit Movie </title>
		<link type="text/css" rel="stylesheet" href="./style/style.css">
		<script  src="./js/script.js" type="text/javascript"></script>
	</head>
	<body>
		<header>
			<span class="h1" >Movie Cruiser</span>
			<span><img src="./images/logo.png" /></span>
			<span> 
				<nav>
					<a href="ShowMovieListAdmin" class="move">Movies</a>
				</nav>
			</span>
		</header>
		<div>
			<h2>Edit Movie</h2>
			<form name="form" action="EditMovie?movieId=${movie.id}"  method="post"  onSubmit="return valid()">
				<table>
					<tr>
						<td><label for="name">Title</label></td>
					</tr>
					<tr>
						<td colspan="4"><input type="text" name="title" id="name" class="size" value="${movie.title}"/></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td><label for="gross">Gross ($)</label></td>
						<td>Active </td>
						<td><label for="date">Date of Launch</label></td>
						<td><label for="genre">Genre</label></td>
					</tr>
					<tr>
						<td><input type="text" name="gross1" id="gross"  class="right" value="${movie.boxOffice}"/></td>
						
						<td><input type="radio" name="rd" id="yes" <c:if test="${movie.active eq 'true' }"> Checked </c:if>><label for="yes">Yes</label>
							<input type="radio" name="rd" id="no" <c:if test=${movie.active eq 'false'}">Checked</c:if>><label for="no">No</label>
						</td>
						
						<td><input type="text" name="date" id="date" value="<fmt:formatDate pattern="dd/MM/yyyy"  value="${movie.dateOfLaunch}"/>  "></td>
						
						<td>
							<select   name="genre" id="genre" value="${movie.genre}"> 
							<option value="${movie.genre}">${movie.genre}</option>
								<option value="Superhero" >Superhero</option> 
								<option value="Romance">Romance</option> 
								<option value="comedy">comedy</option> 
								<option value="Adventure">Adventure</option> 
								<option value="Thriller">Thriller</option> 
							</select>
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" id="check" name="check" <c:if test="${movie.hasTeaser eq 'true' }" Checked></c:if>> 
							<label for="check">Has Teaser</label>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Save"   class="sub"  />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<footer>
			<h4 class="black"> Copyright &copy 2019</h4>
		</footer>
		
	</body>
</html>
				
