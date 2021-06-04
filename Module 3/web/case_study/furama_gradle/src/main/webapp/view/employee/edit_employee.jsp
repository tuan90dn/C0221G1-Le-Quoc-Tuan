<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 9:11 PM
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
    <h1>Edit Employee</h1>
    <h2>
        <a href="/employees">List All Employees</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.employee_id}'/>"/>
            </c:if>
            <tr>
                <th>Employee's Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="<c:out value='${employee.employee_name}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Birthday:</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45" value="<c:out value='${employee.employee_birthday}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Id Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45" value="<c:out value='${employee.employee_id_card}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45" value="<c:out value='${employee.employee_salary}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45" value="<c:out value='${employee.employee_phone}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="<c:out value='${employee.employee_email}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Employee's Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="<c:out value='${employee.employee_address}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Position: </th>
                <td>
                    <select name="idPosition" id="idPosition" value="<c:out value='${employee.position_id.position_name}'/>">
                        <option value="1">Lễ Tân</option>
                        <option value="2">Phục Vụ</option>
                        <option value="3">Chuyên Viên</option>
                        <option value="4">Giám Sát</option>
                        <option value="5">Quản Lý</option>
                        <option value="6">Giám Đốc</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Education Degree</th>
                <td>
                    <select name="idEducation" id="idEducation" value="<c:out value='${employee.education_degree_id.education_degree_name}'/>">
                        <option value="1">Trung Cấp</option>
                        <option value="2">Cao Đẳng</option>
                        <option value="3">Đại Học</option>
                        <option value="4">Sau Đại Học</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division</th>
                <td>
                    <select name="idDivision" id="idDivision" value="<c:out value='${employee.division_id.division_name}'/>">
                        <option value="1">Sale – Marketing</option>
                        <option value="2">Hành Chính</option>
                        <option value="3">Phục Vụ</option>
                        <option value="4">Quản Lý</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee's Username:</th>
                <td>
                    <input type="text" name="username" id="username" size="45" value="<c:out value='${employee.username}'/>"/>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
