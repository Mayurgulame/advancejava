<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />" />
</head>
<body>

<h2>Customer Form</h2>

<form:form action="saveCustomer" modelAttribute="customer">
    <form:hidden path="id" />
    
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
</form:form>

<br>
<a href="<c:url value='/customer/list' />">Back to List</a>

</body>
</html>
