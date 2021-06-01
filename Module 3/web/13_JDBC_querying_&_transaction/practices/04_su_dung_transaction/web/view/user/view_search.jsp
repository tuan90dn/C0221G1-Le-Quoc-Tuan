<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/31/2021
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User details</h1>
<p>
    <a href="/users">Back to list of users</a>
</p>
<p>
    <a href="/users?action=search">Back to search form</a>
</p>
<table border="1">
    <tr>

        <td>Name Of User</td>
        <td>Email Of User</td>
        <td>Country Of User</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>

            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
