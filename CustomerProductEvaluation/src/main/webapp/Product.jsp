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

	<form method="get" action="SaveProduct">

	Enter Name:
	<input type="text" name="name"></br>
    Enter Price:
    <input type="text" name="price"></br>
    Enter Qty:
    <input type="text" name="qty"></br>

    <input type="Submit" value="Add Product">

	</form>





	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>