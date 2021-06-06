<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/6/2021
  Time: 2:23 PM
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
<div class="container">
    <h1 class="text-center m-3">ADD NEW CONTRACT DETAIL</h1>
    <form method="post" class="m-2">

        <div class="row">
            <div class="col-lg-6">
                <label for="idContract" class="form-label">Id Of Contract:</label>
                <select name="idContract" id="idContract" class="form-select">
                    <c:forEach var="contract" items="${contractList}">
                        <option value="${contract.contract_id}">${contract.contract_id}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-lg-6">
                <label for="idAttach" class="form-label">Employee:</label>
                <select name="idAttach" id="idAttach" class="form-select">
                    <c:forEach var="attach" items="${attachServiceList}">
                        <option value="${attach.attach_service_id}">${attach.attach_service_name}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="row">
            <div class="col-lg-12">
                <label for="quantity" class="form-label">Quantity:</label>
                <input type="text" name="quantity" id="quantity" class="form-control" >
            </div>
        </div>

    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
