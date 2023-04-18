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


    <table>
                <thead>
                   <tr>
                      <th>ID</th>
                      <th>Name</th>


                      <th>Delete</th>
                   </tr>
                </thead>
                <tbody>
                                    <!--   for (Product product: listProduct) {  -->
                                   <c:forEach var="product" items="${listProduct}">

                                      <tr>
                                         <td><c:out value="${product.id}" /></td>
                                         <td><c:out value="${product.name}" /></td>


                                         <td><a href="deleteProductServlet?id=<c:out value='${product.id}'/>">Delete</a></td>
                                         <td></td>
                                      </tr>
                                   </c:forEach>
                                   <!-- } -->
                                </tbody>
                             </table>


	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>