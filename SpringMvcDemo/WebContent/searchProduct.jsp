<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="searchdata">
<table border=1>
<tr>
<td>Product Id:</td>
<td><input name="productid">
</tr>
</table>
<input type="submit" value="Search Product">
</form>
<br/>
<jsp:include page="searchProductById.jsp"></jsp:include>
</body>
</html>