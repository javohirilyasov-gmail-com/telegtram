<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/26/2023
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <h1>Registration</h1>


    <a href="/auth/sign-in">
        <button>Sign in</button>
    </a>

    <br>

    <a href="/auth/sign-up">
        <button>Sign up</button>
    </a>

    <div class="userNotFound">${userNotFound}</div>

</body>
</html>
