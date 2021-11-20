<%@page import="javax.swing.text.html.Option"%>
<%@page import="com.cov.beans.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.cov.service.DepartmentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form:form action="regEmp" method="post" modelAttribute="employee">
		
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<form:label path="department">Choose a Department</form:label>
		<form:select path="department">
			<form:option value="0">---select---</form:option>
			<%
			DepartmentService departmentService = (DepartmentService) request.getAttribute("departmentService");
			List<Department> departments = departmentService.findAll();
			for (Department department : departments) {
			%>

			<form:option value="<%=department %>"><%=department.getName()%></form:option>

			<%
			}
			%>
		</form:select>
		<br>
		<br>

		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>