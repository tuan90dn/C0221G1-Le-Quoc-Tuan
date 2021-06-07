<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/3/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/customers">Back to list of customers</a>
</p>
<table>
    <tr>
        <td>ID of customer: </td>
        <td>${customer.customerId}</td>
    </tr>
    <tr>

    <td>Name of customer type: </td>
    <td>${customer.customerType.customerTypeName}</td>
    </tr>
    <tr>
        <td>Name of customer: </td>
        <td>${customer.customerName}</td>
    </tr>
    <tr>
        <td>Birthday of customer: </td>
        <td>${customer.customerBirthday}</td>
    </tr>

    <tr>
        <c:if test="${customer.customerGender == 0}">
            <td>Gender of customer : </td>
            <td>Male </td>
        </c:if>
        <c:if test="${customer.customerGender == 1}">
            <td>Gender of customer : </td>
            <td>Female </td>
        </c:if>
    </tr>
    <tr>
        <td>Id card of customer: </td>
        <td>${customer.customerIdCard}</td>
    </tr>
    <tr>
        <td>Phone number of customer: </td>
        <td>${customer.customerPhone}</td>
    </tr>
    <tr>
        <td>Email of customer: </td>
        <td>${customer.customerEmail}</td>
    </tr>
    <tr>
        <td>Address of customer: </td>
        <td>${customer.customerAddress}</td>
    </tr>
</table>
</body>
</html>
