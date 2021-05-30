<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/28/2021
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to list of products</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name of product: </td>
                <td><input type="text" name="name" id="name" value="${product.nameOfProduct}"></td>
            </tr>
            <tr>
                <td>Price of product: </td>
                <td><input type="text" name="price" id="price" value="${product.priceOfProduct}"></td>
            </tr>
            <tr>
                <td>Description of product: </td>
                <td><input type="text" name="description" id="description" value="${product.descriptionOfProduct}"></td>
            </tr>
            <tr>
                <td>Manufactory of product: </td>
                <td><input type="text" name="manufactory" id="manufactory" value="${product.manufactoryOfProduct}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
