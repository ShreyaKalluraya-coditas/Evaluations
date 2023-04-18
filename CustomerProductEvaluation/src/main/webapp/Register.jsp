<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
</head>
<body>
	<h1>Register Page</h1>

	<form method="get" action="Save">

	Enter Name:
	<input type="text" name="name"></br>
    Enter Email:
    <input type="text" name="email"></br>
    Enter Phone:
    <input type="text" name="phone"></br>
    Enter Address:
    <input type="text" name="address"></br>
    Enter Password:
    <input type="password" name="password"></br>
    <input type="Submit" value="Register">

	</form>





	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>