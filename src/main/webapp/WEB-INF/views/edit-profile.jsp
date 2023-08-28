<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/28/2023
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>

    <h1>Settings</h1>

    <div class="edit">
        <form action="/user/edit" method="post">
        <input type="hidden" name="id" value="${id}">
        <input type="text" name="name" placeholder="Enter name">
        <input type="text" name="username" placeholder="Enter username">
        <input type="text" name="phoneNumber" placeholder="Enter phone number">
        <input type="password" name="password" placeholder="Enter password">
        <button>Submit</button>
        </form>
    </div>

    <form action="/menu/">
        <input type="hidden" name="name" value="${name}">
        <input type="hidden" name="username" value="${username}">
        <input type="hidden" name="phoneNumber" value="${phoneNumber}">
        <input type="hidden" name="id" value="${id}">
        <button>Menu</button>
    </form>

</body>
</html>
