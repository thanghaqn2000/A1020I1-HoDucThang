<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/28/2021
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>
<body>
<div>
    <form action="/calculatorDiscount" method="post">
        <label for="fname">Product Description</label>
        <input type="text" id="fname" name="productDescription" placeholder="Product Description..">

        <label>List Price</label>
        <input type="text" name="listPrice" placeholder="Your List Price..">

        <label>Discount Percent</label>
        <input type="text" name="discountPercent" placeholder="Your Discount Percent..">

        <label>Discount Amount</label>
        <input type="text" name="discountAmount" placeholder="Discount Amount" value="<%=request.getAttribute("discountAmount")%>">

        <label>Discount Percen</label>
        <input type="text" name="discountPercen" placeholder="Your Discount Percen..">

        <label>Discount Price</label>
        <input type="text" name="discountPrice" placeholder="Your Discount Price..">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
