<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2021
  Time: 10:30 AM
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
    <script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row align-items-center">
                    <div class="col-sm-4">
                        <h2>Manage <b>Service</b></h2>
                    </div>
                    <div class="col-lg-2">
                        <a href="/view/home_page.jsp"><span>Home Page</span></a><br>
                    </div>
                    <div class="col-sm-2">
                        <a href="/services?action=create"><span>Add New Service</span></a><br>
                    </div>
                    <div class="col-lg-4">
                        <form method="post" action="/services?action=search" class="form-inline my-2 my-lg-0">
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
                    <th>Name of service</th>
                    <th>Rent type</th>
                    <th>Service type</th>
                    <th>Number of floor</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" varStatus="status" items="${listService}">
                    <tr>
                        <td>
                            <span class="custom-checkbox">
                            	<input type="checkbox" id="selectAlls">
                            	<label for="selectAlls"></label>
                            </span>

                        </td>
                        <td>${status.count}</td>
                        <td><a href="/services?action=view&id=${service.serviceId}"><c:out value="${service.serviceName}"/></a></td>
                        <td><c:out value="${service.rentType.rentTypeName}"/></td>
                        <td><c:out value="${service.serviceType.serviceTypeName}"/></td>
                        <td><c:out value="${service.numberOfFloor}"/></td>
                        <td>

                            <a href="/services?action=edit&id=${service.serviceId}"><i
                                    class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" onclick="deleteCustomer(${service.serviceId})" class="delete" data-toggle="modal"><i
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
            <form method="post" action="/services?action=delete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
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
