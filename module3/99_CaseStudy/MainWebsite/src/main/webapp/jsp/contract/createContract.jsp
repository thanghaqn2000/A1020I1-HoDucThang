<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/19/2021
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/body.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Amiri&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        a.back {
            width: 100px;
            background: #ff505c;
            height: 41px;
            display: inline-block;
            text-align: center;
            color: white;
            text-decoration: none;
            margin-top: -2px;
            margin-left: 24px;
            border-radius: 5px;
            padding-top: 5px;
        }
    </style>
</head>
<body>
<%@include file="../container/body.jsp" %>
<!-- Page content holder -->
<div class="page-content p-5" id="content">
    <!-- Toggle button -->
    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i
            class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>

    <!-- Demo content -->
    <form method="post" action="/createContract" id="createContract" style="width: 500px;margin-right: auto;margin-left: auto">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputState11">Customer</label>
                <select name="idCus" id="inputState11" class="form-control">
                    <c:forEach var="customer" items="${listCustomer}">
                        <option value="<c:out value="${customer.customer_Id}"/>"><c:out
                                value="${customer.customer_Name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputState12">Service</label>
                <select name="idSer" id="inputState12" class="form-control">
                    <c:forEach var="service" items="${listService}">
                        <option value="<c:out value="${service.id_service}"/>"><c:out
                                value="${service.name_service}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputState10">Employee</label>
                <select name="idEmp" id="inputState10" class="form-control">
                    <c:forEach var="employee" items="${listEmployee}">
                        <option value="<c:out value="${employee.id_Employee}"/>"><c:out
                                value="${employee.name}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddres">Date Contract</label>
                <input type="date" name="dateContract" class="form-control" id="inputAddres">
            </div>
            <div class="form-group col-md-6">
                <label for="date1">End Date</label>
                <input type="date" name="endDate" class="form-control" id="date1">
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Deposits</label>
                <input type="number" name="deposits" class="form-control" id="inputAddress">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>
            </div>
            <div class="form-group col-md-6">
                <label for="inputAddress1">Total Money</label>
                <input type="number" name="total" class="form-control" id="inputAddress1" placeholder="Must be > 0">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgSalary}"/>
            </div>
        </div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Add contract
        </button>
        <a href="/contract" class="back" style="background: #ff505c">Back to list</a>
    </form>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Attention!</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure to add this contract?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="submitCreate()">Add now</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script>

    function submitCreate() {
        <!-- để submit form delete  -->
        document.getElementById("createContract").submit();
    }
</script>
</body>
</html>
