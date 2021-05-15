<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/12/2021
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        form .row {
            display: block;
            padding: 7px 8px;
            margin-bottom: 7px;
        }
        form .row:hover {
            background: #f1f7fa;
        }

        form label {
            display: inline-block;
            font-size: 1.2em;
            font-weight: bold;
            width: 120px;
            padding: 6px 0;
            color: #464646;
            vertical-align: top;
        }
        form .req { color: #ca5354; }

        form .note {
            font-size: 1.2em;
            line-height: 1.33em;
            font-weight: normal;
            padding: 2px 7px;
            margin-bottom: 10px;
        }

        form input:focus, form textarea:focus { outline: none; }

        /* placeholder styles: http://stackoverflow.com/a/2610741/477958 */
        ::-webkit-input-placeholder { color: #aaafbd; font-style: italic; } /* WebKit */
        :-moz-placeholder { color: #aaafbd; font-style: italic; }           /* Mozilla Firefox 4 to 18 */
        ::-moz-placeholder { color: #aaafbd; font-style: italic; }          /* Mozilla Firefox 19+ */
        :-ms-input-placeholder { color: #aaafbd; font-style: italic; }      /* Internet Explorer 10+ */
    </style>
</head>
<body>
<form id="contactform" name="contact" method="post" action="#">
    <p class="note"><span class="req">*</span> Asterisk fields are required</p>
    <div class="row">
        <label for="name">Your Name <span class="req">*</span></label>
        <input type="text" name="name" id="name" class="txt" tabindex="1" placeholder="Steve Jobs" required>
    </div>

    <div class="row">
        <label for="email">E-mail Address <span class="req">*</span></label>
        <input type="email" name="email" id="email" class="txt" tabindex="2" placeholder="address@domain.com" required>
    </div>

    <div class="row">
        <label for="subject">Subject <span class="req">*</span></label>
        <input type="text" name="subject" id="subject" class="txt" tabindex="3" placeholder="Advertising/Press Ideas" required>
    </div>

    <div class="row">
        <label for="message">Message <span class="req">*</span></label>
        <textarea name="message" id="message" class="txtarea" tabindex="4" required></textarea>
    </div>

    <div class="center">
        <input type="submit" id="submitbtn" name="submitbtn" tabindex="5" value="Send Message">
    </div>
</form>

<form method="post">
    <label for="fname">Id user:</label><br>
    <input type="text" id="fid" name="id" disabled="disabled" value="<c:out value="${idAuto}"/>"><br>
    <label for="fname">Name user:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label>Email :</label><br>
    <input type="text" name="email"><br>
    <label>Country:</label><br>
    <input type="text" name="country"><br>
    <input type="submit" value="submit">
</form>
<%--<label><c:out value="${msg}"/>--%>
</body>
</html>
