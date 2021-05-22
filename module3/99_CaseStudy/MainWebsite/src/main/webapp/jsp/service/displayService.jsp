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
        a.create {
            background: #ff6a1b;
            margin-left: 36px;
            font-size: 25px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }

        a.search {
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 25px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }

        a.back {
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 15px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }
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

        <h1>Service Management</h1>
        <div class="flex" style="display: flex;width: 50%;
  margin: 0 auto;justify-content: center;">
            <a class="create" href="/createService">Create</a>
        </div>
    </center>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>ID Service</th>
                        <th>Type name service</th>
                        <th>Rental type name</th>
                        <th>Type Service</th>
                        <th>Area</th>
                        <th>Number floor</th>
                        <th>Max people</th>
                        <th>Cost rental</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="service" items="${listService}">
                        <tr>
                            <td><c:out value="${service.id_service}"/></td>
                            <td><c:out value="${service.name_service}"/></td>
                            <td><c:out value="${service.name_type_rental}"/></td>
                            <td><c:out value="${service.name_type_service}"/></td>
                            <td><c:out value="${service.area}"/> m2</td>
                            <td><c:out value="${service.floor}"/></td>
                            <td><c:out value="${service.max_people}"/></td>
                            <td><c:out value="${service.cost_rental}"/></td>
                            <td><c:out value="${service.status}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <label><c:out value="${msg}"/></label>
</div>

<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
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

