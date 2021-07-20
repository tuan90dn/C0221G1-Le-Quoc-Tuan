<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>

</head>
<body>

<div class="container">
    <h1 class="text-center m-3">EDIT PRODUCT</h1>
    <c:if test="${message!=null}">
        <h3 style="color: red">${message}</h3>
    </c:if>
    <form method="post" class="m-2">
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">Name:</label>
                <input type="text" name="name" id="name" class="form-control" value="<c:out value='${product.productName}'/>">

            </div>
            <div class="col-md-6">
                <label for="price" class="form-label">Price:</label>
                <input type="text"  name="price" id="price" class="form-control" value="<c:out value='${product.productPrice}'/>">

            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="quantity" class="form-label">Quantity:</label>
                <input type="text" name="quantity" id="quantity" class="form-control" value="<c:out value='${product.productQuantity}'/>">
            </div>
            <div class="col-md-6">
                <label for="color" class="form-label">Color:</label>
                <input type="text"  name="color" id="color" class="form-control" value="<c:out value='${product.productColor}'/>">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="description" class="form-label">Description:</label>
                <input type="text" name="description" id="description" class="form-control" value="<c:out value='${product.productDescription}'/>">
            </div>
        </div>
            <div class="row m-1">
                <div class="col-md-4">
                    <label for="category" class="form-label">Category:</label>
                    <select name="category" id="category">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.categoryID}" ${category.categoryID==product.categoryID.categoryID?"selected":""}>${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

        </div>
        <div class="row m-1">
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Edit</button>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <h2>
                    <a href="/products">List All Products</a>
                </h2>
            </div>
        </div>
    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
