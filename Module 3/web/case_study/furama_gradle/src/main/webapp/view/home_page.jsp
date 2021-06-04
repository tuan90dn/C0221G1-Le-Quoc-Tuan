<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/29/2021
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../bootstrap-4.6.0-dist/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>

</head>
<body>
<header class="container-fluid bg-light d-flex sticky-top">
    <div class="col-lg-3">
        <img width="40px" height="40px" src="https://i.pinimg.com/280x280_RS/8c/c7/cf/8cc7cf8460083733c6e80bcdc42aeeff.jpg">
    </div>
    <div class="col-lg-6"></div>
    <div class="col-lg-3 d-flex justify-content-end">
        <h3>Lê Quốc Tuấn</h3>
    </div>
</header>

<nav class="navbar navbar-expand-lg navbar-light bg-light border">
    <a class="navbar-brand ml-5" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/employees">Employee<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customers">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/services" tabindex="-1">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" tabindex="-1">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid bg-light border" style="height: 430px">
    <div class="row" >
        <div class="col-lg-2 border-right" style="height: 430px">
            <ul>
                <li>Item One</li>
                <li>Item Two</li>
                <li>Item Three</li>
            </ul>
        </div>
        <div class="col-lg-10 "></div>
    </div>
</div>
<footer class="bg-dark text-center text-white fixed-bottom" >
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2021 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">Case Study JSP&Servlet</a>
    </div>
</footer>

<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>
</body>
</html>
