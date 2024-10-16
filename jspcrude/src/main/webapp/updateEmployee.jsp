<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.app.bean.Employee" %>
<%@ page import="com.app.dao.EmployeeDao" %>
<%@ page import="java.io.IOException" %>
<%
    // Retrieve form parameters
    int employeeId = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String country = request.getParameter("country");

    // Create an Employee object with updated details
    Employee updatedEmployee = new Employee(employeeId, name, password, email, gender, country);

    // Update the employee details
    boolean updated = EmployeeDao.updateEmployee(updatedEmployee);

    if (updated) {
        // Employee updated successfully
        response.sendRedirect("editEmployee.jsp?id=" + employeeId + "&message=Employee+updated+successfully");
    } else {
        // Error occurred while updating the employee
        response.sendRedirect("editEmployee.jsp?id=" + employeeId + "&message=Error+occurred+while+updating+the+employee");
    }
%>
