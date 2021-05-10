<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/7/2021
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label for="fname">Name:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label>Email:</label><br>
    <input type="text" name="email"><br>
    <label>Address:</label><br>
    <input type="text" name="address"><br><br>
    <input type="submit" value="Submit">
</form>
<label><c:out value="${msg}"/>
</label>
</body>
</html>
