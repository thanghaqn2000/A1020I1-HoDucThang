<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/9/2021
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        a.view {
            background: #ff6a1b;
            margin-left: 700px;
            font-size: 16px;
            width: 124px;
            display: inline-block;
            border-radius: 49%;
            text-align: center;
            height: 46px;
            padding-top: 16px;
            margin-top: 40px;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">Detail Product</h2>
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
    <tr>
        <td>${requestScope["product"].getId()}</td>
        <td>
            <a href="/product?actionProduct=view&id=${requestScope["product"].getId()}">${requestScope["product"].getName()}</a>
        </td>
        <td>${requestScope["product"].getPrice()}</td>
        <td>${requestScope["product"].getProducer()}</td>
        <td>${requestScope["product"].getDescribe()}</td>
        <td><a href="/product?actionProduct=edit&id=${requestScope["product"].getId()}">Edit</a></td>
        <td><a href="/product?actionProduct=delete&id=${requestScope["product"].getId()}">Delete</a></td>
    </tr>
</table>
<a href="/product" class="view">Back to product list</a>
</body>
</html>
