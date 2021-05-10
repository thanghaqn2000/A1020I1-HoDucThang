<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/10/2021
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin-left: auto;
            margin-right: auto;
            font-family: arial, sans-serif;
            border-collapse: collapse;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        a {
            text-decoration: none;
        }

        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Product's name</th>
        <th>Product's price</th>
        <th>Product's producer</th>
        <th>Product's describer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["productSearch"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/product?actionProduct=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getProducer()}</td>
            <td>${product.getDescribe()}</td>
            <td><a href="/product?actionProduct=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/product?actionProduct=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/product?actionProduct=search">Back to search</a><br>
<a href="/product" class="view">Back to product list</a>
</body>
</html>
