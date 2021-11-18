
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editEmp</title>
</head>
<body>
	<h1>Update Employee Details</h1>
	<form:form action="updateEmp" modelAttribute="empToEdit">
		<table>
			<tr>
				<form:label path="id">ID</form:label>
				<form:input path="id" readonly="true" />
				<br>
				<br>
				<form:label path="name">NAME</form:label>
				<form:input path="name" />
				<br>
				<br>
				<form:label path="department">DEPARTMENT</form:label>
				<form:input path="department" />
				<br>
				
		
				<input type="submit" value="Update"/>
			</tr>
		</table>
	</form:form>
</body>
</html>