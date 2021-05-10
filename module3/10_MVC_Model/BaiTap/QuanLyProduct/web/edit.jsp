<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="editName"  value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="editPrice"  value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="editProducer"  value="${requestScope["product"].getProducer()}"></td>
            </tr>
            <tr>
                <td>Desciber:</td>
                <td><input type="text" name="editDescriber"  value="${requestScope["product"].getDescribe()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/product">Back to product list</a>
</body>
</html>
