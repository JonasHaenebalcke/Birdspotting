<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<spring:url value="/css/style.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
</head>
<body onload='document.loginForm.username.focus();'>
	<h1>Bird Spotting Login</h1>

	<h3>Login with Username and Password</h3>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	

	<form action='login' method='POST'>

		<table>
			<tr>
				<td>User</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit"
					value="submit"></td>
			</tr>
		</table>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /><
	</form>
</body>
</html>