<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2021
  Time: 10:16 PM
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
<div class="container-fluid">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row align-items-center">
                    <div class="col-lg-3 justify-content-start">
                        <h2>Manage <b>Contract</b></h2>
                    </div>
                    <div class="col-lg-2">
                        <a href="/view/home_page.jsp"><span>Home Page</span></a><br>
                    </div>
                    <div class="col-lg-2">
                        <a href="/contracts?action=create"><span>Add New Contract</span></a>
                    </div>
                    <div class="col-lg-2">
                        <a href="/contractdetails"><span>List Contract Detail</span></a>
                    </div>
                    <div class="col-lg-3 justify-content-end">
                        <form method="post" action="/contracts?action=search" class="form-inline my-2 my-lg-0">
                            <input name="name" id="name" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </div>
            <table id="idTable" class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                    <span class="custom-checkbox">
                    	<input type="checkbox" id="selectAll">
                    	<label for="selectAll"></label>
                    </span>
                    </th>
                    <th>Ordinal Numbers</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Name Of Employee</th>
                    <th>Name Of Customer</th>
                    <th>Name Of Service</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" varStatus="status" items="${listContract}">
                    <tr>
                        <td>
                            <span class="custom-checkbox">
                            	<input type="checkbox" id="selectAlls">
                            	<label for="selectAlls"></label>
                            </span>

                        </td>
                        <td>${status.count}</td>
                        <td><a href="/contracts?action=view&id=${contract.contractId}"><c:out value="${contract.contractStartDate}"/></a></td>
                        <td><c:out value="${contract.contractEndDate}"/></td>
                        <td><c:out value="${contract.employee.employeeName}"/></td>
                        <td><c:out value="${contract.customer.customerName}"/></td>
                        <td><c:out value="${contract.service.serviceName}"/></td>
                        <td>
                            <a href="/contracts?action=edit&id=${contract.contractId}"><i
                                    class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" onclick="deleteCustomer(${contract.contractId})" class="delete" data-toggle="modal"><i
                                    class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/contracts?action=delete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Contract</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit"class="btn btn-danger" value="Delete">
                    <input id="idDelete" type="hidden" name="delete">
                </div>
            </form>
        </div>
    </div>
</div>


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
<script>
    function deleteCustomer(id) {
        document.getElementById("idDelete").value=id;
    }
</script>
</body>
</html>
