<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2021
  Time: 10:34 AM
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
    <h1 class="text-center m-3">ADD NEW CUSTOMER</h1>
    <form method="post" class="m-2">
        <div class="row m-1">
            <div class="col-md-12">
                <label for="idType" class="form-label">Type of Customer:</label>
                <select name="idType" id="idType" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Diamond</option>
                    <option value="2">Platinium</option>
                    <option value="3">Gold</option>
                    <option value="4">Silver</option>
                    <option value="5">Member</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">Customer's Name:</label>
                <input type="text" name="name" id="name" class="form-control" >
            </div>
            <div class="col-md-6">
                <label for="birthday" class="form-label">Customer's Birthday:</label>
                <input type="date"  name="birthday" id="birthday" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="identity" class="form-label">Identity Card:</label>
                <input type="number" class="form-control" name="identity" id="identity" >
            </div>
            <div class="col-md-6">
                <label for="idGender" class="form-label">Gender:</label>
                <select name="idGender" id="idGender" class="form-select">
                    <option selected>Choose...</option>
                    <option value="0">Male</option>
                    <option value="1">Female</option>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <label for="phone" class="form-label">Phone Number:</label>
                <input type="number" class="form-control" name="phone" id="phone">
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">Customer's Email:</label>
                <input type="email" class="form-control" name="email" id="email">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="address" class="form-label">Customer's Address</label>
                <input type="text" class="form-control" name="address" id="address">
            </div>

        </div>
        <div class="row m-1">
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <h2>
                    <a href="/customers">List All Customers</a>
                </h2>
            </div>
        </div>

    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
