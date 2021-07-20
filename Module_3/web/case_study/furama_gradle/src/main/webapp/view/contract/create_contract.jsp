<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/6/2021
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../bootstrap-4.6.0-dist/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1 class="text-center m-3">ADD NEW CONTRACT</h1>
    <form method="post" class="m-2">
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">Start Date:</label>
                <input type="text" name="name" id="name" class="form-control" >
            </div>
            <div class="col-md-6">
                <label for="birthday" class="form-label">End Date:</label>
                <input type="date"  name="birthday" id="birthday" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="idCard" class="form-label">Deposit:</label>
                <input type="number" class="form-control" name="idCard" id="idCard" placeholder="123 456 789">
            </div>
            <div class="col-md-6">
                <label for="salary" class="form-label">Total money:</label>
                <input type="number" class="form-control" name="salary" id="salary">
            </div>
        </div>
        <div class="row m-1">
            <div class="col-md-4">
                <label for="idCustomer" class="form-label">Customer:</label>
                <select name="idCustomer" id="idCustomer" class="form-select">
                    <c:forEach var="idCustomer" items="${customerList}">
                    <option value="${idCustomer.customerId}">${idCustomer.customerName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="idEmployee" class="form-label">Employee:</label>
                <select name="idEmployee" id="idEmployee" class="form-select">
                    <c:forEach var="idEmployee" items="${employeeList}">
                        <option value="${idEmployee.employeeId}">${idEmployee.employeeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label for="idService" class="form-label">Service:</label>
                <select name="idService" id="idService" class="form-select">
                    <c:forEach var="idService" items="${serviceList}">
                        <option value="${idService.serviceId}">${idService.serviceName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
