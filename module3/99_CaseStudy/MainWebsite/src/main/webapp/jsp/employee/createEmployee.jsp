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
                <label for="inputEmail4">Name employee</label>
                <input type="text" class="form-control" id="inputEmail4" placeholder="Name" name="name">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgName}"/>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Date of birth</label>
                <input type="date" name="dof" class="form-control" id="inputPassword4" placeholder="Exm: 12/02/2000">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputState">Level</label>
                <select name="level" id="inputState" class="form-control">
                    <option value="1" selected>Đại học</option>
                    <option value="2">Trung cấp</option>
                    <option value="3">Cao đẳng</option>
                    <option value="4">Sau đại học</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState2">Position</label>
                <select name="position" id="inputState2" class="form-control">
                    <option value="1" selected>Giám đốc</option>
                    <option value="2">Quản lí </option>
                    <option value="3">Giám sát</option>
                    <option value="4">Chuyên viên</option>
                    <option value="5">Phục vụ</option>
                    <option value="6">Lễ tân</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState1">Department</label>
                <select name="department" id="inputState1" class="form-control">
                    <option value="1" selected>Sale - Marketing</option>
                    <option value="2">Hành chính</option>
                    <option value="3">Quản lí</option>
                    <option value="4">Phục vụ</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Id Card</label>
                <input type="number" name="idCard" class="form-control" id="inputAddress" placeholder="XXXXXXXXX or XXXXXXXXX(0-9)">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>
            </div>
            <div class="form-group col-md-6">
                <label for="inputAddress1">Salary</label>
                <input type="number" name="salary" class="form-control" id="inputAddress1" placeholder="Must be > 0">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgSalary}"/>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="inputAddress2">Phone number</label>
                <input type="number" name="phoneNumber" class="form-control" id="inputAddress2" placeholder="091xxxxxxx or (84)+90xxxxxxx ">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgPhone}"/>
            </div>
            <div class="form-group">
                <label for="inputAddress3">Email</label>
                <input type="text" name="email" class="form-control" id="inputAddress3" placeholder="Exm: thang@codegym.vn">
                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgEmail}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputAddress4">Address </label>
            <input type="text" name="address" class="form-control" id="inputAddress4" placeholder="Exm: Đà Nẵng">
        </div>
        <button type="submit" class="btn btn-primary"
                onclick="return confirm('Are you sure you want to add this employee?')">Add now
        </button>
        <a href="/employee" class="back" style="background: #ff505c">Back to list</a>
    </form>
</div>

<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>

</body>
</html>
