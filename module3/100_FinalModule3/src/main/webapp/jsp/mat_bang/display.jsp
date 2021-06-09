<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/2/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
          integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
</head>
<body>
<%@include file="/jsp/container/body.jsp" %>
<div class="page-content p-5" id="content">
    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i
            class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>
    <div class="container">
        <a href="/create" class="btn btn-danger">Create</a>
        <div class="row justify-content-center">
            <div class="col-12 col-md-10 col-lg-8">
                <form class="card card-sm" action="/search" style="background: none;border: none">
                    <div class="card-body row no-gutters align-items-center">
                        <div class="col-auto">
                            <i class="fas fa-search h4 text-body"></i>
                        </div>
                        <!--end of col-->
                        <div class="col">
                            <input class="form-control form-control-lg form-control-borderless" name="search" type="search" placeholder="Type customer's name need to find">
                        </div>
                        <!--end of col-->
                        <div class="col-auto">
                            <button class="btn btn-lg btn-success" type="submit">Search</button>
                        </div>
                        <!--end of col-->
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Loại mặt bằng</th>
                        <th>Trạng thái</th>
                        <th>Diện tích</th>
                        <th>Tầng</th>
                        <th>Giá tiền</th>
                        <th>Ngày bắt đầu</th>
                        <th>Ngày kết thúc</th>
                        <th>Action</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ground" items="${listGround}">
                        <tr>
                            <td><c:out value="${ground.id}"/></td>
                            <td><c:out value="${ground.loaiMatBang}"/></td>
                            <td><c:out value="${ground.trangThai}"/></td>
                            <td><c:out value="${ground.dienTich}"/>m2</td>
                            <td><c:out value="${ground.tang}"/> </td>
                            <td><c:out value="${ground.giaTien}"/></td>
                            <td><c:out value="${ground.ngayBatDau}"/></td>
                            <td><c:out value="${ground.ngayKetThuc}"/></td>
                            <td><a href="" class="btn btn-primary">Edit</a></td>
                            <td> <a href="/delete?id=${ground.id}"
                                     onclick="return confirm('Are you sure you want to delete?')">Delete 1</a></td>

                            <td><a style="color: white" class="btn btn-danger" onclick="groundSetId('${ground.id}')"
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
                                <input type="text" id="modelId" size="50" disabled
                                       style="border: none;background: white; color: red">
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
</div>
<form action="/delete" id="deleteGround">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
</body>
<script src="../../bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function groundSetId(id) {
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Bạn có chắc chắn muốn xóa mặt bằng với mã số: " + id + " không?";
    }

    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteGround").submit();
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
</html>
