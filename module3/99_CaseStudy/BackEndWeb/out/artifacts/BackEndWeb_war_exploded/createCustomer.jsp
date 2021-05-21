<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/19/2021
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Amiri&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<form method="post" style="width: 500px;margin-right: auto;margin-left: auto">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Name customer</label>
            <input type="text" class="form-control" id="inputEmail4" placeholder="Name" name="name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Date of birth</label>
            <input type="date" name="dof" class="form-control" id="inputPassword4" placeholder="Date of birth">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Address</label>
        <input type="text" name="address" class="form-control" id="inputAddress" placeholder="1234 Main St">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Id Card</label>
        <input type="text" name="idCard" class="form-control" id="inputAddress2" placeholder="1234567896">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity">Phone</label>
            <input type="number" name="phoneNumber" class="form-control" id="inputCity">
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
            <input type="text" name="email" class="form-control" id="inputZip">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add now</button>
    <label><c:out value="${msg}"/>
</form>

<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
