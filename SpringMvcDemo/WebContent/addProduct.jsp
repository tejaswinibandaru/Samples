<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="addProduct" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add product
<table>
<addProduct:form action="pagesubmit" method="post" modelAttribute="product_details">
<tr>
<td>Product ID: </td>
<td><addProduct:input path="productId"/></td>
</tr>
<tr>
<td>Product Name: </td>
<td><addProduct:input path="productName"/></td>
<td><span><addProduct:errors path="productName"></addProduct:errors></span></td>
</tr>
<tr>
<td>Product Price: </td>
<td><addProduct:input path="productPrice"/></td>
<td><span><addProduct:errors path="productPrice"></addProduct:errors></span></td>
</tr>
<tr>
<td>Product Type</td>
<td><addProduct:select path="productType" items="${dataItem}"></addProduct:select>
</tr>
<tr>
<td>Product Features: </td>
<td><addProduct:checkboxes items="${featureValues}" path="features"/>
<tr>
<tr>
<td>Product Availability</td>
<td><addProduct:radiobutton path="online" value="Online"/>Online<br/>
<addProduct:radiobutton path="online" value="Offline"/>Offline
</td>
</tr>
<td><input type="submit" value="Add Product"></td>
</tr>

</addProduct:form>
</table>
</body>
</html>