<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/28/2023
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

  <h1>Your profile</h1>
  <h4>Your id is ${id}</h4>

  <div class="profile">
      <input type="hidden" name="id" value="${id}">
      <div class="profile__name"><span>Your name: </span>${name}</div>
      <div class="profile__username"><span>Your username: </span>${username}</div>
      <div class="profile__phoneNumber"><span>Your phone number: </span>${phoneNumber}</div>
  </div>

    <form action="/user/edit">
        <input type="hidden" name="phoneNumber" value="${phoneNumber}">
        <input type="hidden" name="username" value="${username}">
        <input type="hidden" name="name" value="${name}">
        <input type="hidden" name="id" value="${id}">
        <button>Edit Profile</button>
    </form>



  <form action="/menu/">
      <input type="hidden" name="phoneNumber" value="${phoneNumber}">
      <input type="hidden" name="username" value="${username}">
      <input type="hidden" name="name" value="${name}">
      <input type="hidden" name="id" value="${id}">
      <button>Menu</button>
  </form>

</body>
</html>
