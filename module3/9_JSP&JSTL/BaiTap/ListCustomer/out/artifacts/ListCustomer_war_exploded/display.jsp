
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">Danh sách khách hàng</h2>
<table border="1" style="margin-left: auto;
  margin-right: auto;width: 500px">
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.index+1}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.dateOfBirth}"/></td>
                <td><c:out value="${customer.address}"/></td>
<%--                <td><img src="${pageContext.request.contextPath}${customer.img}/></td>--%>
              <td> <img src="<c:out value="${customer.img}" />" width="180" height="180"/></td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
