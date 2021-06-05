<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2021
  Time: 10:20 AM
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
    <h1 class="text-center m-3">ADD NEW SERVICE</h1>
    <form method="post" class="m-2">
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">Service's Name:</label>
                <input type="text" name="name" id="name" class="form-control" >
            </div>
            <div class="col-md-6">
                <label for="area" class="form-label">Service's Area:</label>
                <input type="text"  name="area" id="area" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="cost" class="form-label">Service's Cost:</label>
                <input type="number" class="form-control" name="cost" id="cost" >
            </div>
            <div class="col-md-6">
                <label for="max" class="form-label">Max people:</label>
                <input type="number" class="form-control" name="max" id="max">
            </div>
        </div>

        <div class="row m-1">
            <div class="col-md-6">
                <label for="idRent" class="form-label">Type of Rent:</label>
                <select name="idRent" id="idRent" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Year</option>
                    <option value="2">Month</option>
                    <option value="3">Day</option>
                    <option value="4">Hour</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="idType" class="form-label">Type of Service:</label>
                <select name="idType" id="idType" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Villa</option>
                    <option value="2">House</option>
                    <option value="3">Room</option>
                </select>
            </div>

        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="standard" class="form-label">Standard room:</label>
                <input type="text" class="form-control" name="standard" id="standard">
            </div>
            <div class="col-md-6">
                <label for="description" class="form-label">Description Other Convenience:</label>
                <input type="text" class="form-control" name="description" id="description">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="pool" class="form-label">Pool area</label>
                <input type="number" class="form-control" name="pool" id="pool">
            </div>
            <div class="col-md-6">
                <label for="floor" class="form-label">Number of floor:</label>
                <input type="number" class="form-control" name="floor" id="floor">
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
                    <a href="/services">List All Services</a>
                </h2>
            </div>
        </div>
    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
