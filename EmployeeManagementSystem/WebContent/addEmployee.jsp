<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="add"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<add:form method="post" action="pagesubmit" modelAttribute="employee_details">
<table>
<tr>
<td>Employee Id: </td>
<td><add:input path=""/></td>
</tr>
<tr>
<td>Employee Name: </td>
<td><add:input path=""/></td>
</tr>
<tr>
<td>Employee Salary: </td>
<td><add:input path=""/></td>
</tr>
<tr>
<td>Employee Designation: </td>
<td><add:input path=""/></td>
</tr>
</table>
<input type="submit" value="Add employee"/>
</add:form>

</body>
</html>