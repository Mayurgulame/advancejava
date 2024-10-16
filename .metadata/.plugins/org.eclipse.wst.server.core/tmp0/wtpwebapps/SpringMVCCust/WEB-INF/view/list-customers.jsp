<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />" />
</head>
<body>

<h2>Customers</h2>

<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>
                <a href="<c:url value='/customer/showFormForUpdate?customerId=${customer.id}' />">Update</a> |
                <a href="<c:url value='/customer/delete?customerId=${customer.id}' />" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="<c:url value='/customer/showFormForAdd' />">Add New Customer</a>

</body>
</html>
