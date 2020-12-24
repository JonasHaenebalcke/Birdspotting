<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body>
	<h1>Overview of spotted birds in ${location.get().getName()}</h1>

	<br>
	<p>
		<a href="/birdspotting/${location.get().getName()}/newbirdspotting"}>New
			Spotting</a> - <a href="/birdspotting">Spotting locations overview</a>
	</p>
	<br>

	<table>
		<tr>
			<th>Index</th>
			<th>Specie</th>
			<th>Year of discovery</th>
			<th>Code index in the book of birds</th>
			<th>Spottings</th>
		</tr>
		<c:forEach items="${spottedBirds}" var="spottedBirds"
			varStatus="status">
			<tr>

				<td>${status.index +1}</td>
				<td>${spottedBirds.birdSpecie.name}</td>
				<td>${spottedBirds.birdSpecie.yearOfDiscovery}</td>
				<td>${spottedBirds.birdSpecie.code}</td>
				<td>${spottedBirds.count}</td>
			</tr>

		</c:forEach>
		<table>
</body>
</html>