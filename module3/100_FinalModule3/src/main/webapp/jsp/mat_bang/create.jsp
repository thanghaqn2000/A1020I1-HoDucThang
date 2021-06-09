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
            <div class="form-group col-md-4">
                <label for="inputState12">Loại mặt bằng</label>
                <select name="idLoaiMatBang" id="inputState12" class="form-control">
                    <option value="1" selected>văn phòng</option>
                    <option value="2">Văn phòng chia sẻ</option>
                    <option value="3">Văn phòng trọn gói</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState13">Trạng thái</label>
                <select name="trangThai" id="inputState13" class="form-control">
                    <option value="Trống" selected>Trống</option>
                    <option value="Hạ tầng">Hạ tầng</option>
                    <option value="Đầy đủ">Đầy đủ</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Diện tích</label>
                <input type="number" name="dienTich" class="form-control" id="inputAddress" placeholder=">20m2">
            </div>
            <div class="form-group col-md-6">
                <label for="a">Tầng</label>
                <select name="tang" id="a" class="form-control">
                    <option value="1" selected>Tầng 1</option>
                    <option value="2" selected>Tầng 2</option>
                    <option value="3" selected>Tầng 3</option>
                    <option value="4" selected>Tầng 4</option>
                    <option value="5" selected>Tầng 5</option>
                    <option value="6" selected>Tầng 6</option>
                    <option value="7" selected>Tầng 7</option>
                    <option value="8" selected>Tầng 8</option>
                    <option value="9" selected>Tầng 9</option>
                    <option value="10" selected>Tầng 10</option>
                    <option value="11" selected>Tầng 11</option>
                    <option value="12" selected>Tầng 12</option>
                    <option value="13" selected>Tầng 13</option>
                    <option value="14" selected>Tầng 14</option>
                    <option value="15" selected>Tầng 15</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group">
                <label for="inputAddress2">Giá tiền</label>
                <input type="number" name="giaTien" class="form-control" id="inputAddress2" placeholder=">1.000.000 VND">
<%--                <label style="color: #c6490e;font-weight: bold;"><c:out value="${msgIdCard}"/>--%>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputState">Ngày bắt đầu</label>
                <input type="date" name="ngayBatDau" class="form-control" id="inputState" placeholder="dd/mm/yyyy">
            </div>
            <div class="form-group col-md-6">
                <label for="inputState1">Ngày kết thúc</label>
                <input type="date" name="ngayKetThuc" class="form-control" id="inputState1" placeholder="dd/mm/yyyy">
            </div>
        </div>
        <button type="submit" class="btn btn-primary"
                onclick="return confirm('Are you sure you want to add this service?')">Add now
        </button>
        <a href="/display" class="back" style="background: #ff505c">Back to list</a>
    </form>
</div>

<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>

</body>
</html>
