<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/2/2021
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Edit Customer</h1>
    <h2>
        <a href="/customers">List All Customers</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Customer</h2>
            </caption>
            <c:if test="${message!=null}">
                <div class="row">
                    <h3 style="color: red">${message}</h3>
                </div>
            </c:if>

<%--            <c:if test="${customer != null}">--%>
<%--                <input type="hidden" name="id" value="<c:out value='${customer.customerId}'/>"/>--%>
<%--            </c:if>--%>
            <tr>
                <th>Type of customer</th>
                <td>
                    <select name="idType" id="idType">
                        <option value="${customer.customerType.customerTypeId}" selected>${customer.customerType.customerTypeName}</option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </td>

            </tr>
            <tr>
                <th>Customer's Name:</th>
                <td>
                    <input value="<c:out value='${customer.customerName}'/>" type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer's Birthday:</th>
                <td>
                    <input value="<c:out value='${customer.customerBirthday}'/>" type="text" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>
                    <select name="idGender" id="idGender">
                        <option value="${customer.customerGender}" ${customer.customerGender==0?"selected":""}>Male</option>
                        <option value="0">Male</option>
                        <option value="1">Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Identity Card:</th>
                <td>
                    <input value="<c:out value='${customer.customerIdCard}'/>" type="text" name="identity" id="identity" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input value="<c:out value='${customer.customerPhone}'/>" type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer's Email:</th>
                <td>
                    <input value="<c:out value='${customer.customerEmail}'/>" type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer's Address</th>
                <td>
                    <input value="<c:out value='${customer.customerAddress}'/>" type="text" name="address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
