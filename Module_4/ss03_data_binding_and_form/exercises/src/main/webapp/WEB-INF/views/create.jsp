<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/17/2021
  Time: 7:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" action="/list" method="post">
    <b>Language </b><form:select path="language" items="${languageArray}"></form:select><br>
    <b>Page size </b> Show <form:select path="pageSize" items="${pageSizeArray}"></form:select> emails per page<br>
    <b>Spams Filter </b><form:checkbox path="spamsFilter" ></form:checkbox> Enable spams filter<br>
    <b>Signature </b><form:textarea path="signature"></form:textarea><br>
    <button type="submit">Update  </button>
    <button type="submit">  Cancel</button>
</form:form>
</body>
</html>
