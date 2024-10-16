<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.app.bean.Employee" %>
<%@ page import="com.app.dao.EmployeeDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Employees</title>
</head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Country</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Employee> employees = EmployeeDao.getAllEmployees();
                for(Employee employee : employees) {
            %>
            <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getName() %></td>
                <td><%= employee.getPassword() %></td>
                <td><%= employee.getEmail() %></td>
                <td><%= employee.getGender() %></td>
                <td><%= employee.getCountry() %></td>
                <td><a href="editEmployee.jsp?id=<%= employee.getId() %>">Edit</a></td>
                <td><a href="deleteEmployee.jsp?id=<%= employee.getId() %>">Delete</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
