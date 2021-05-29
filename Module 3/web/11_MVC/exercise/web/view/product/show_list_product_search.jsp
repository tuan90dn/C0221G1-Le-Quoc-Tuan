<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/29/2021
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/products">Back to list of products</a>
</p>
<p>
    <a href="/products?action=search">Back to search form</a>
</p>
<table border="1">
    <tr>
        <td>Name Of Product</td>
        <td>Price Of Product</td>
        <td>Description Of Product</td>
        <td>Manufactory Of Product</td>

    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.nameOfProduct}</td>
            <td>${product.priceOfProduct}</td>
            <td>${product.descriptionOfProduct}</td>
            <td>${product.manufactoryOfProduct}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
