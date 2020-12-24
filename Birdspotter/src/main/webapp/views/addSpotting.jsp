<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/css/style.css" var="urlCss" />
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body>
	<h1>Create new bird specie :</h1>
	<form:form action="newbirdspotting" method="POST"
		modelAttribute="birdSpecie">
		<p>
			<label>Specie: </label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
		</p>
		<p>
			<label>Year of discovery: </label>
			<form:input path="yearOfDiscovery" />
			<form:errors path="yearOfDiscovery" cssClass="error" />
		</p>
		<p>
			<label>Book of birds code: </label>
			<form:input path="code" />
			<form:errors path="code" cssClass="error" />
		</p>
		<input type="submit" value="Spot new bird">
	</form:form>
</body>
</html>