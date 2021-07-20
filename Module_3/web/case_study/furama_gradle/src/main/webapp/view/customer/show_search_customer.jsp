<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/3/2021
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<p>
    <a href="/customers">Back to list of customer</a>
</p>
<table id="idTable" class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td><a href="/customers?action=view&id=${customer.customerId}"><c:out value="${customer.customerName}"/></a></td>
            <td><c:out value="${customer.customerAddress}"/></td>
            <td><c:out value="${customer.customerPhone}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#idTable').dataTable(
            {
                "dom":'lrtip',
                "lengthChange":false,
                "pageLength":5
            }
        );

    });
</script>
</body>
</html>
