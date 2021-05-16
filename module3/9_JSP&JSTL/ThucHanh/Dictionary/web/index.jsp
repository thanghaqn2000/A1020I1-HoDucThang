<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/5/2021
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/Dictionary" style="margin-left: 500px">
    <input type="text" name="word" placeholder="Type word need to translate">
    <input type="submit" value="Enter" width="200px">
</form>
<span> <%= request.getAttribute("result")%></span>
</body>
</html>
