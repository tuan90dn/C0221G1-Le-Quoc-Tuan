<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 9:46 PM
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
    <a href="/employees">Back to list of employee</a>
</p>
<table id="idTable" class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Name of employee</th>
        <th>Birthday of employee</th>
        <th>Address of employee</th>
        <th>Position of employee</th>
        <th>Education Degree of employee</th>
        <th>Division of employee</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${listEmployee}">
        <tr>
            <td><a href="/employees?action=view&id=${employee.employeeId}"><c:out value="${employee.employeeName}"/></a></td>
            <td><c:out value="${employee.employeeBirthday}"/></td>
            <td><c:out value="${employee.employeeAddress}"/></td>
            <td><c:out value="${employee.employeePosition.positionName}"/></td>
            <td><c:out value="${employee.employeeEducationDegree.educationDegreeName}"/></td>
            <td><c:out value="${employee.employeeDivision.divisionName}"/></td>
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
