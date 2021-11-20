<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>savedept</title>
</head>
<body>
	<h2>Department Details</h2>
	Id:${ department.id }
	<br>
	<br> Name:${ department.name }
	<br>
	<br>
	<a href = "/" >Home</a>
	<a href = "getDept">Show Departments</a>
</body>
</html>