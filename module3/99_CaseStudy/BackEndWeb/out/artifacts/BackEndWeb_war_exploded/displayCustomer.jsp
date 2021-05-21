<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/18/2021
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
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

        a.search {
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 25px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }
        a.back {
            background: #ff6a1b;
            margin-left: 61px;
            font-size: 15px;
            width: 100px;
            display: inline-block;
            border-radius: 45%;
            text-align: center;
            height: 40px;
        }
    </style>
</head>
<body>
<center>

<%--    <form class="example"  action="/customer?actionUser=search" style="margin:auto;max-width:300px">--%>
<%--        <input type="hidden" name="actionUser" value="search">--%>
<%--        <input type="text" placeholder="Type user's name" name="searchName">--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>

    <h1>Customer Management</h1>
    <div class="flex" style="display: flex;width: 50%;
  margin: 0 auto;justify-content: center;">
        <a class="create" href="/createCustomer">Create</a>
        <%--        cách 2--%>
<%--        <a class="search" href="/search">Search</a>--%>
    </div>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID Cutomer</th>
            <th>Type Cutomer</th>
            <th>Name</th>
            <th>Date Of Birth</th>
            <th>Id Card</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.customer_Id}"/></td>
                <td><c:out value="${customer.type_Customer}"/></td>
                <td><c:out value="${customer.customer_Name}"/></td>
                <td><c:out value="${customer.customer_Birthday}"/></td>
                <td><c:out value="${customer.customer_Id_Card}"/></td>
                <td><c:out value="${customer.customer_Phone}"/></td>
                <td><c:out value="${customer.customer_Email}"/></td>
                <td><c:out value="${customer.customer_Address}"/></td>
                <td>
                    <a href="/customer?actionCustomer=edit&id=${customer.customer_Id}">Edit</a>
                    <a href="/deleteCustomer?id=${customer.customer_Id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <label><c:out value="${msg}"/></label>
    <a class="back" href="/customer">Home Page</a>
</div>
</body>
</html>

