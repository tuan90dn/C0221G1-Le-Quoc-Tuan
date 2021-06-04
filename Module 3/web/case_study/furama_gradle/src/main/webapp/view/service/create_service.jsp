<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Service Management</h1>
    <h2>
        <a href="/services">List All Services</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>Service's Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service's Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service's Cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Max people:</th>
                <td>
                    <input type="text" name="max" id="max" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Type of Rent</th>
                <td>
                    <select name="idRent" id="idRent">
                        <option value="1">Year</option>
                        <option value="2">Month</option>
                        <option value="3">Day</option>
                        <option value="4">Hour</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Type of Service</th>
                <td>
                    <select name="idType" id="idType">
                        <option value="1">Villa</option>
                        <option value="2">House</option>
                        <option value="3">Room</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Standard room:</th>
                <td>
                    <input type="text" name="standard" id="standard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description Other Convenience:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Pool area</th>
                <td>
                    <input type="text" name="pool" id="pool" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Number of floor:</th>
                <td>
                    <input type="text" name="floor" id="floor" size="45"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
