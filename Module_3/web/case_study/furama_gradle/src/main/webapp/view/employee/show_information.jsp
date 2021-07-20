<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Employee details</h1>
<p>
    <a href="/employees">Back to list of employees</a>
</p>
<table>
    <tr>
        <td>ID of employee: </td>
        <td>${employee.employeeId}</td>
    </tr>
    <tr>

        <td>Name of employee: </td>
        <td>${employee.employeeName}</td>
    </tr>
    <tr>
        <td>Birthday of employee: </td>
        <td>${employee.employeeBirthday}</td>
    </tr>
    <tr>
        <td>Id card of employee: </td>
        <td>${employee.employeeIdCard}</td>
    </tr>
    <tr>
        <td>Salary of employee: </td>
        <td>${employee.employeeSalary}</td>
    </tr>
    <tr>
        <td>Phone of employee: </td>
        <td>${employee.employeePhone}</td>
    </tr>
    <tr>
        <td>Email of employee: </td>
        <td>${employee.employeeEmail}</td>
    </tr>
    <tr>
        <td>Address of employee: </td>
        <td>${employee.employeeAddress}</td>
    </tr>
    <tr>
        <td>Position of employee: </td>
        <td>${employee.employeePosition.positionName}</td>
    </tr>
    <tr>
        <td>Education Degree of employee: </td>
        <td>${employee.employeeEducationDegree.educationDegreeName}</td>
    </tr>
    <tr>
        <td>Division of employee: </td>
        <td>${employee.employeeDivision.divisionName}</td>
    </tr>
    <tr>
        <td>User's name of employee: </td>
        <td>${employee.userName}</td>
    </tr>

</table>
</body>
</html>
