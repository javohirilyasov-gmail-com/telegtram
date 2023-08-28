<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/27/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>

        <h1>Sign In</h1>
    <form action="/auth/sign-in" method="post">
    <input type="text" name="phoneNumber" placeholder="Enter your phone number">
    <input type="password" name="password" placeholder="Enter your password">
        <button>Submit</button>
    </form>

    <div class="incorrectPassword">${incorrectPasswd}</div>

</body>
</html>
