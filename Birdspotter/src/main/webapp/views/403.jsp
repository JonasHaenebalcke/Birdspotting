<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>

	<form action="/logout" method="post">
		<input type="submit" value="Stop spotting"> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</html>