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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Amiri&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        a.back{
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
<%@include file="../container/body.jsp"%>
<!-- Page content holder -->
<div class="page-content p-5" id="content">
    <!-- Toggle button -->
    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>

    <!-- Demo content -->

    <form method="post" style="width: 500px;margin-right: auto;margin-left: auto">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Id customer</label>
                <input type="text" disabled="disabled" class="form-control" value="${requestScope["customer"].getCustomer_Id()}" >
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgName}"/>

            </div>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Name customer</label>
                <input type="text" class="form-control" id="inputEmail4" name="name" value="${requestScope["customer"].getCustomer_Name()}" >
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Date of birth</label>
                <input type="date" name="dof" class="form-control" id="inputPassword4" value="${requestScope["customer"].getCustomer_Birthday()}" >
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress">Address</label>
            <input type="text" name="address" class="form-control" id="inputAddress" value="${requestScope["customer"].getCustomer_Address()}">
        </div>
        <div class="form-group">
            <label for="inputAddress2">Id Card</label>
            <input type="text" name="idCard" class="form-control" id="inputAddress2" value="${requestScope["customer"].getCustomer_Id_Card()}">
            <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>
        </div>
        <div class="form-group">
            <label >Type Customer</label>
            <input type="text"  disabled="disabled" name="typeCustomer" class="form-control" value="${requestScope["customer"].getType_Customer()}">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputCity">Phone</label>
                <input type="number" name="phoneNumber" class="form-control" id="inputCity" value="${requestScope["customer"].getCustomer_Phone()}">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgPhone}"/>

            </div>
            <div class="form-group col-md-4">
                <label for="inputState">Type Customer</label>
                <select name="type" id="inputState" class="form-control">
                    <option value="1" selected>Diamond</option>
                    <option value="2" >Platinium</option>
                    <option value="3" >Gold</option>
                    <option value="4">Silver</option>
                    <option value="5" >Member</option>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputZip">Email</label>
                <input type="text" name="email" class="form-control" id="inputZip" value="${requestScope["customer"].getCustomer_Email()}">
                <label style="color: #c6490e;font-weight: bold;" ><c:out value="${msgEmail}"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Are you sure you want to update?')">Update now</button>
        <a href="/viewCustomer" class="back" style="background: #ff505c">Back to list</a>
        <label><c:out value="${msg}"/>
    </form>
</div>

<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>

</body>
</html>
