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

    <form method="post" style="width: 500px;margin-right: auto;margin-left: auto">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Service Name</label>
                <input type="text" class="form-control" id="inputEmail4" placeholder="Name" name="name">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgName}"/>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Area</label>
                <input type="number" name="area" class="form-control" id="inputPassword4" placeholder=">3">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Floor</label>
                <input type="number" name="floor" class="form-control" id="inputAddress" placeholder="Floor">
            </div>
            <div class="form-group col-md-6">
                <label for="inputAddress1">Cost rental</label>
                <input type="number" name="cost" class="form-control" id="inputAddress1" placeholder="Rental">
            </div>

        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="inputAddress2">Max people</label>
                <input type="number" name="max" class="form-control" id="inputAddress2" placeholder=">5">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputState">Type Service</label>
                <select name="typeService" id="inputState" class="form-control">
                    <option value="1" selected>Villa</option>
                    <option value="2">Room</option>
                    <option value="3">House</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState2">Type rental</label>
                <select name="typeRental" id="inputState2" class="form-control">
                    <option value="1" selected>Year</option>
                    <option value="2">Month</option>
                    <option value="3">Day</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState1">Status</label>
                <select name="status" id="inputState1" class="form-control">
                    <option value="Tốt" selected>Tốt</option>
                    <option value="Bình thường">Bình thường</option>
                    <option value="Tệ">Tệ</option>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary"
                onclick="return confirm('Are you sure you want to add this service?')">Add now
        </button>
        <a href="/service" class="back" style="background: #ff505c">Back to list</a>
    </form>
</div>

<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>

</body>
</html>
