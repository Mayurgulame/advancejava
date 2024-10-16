<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
<h1>Student Form</h1>

<form:form action="details" modelAttribute="student">
    Enter First Name: <form:input path="firstName"/>
    <br><br>
    Enter Last Name: <form:input path="lastName"/>
    <br><br>
    <input type="submit" value="register"/>
</form:form>
</body>
</html>
