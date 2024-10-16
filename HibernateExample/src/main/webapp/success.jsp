<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Registration Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background-color: #d4edda;
            color: #155724;
        }
        h2 {
            color: #155724;
        }
        a {
            color: #004085;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration Successful</h2>
        <p>Employee registration has been successfully completed.</p>
        <p><a href="employee.jsp">Register Another Employee</a></p>
    
         <a href="index.jsp">Go back to Home</a>
         <a href="viewAllEmployees.jsp">View All Employees</a>
        <a href="updateEmployee.jsp?id=<%= request.getParameter("id") %>">Update Employee</a>
        <a href="deleteEmployee.jsp?id=<%= request.getParameter("id") %>">Delete Employee</a>
    
    </div>
</body>
</html>
