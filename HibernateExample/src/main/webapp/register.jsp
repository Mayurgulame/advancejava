<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Registration</title>
</head>
<body>
<%@ page import="example.hibernate.dao.EmployeeDAO" %>
<%@ page import="example.hibernate.entity.Employee" %>

<jsp:useBean id="e" class="example.hibernate.entity.Employee" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="e"></jsp:setProperty>

<%
    int status = EmployeeDAO.saveEmployee(e);
    if (status > 0) {
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
%>

</body>
</html>
