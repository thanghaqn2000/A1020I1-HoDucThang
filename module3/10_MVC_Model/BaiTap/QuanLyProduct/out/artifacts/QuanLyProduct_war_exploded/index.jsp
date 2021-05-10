<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/9/2021
  Time: 10:20 AM
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
        a.search{
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 25px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }
    </style>
</head>
<body>
<h2>Management Product</h2>

<a href="/product?actionProduct=search" class="search">Search</a>
<a href="/product?actionProduct=create" class="create">Create</a>

<table>
    <tr>
        <th>Id</th>
        <th>Product's name</th>
        <th>Product's price</th>
        <th>Product's producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/product?actionProduct=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/product?actionProduct=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/product?actionProduct=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
