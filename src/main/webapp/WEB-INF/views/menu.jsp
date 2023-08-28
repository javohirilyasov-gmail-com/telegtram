<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/27/2023
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>

  <h1>Welcome to Menu ${username}</h1>
  <h4>Your Id is ${id}</h4>
  <div>${name}</div>
  <div>${phoneNumber}</div>


  <form action="/user/profile">
      <input type="hidden" name="id" value="${id}">
      <input type="hidden" name="name" value="${name}">
      <input type="hidden" name="username" value="${username}">
      <input type="hidden" name="phoneNumber" value="${phoneNumber}">
      <button>Profile</button>
  </form>
  <br>
  <form action="/chat/">
      <input type="hidden" name="username" value="${username}">
      <input type="hidden" name="id" value="${id}">
      <button>My Chats</button>
  </form>
  <br>
  <form action="/menu/index">
      <button>Log out</button>
  </form>

</body>
</html>
