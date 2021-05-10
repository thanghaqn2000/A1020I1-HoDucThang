<%@ page import="model.bean.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/7/2021
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2 style="text-align: center">List Customer</h2>
<a href="/customer?actionCustomer=create">Create student</a>

<table border="1" style="margin-left: auto;margin-right: auto">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customerList"]}' var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td><a href="/customer?actionCustomer=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?actionCustomer=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customer?actionCustomer=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<label>ID: <c:out value="${id}"/> </label>
</body>
</html>

</body>
</html>
