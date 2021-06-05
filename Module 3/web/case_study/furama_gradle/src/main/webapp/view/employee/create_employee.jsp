<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2021
  Time: 9:40 AM
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
    <h1 class="text-center m-3">ADD NEW EMPLOYEE</h1>
    <form method="post" class="m-2">
        <div class="row">
            <div class="col-md-6">
                <label for="name" class="form-label">Employee's Name:</label>
                <input type="text" name="name" id="name" class="form-control" >
            </div>
            <div class="col-md-6">
                <label for="birthday" class="form-label">Employee's Birthday:</label>
                <input type="date"  name="birthday" id="birthday" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="idCard" class="form-label">Employee's Id Card:</label>
                <input type="number" class="form-control" name="idCard" id="idCard" placeholder="123 456 789">
            </div>
            <div class="col-md-6">
                <label for="salary" class="form-label">Employee's Salary:</label>
                <input type="number" class="form-control" name="salary" id="salary">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <label for="phone" class="form-label">Employee's Phone:</label>
                <input type="number" class="form-control" name="phone" id="phone">
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">Employee's Email:</label>
                <input type="email" class="form-control" name="email" id="email">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="address" class="form-label">Employee's Address:</label>
                <input type="text" class="form-control" name="address" id="address">
            </div>
        </div>
        <div class="row m-1">
            <div class="col-md-4">
                <label for="idPosition" class="form-label">Position:</label>
                <select name="idPosition" id="idPosition" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Lễ Tân</option>
                    <option value="2">Phục Vụ</option>
                    <option value="3">Chuyên Viên</option>
                    <option value="4">Giám Sát</option>
                    <option value="5">Quản Lý</option>
                    <option value="6">Giám Đốc</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="idEducation" class="form-label">Education Degree:</label>
                <select name="idEducation" id="idEducation" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Trung Cấp</option>
                    <option value="2">Cao Đẳng</option>
                    <option value="3">Đại Học</option>
                    <option value="4">Sau Đại Học</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="idDivision" class="form-label">Division:</label>
                <select name="idDivision" id="idDivision" class="form-select">
                    <option selected>Choose...</option>
                    <option value="1">Sale – Marketing</option>
                    <option value="2">Hành Chính</option>
                    <option value="3">Phục Vụ</option>
                    <option value="4">Quản Lý</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label for="username" class="form-label">Employee's Username:</label>
                <input type="text" class="form-control" name="username" id="username">
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
                    <a href="/employees">List All Employees</a>
                </h2>
            </div>
        </div>
    </form>
</div>


<script src="../../jquery/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
