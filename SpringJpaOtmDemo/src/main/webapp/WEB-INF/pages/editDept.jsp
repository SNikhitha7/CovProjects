
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editDept</title>
</head>
<body>
	<h1>Update Department Details</h1>
	<form:form action="updateDept" modelAttribute="deptToEdit">
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
				
				
				<input type="submit" value="Register">
			</tr>
		</table>
	</form:form>
</body>
</html>