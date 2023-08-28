<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/27/2023
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>


    <h1>Sign Up</h1>

    <form action="/auth/sign-up" method="post">
    <input type="text" name="name" placeholder="Enter your name">
    <input type="text" name="username" placeholder="Enter your username">
    <input type="password" name="password" placeholder="Enter your password">
    <input type="text" name="phoneNumber" placeholder="Enter your phone number">
        <button>Submit</button>
    </form>

</body>
</html>
