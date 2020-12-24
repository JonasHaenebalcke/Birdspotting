<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location List</title>
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body>
	<h1>Overview of bird spotting locations:</h1>

	<p>Please select your location to add a spotting:</p>
	<table>
		<tr>
			<th>Location</th>
			<th>Birds spotted</th>
		</tr>

		<c:forEach items="${locationList}" var="location">
			<tr>
				<td><a href="/birdspotting/${location.name}">${location.name}</a></td>
				<td>${location.spottedBirds}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<input name="submit" type="submit" value="Stop spotting">

</body>
</html>