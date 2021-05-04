 contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator </title>
</head>
<body>
<h2>SIMPLE CALCULATOR</h2>
<form action="/calculate">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand:</td>
                <td><input name="num_one" type="text" placeholder="Type first number here"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td><input name="num_second" type="text" placeholder="Type second number here"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<span>Result: <%=request.getAttribute("tong")%> </span><br>
<span>Error: <%= request.getAttribute("err")%></span>
</body>
</html>
