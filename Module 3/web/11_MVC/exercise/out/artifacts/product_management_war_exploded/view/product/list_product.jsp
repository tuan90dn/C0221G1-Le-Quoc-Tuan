<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/28/2021
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Of Products</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a><br>
    <a href="/products?action=search">Search product</a>
</p>
<table border="1">
    <tr>
        <td>Name Of Product</td>
        <td>Price Of Product</td>
        <td>Description Of Product</td>
        <td>Manufactory Of Product</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.idOfProduct}">${product.nameOfProduct}</a></td>
            <td>${product.priceOfProduct}</td>
            <td>${product.descriptionOfProduct}</td>
            <td>${product.manufactoryOfProduct}</td>
            <td><a href="/products?action=edit&id=${product.idOfProduct}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.idOfProduct}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
