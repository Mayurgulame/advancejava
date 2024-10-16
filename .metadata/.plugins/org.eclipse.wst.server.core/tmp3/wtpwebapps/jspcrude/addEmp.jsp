<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.bean.Employee, com.app.dao.EmployeeDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee</title>
</head>
<body>
<jsp:useBean id="emp" class="com.app.bean.Employee" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="emp"/>
<%
int i = EmployeeDao.saveEmp(emp);
if (i > 0) {
    response.sendRedirect("success.jsp");
} else {
    response.sendRedirect("error.jsp");
}
%>
</body>
</html>
