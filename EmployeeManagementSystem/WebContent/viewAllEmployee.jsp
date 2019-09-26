<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="viewAll" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Employee Salary</th>
<th>Employee Designation</th>
</tr>
<viewAll:forEach var="emp" items="${employeedata}">
<tr>
<td>${emp.empId}</td>
<td>${emp.empName}</td>
<td>${emp.empSalary}</td>
<td>${emp.designation}</td>
</tr>
</viewAll:forEach>
</table>
</body>
</html>