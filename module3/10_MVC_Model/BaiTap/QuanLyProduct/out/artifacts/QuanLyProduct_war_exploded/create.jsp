<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/9/2021
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label for="fname">Name product:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label>Price product:</label><br>
    <input type="text" name="price"><br>
    <label>Producer product:</label><br>
    <input type="text" name="producer"><br><br>
    <label>Describer:</label><br>
    <input type="text" name="describer"><br><br>
    <input type="submit" value="Submit">
</form>
<label><c:out value="${msg}"/>
</body>
</html>
