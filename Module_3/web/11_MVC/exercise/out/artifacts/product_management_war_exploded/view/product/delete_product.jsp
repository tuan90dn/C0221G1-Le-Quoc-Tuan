<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/28/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Do you want to delete this product?</h1>
${product.toString()}
<form method="post">
    <h2>Please input again the id of product:</h2>
    <input type="text" name="id" id="id">
    <input type="submit" value="Detele Now!">
</form>

</body>
</html>
