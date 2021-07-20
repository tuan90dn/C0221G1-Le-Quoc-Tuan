<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/28/2021
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to list of products</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${product.nameOfProduct}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.priceOfProduct}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${product.descriptionOfProduct}</td>
    </tr>
    <tr>
        <td>Manufactory: </td>
        <td>${product.manufactoryOfProduct}</td>
    </tr>
</table>
</body>
</html>
