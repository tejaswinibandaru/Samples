<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="data"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
<th>Employee Id</th>
<th>Employee Name</th>
<th>Employee Salary</th>
<th>Employee Designation</th>
</tr>
<data:forEach var="employee" items="${data}">
<tr>
<td>${employee.empId}</td>
<td>${employee.empName}</td>
<td>${employee.empSalary}</td>
<td>${employee.designation}</td>
</tr>
</data:forEach>
</table>
</body>
</html>