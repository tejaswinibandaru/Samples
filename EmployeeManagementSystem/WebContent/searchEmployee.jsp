<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="searchdata" >
Employee Id: <input name="empId"/>
<input type="submit" value="Search">
</form>
<br/>
<jsp:include page="searchData.jsp"></jsp:include>
</body>
</html>