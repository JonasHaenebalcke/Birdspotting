<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Create new bird specie :</h1>
	<form:form action="newbirdspotting" method="POST"
	modelAttribute="birdSpecie">


		<table>
			<tr>
				<td><label>Specie: </label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label>Year of discovery: </label></td>
				<td><form:input path="yearOfDiscovery"/></td>
				<td><form:errors path="yearOfDiscovery" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label >Book of birds code: </label></td>
				<td><form:input path="code"/></td>
				<td><form:errors path="code" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Spot new bird"></td>
			</tr>
		</table>


	</form:form>
</body>
</html>