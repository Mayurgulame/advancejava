<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.app.dao.EmployeeDao" %>
<%@ page import="java.io.IOException" %>
<%
    // Retrieve employee ID from the request parameter
    int employeeId = Integer.parseInt(request.getParameter("id"));

    // Delete the employee with the specified ID
    boolean deleted = EmployeeDao.deleteEmployee(employeeId);

    if (deleted) {
        // Employee deleted successfully
        out.println("Employee with ID " + employeeId + " deleted successfully.");
    } else {
        // Error occurred while deleting the employee
        out.println("Error occurred while deleting the employee.");
    }
%>
