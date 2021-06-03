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
        <td>${customer.customer_id}</td>
    </tr>
    <tr>
<%--        <c:choose>--%>
<%--            <c:when test = "${customer.customer_type_id.customer_type_id == 1}">--%>
<%--                <td>Type of customer:  </td>--%>
<%--                <td>Diamond  </td>--%>
<%--            </c:when>--%>
<%--            <c:when test = "${customer.customer_type_id.customer_type_id == 2}">--%>
<%--                <td>Type of customer:  </td>--%>
<%--                <td>Platinium  </td>--%>
<%--            </c:when>--%>
<%--            <c:when test = "${customer.customer_type_id.customer_type_id == 3}">--%>
<%--                <td>Type of customer:  </td>--%>
<%--                <td>Gold  </td>--%>
<%--            </c:when>--%>
<%--            <c:when test = "${customer.customer_type_id.customer_type_id == 4}">--%>
<%--                <td>Type of customer:  </td>--%>
<%--                <td>Silver  </td>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <td>Type of customer:  </td>--%>
<%--                <td>Member  </td>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
    <td>Name of customer type: </td>
    <td>${customer.customer_type_id.customer_type_name}</td>
    </tr>
    <tr>
        <td>Name of customer: </td>
        <td>${customer.customer_name}</td>
    </tr>
    <tr>
        <td>Birthday of customer: </td>
        <td>${customer.customer_birthday}</td>
    </tr>

    <tr>
        <c:if test="${customer.customer_gender == 0}">
            <td>Gender of customer : </td>
            <td>Male </td>
        </c:if>
        <c:if test="${customer.customer_gender == 1}">
            <td>Gender of customer : </td>
            <td>Female </td>
        </c:if>
    </tr>
    <tr>
        <td>Id card of customer: </td>
        <td>${customer.customer_id_card}</td>
    </tr>
    <tr>
        <td>Phone number of customer: </td>
        <td>${customer.customer_phone}</td>
    </tr>
    <tr>
        <td>Email of customer: </td>
        <td>${customer.customer_email}</td>
    </tr>
    <tr>
        <td>Address of customer: </td>
        <td>${customer.customer_address}</td>
    </tr>
</table>
</body>
</html>
