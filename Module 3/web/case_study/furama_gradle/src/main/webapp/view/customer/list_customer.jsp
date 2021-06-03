<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/29/2021
  Time: 9:02 PM
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
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Manage <b>Customer</b></h2>
                    </div>
                    <div class="col-sm-6">
                        <a href="/customers?action=create"><span>Add New Customer</span></a><br>
                        <a href="/customers?action=search"><span>Search Customer</span></a>


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
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${listCustomer}">
                    <tr>
                        <td>
                            <span class="custom-checkbox">
                            	<input type="checkbox" id="selectAlls">
                            	<label for="selectAll"></label>
                            </span>

                        </td>
                        <td><a href="/customers?action=view&id=${customer.customer_id}"><c:out value="${customer.customer_name}"/></a></td>
                        <td><c:out value="${customer.customer_address}"/></td>
                        <td><c:out value="${customer.customer_phone}"/></td>
                        <td><c:out value="${customer.customer_email}"/></td>
                        <td>
<%--                            <a href="/customers?action=edit&id=${customer.customer_id}">Edit</a>--%>
                            <a href="/customers?action=edit&id=${customer.customer_id}"><i
                                    class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" onclick="deleteCustomer(${customer.customer_id})" class="delete" data-toggle="modal"><i
                                class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
<%--                            <input id="idDelete" value="${customer.customer_id}" type="hidden" name="idDelete">--%>
<%--                            <a href="/customers?action=delete&id=${customer.customer_id}" class="delete" data-toggle="modal"><i--%>
<%--                                    class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>--%>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            <div class="row clearfix">--%>
<%--                <div class="hint-text col-lg-4">Showing <b>5</b> out of <b>25</b> entries</div>--%>
<%--                <div class="col-lg-4"></div>--%>
<%--                <div class="col-lg-4">--%>
<%--                    <ul class="pagination">--%>
<%--                        <li class="page-item"><a href="#" class="page-link">Previous</a></li>--%>
<%--                        <li class="page-item active"><a href="#" class="page-link">1</a></li>--%>
<%--                        <li class="page-item"><a href="#" class="page-link">2</a></li>--%>
<%--                        <li class="page-item"><a href="#" class="page-link">3</a></li>--%>
<%--                        <li class="page-item"><a href="#" class="page-link">4</a></li>--%>
<%--                        <li class="page-item"><a href="#" class="page-link">5</a></li>--%>
<%--                        <li class="page-item"><a href="#" class="page-link">Next</a></li>--%>
<%--                    </ul>--%>
<%--                </div>--%>

<%--            </div>--%>
        </div>
    </div>
</div>

<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/customers?action=delete">
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
                    <input type="submit" id="idDelete" name="delete"  class="btn btn-danger" value="Delete">
<%--                    <input id="idDelete" type="hidden" name="delete">--%>
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
