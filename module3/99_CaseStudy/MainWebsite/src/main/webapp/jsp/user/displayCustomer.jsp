<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/18/2021
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

    <title></title>
    <style>

    </style>
</head>
<body>
<%@include file="../container/body.jsp" %>
<!-- End vertical navbar -->


<!-- Page content holder -->
<div class="page-content p-5" id="content">
    <!-- Toggle button -->
    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i
            class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>

    <center>

        <h1>Customer Management</h1>
        <div class="flex" style="display: flex;width: 50%;
  margin: 0 auto;justify-content: center;">
            <a class="btn btn-primary create" href="/createCustomer">Create</a>
        </div>
    </center>
    <div class="container">
        <br/>
        <div class="row justify-content-center">
            <div class="col-12 col-md-10 col-lg-8">
                <form class="card card-sm" action="/searchCustomer" style="background: none;border: none">
                    <div class="card-body row no-gutters align-items-center">
                        <div class="col-auto">
                            <i class="fas fa-search h4 text-body"></i>
                        </div>
                        <!--end of col-->
                        <div class="col">
                            <input class="form-control form-control-lg form-control-borderless" name="nameSearch" type="search" placeholder="Type customer's name need to find">
                        </div>
                        <!--end of col-->
                        <div class="col-auto">
                            <button class="btn btn-lg btn-success" type="submit">Search</button>
                        </div>
                        <!--end of col-->
                    </div>
                </form>
            </div>
            <!--end of col-->
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>ID Cutomer</th>
                        <th>Type Cutomer</th>
                        <th>Name</th>
                        <th>Date Of Birth</th>
                        <th>Id Card</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${listCustomer}">
                        <tr>
                            <td><c:out value="${customer.customer_Id}"/></td>
                            <td><c:out value="${customer.type_Customer}"/></td>
                            <td><c:out value="${customer.customer_Name}"/></td>
                            <td><c:out value="${customer.customer_Birthday}"/></td>
                            <td><c:out value="${customer.customer_Id_Card}"/></td>
                            <td><c:out value="${customer.customer_Phone}"/></td>
                            <td><c:out value="${customer.customer_Email}"/></td>
                            <td><c:out value="${customer.customer_Address}"/></td>
                            <td>
                                <a class="btn btn-primary" href="/editCustomer?id=${customer.customer_Id}">Edit</a>

<%--                                <a  href="/deleteCustomer?id=${customer.customer_Id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>--%>
                            </td>
                            <td> <a style="color: white" class="btn btn-danger" onclick="customerSetId('${customer.customer_Id}','${customer.customer_Name}')"
                                    data-toggle="modal" data-target="#deleteModal">
                                Delete
                            </a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <input type="text" id="modelId" size="50" disabled style="border: none;background: white; color: red">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <label><c:out value="${msg}"/></label>
    <a class="btn btn-danger" href="/customer">Home Page</a>-->
</div>
<form action="/deleteCustomer" id="deleteCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="idCustomer" id="idCustomer">
</form>
<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function customerSetId(id, name) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("modelId").value = "Do you want delete customer name: " + name;
    }

    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteCustomer").submit();
    }
</script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>

</body>
</html>

