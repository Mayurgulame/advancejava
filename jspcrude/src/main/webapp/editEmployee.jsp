<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.app.bean.Employee" %>
<%@ page import="com.app.dao.EmployeeDao" %>
<%@ page import="java.io.IOException" %>
<%
    // Retrieve employee ID from the request parameter
    int employeeId = Integer.parseInt(request.getParameter("id"));

    // Retrieve employee details by ID
    Employee employee = EmployeeDao.getEmployeeById(employeeId);

    if (employee != null) {
        // Employee found, display edit form
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="updateEmployee.jsp" method="post">
        <input type="hidden" name="id" value="<%= employee.getId() %>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= employee.getName() %>" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= employee.getPassword() %>" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= employee.getEmail() %>" required><br><br>

        <label>Select Gender:</label><br>
        <input type="radio" id="male" name="gender" value="male" <%= employee.getGender().equals("male") ? "checked" : "" %>>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female" <%= employee.getGender().equals("female") ? "checked" : "" %>>
        <label for="female">Female</label><br><br>

        <label for="country">Country:</label>
        <select id="country" name="country">
            <option value="india" <%= employee.getCountry().equals("india") ? "selected" : "" %>>India</option>
            <option value="usa" <%= employee.getCountry().equals("usa") ? "selected" : "" %>>USA</option>
            <option value="canada" <%= employee.getCountry().equals("canada") ? "selected" : "" %>>Canada</option>
            <option value="australia" <%= employee.getCountry().equals("australia") ? "selected" : "" %>>Australia</option>
            <option value="germany" <%= employee.getCountry().equals("germany") ? "selected" : "" %>>Germany</option>
        </select><br><br>

        <input type="submit" value="Update">
    </form>
    <% if (request.getAttribute("message") != null) { %>
        <p><%= request.getAttribute("message") %></p>
    <% } %>
</body>
</html>
<%
    } else {
        // Employee not found, display error message or redirect to error page
        response.sendRedirect("error.jsp");
    }
%>
