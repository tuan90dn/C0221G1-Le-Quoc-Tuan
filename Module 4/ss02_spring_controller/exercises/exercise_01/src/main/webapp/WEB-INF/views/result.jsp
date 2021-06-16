<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/15/2021
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
<h3>List condiments:</h3>
<form>

<c:forEach items="${result}" var="condiment">
    ${condiment}<br>
</c:forEach>
</form>
</body>
</html>
