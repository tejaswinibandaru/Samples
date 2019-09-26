<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="showProduct"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
</tr>

<showProduct:forEach var="product" items="${productdata}">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productPrice}</td>
</tr>
</showProduct:forEach>

</table>
</body>
</html>