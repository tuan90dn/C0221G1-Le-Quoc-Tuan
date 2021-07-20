<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/26/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>PRODUCT DISCOUNT CALCULATOR</h2>
  <form method="post" action="/calculator">
    <input type="text" placeholder="Product Description">
    <input type="text" name="price" placeholder="List Price">
    <input type="text" name="discount" placeholder="Discount Percent">
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
