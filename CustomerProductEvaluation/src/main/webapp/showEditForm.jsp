<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AllUser</title>
</head>
<body>
	<h1>All Users</h1>

	<form action='custUpdateServlet' method='get'>
	 <input type="hidden" value='${custEdit.id}' name ="custId">
     Enter Name:
   	  <input type="text" name="name" value='${custEdit.name}'></br>
       Enter Email:
       <input type="text" name="email" value='${custEdit.email}'></br>
       Enter Phone:
       <input type="text" name="phone" value='${custEdit.phone}'></br>
       Enter Address:
       <input type="text" name="address" value='${custEdit.address}'></br>
       Enter Password:
       <input type="password" name="password" value='${custEdit.password}'></br>

    <input type='Submit' value='Update'>


    </form>



	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>