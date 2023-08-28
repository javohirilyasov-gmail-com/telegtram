<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/28/2023
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create chat</title>
</head>
<body>


  <h1>Add chat</h1>


  <div class="create_chat">
     <form action="/chat/create-chat" method="post">
         <input type="hidden" name="id" value="${id}">
         <input type="hidden" name="username" value="${username}">
      <div class="create_chat__username">
          <input type="text" name="receiverUsername" placeholder="Enter name for User">
      </div>
      <div class="create_chat__phoneNumber">
          <input type="text" name="receiverPhoneNumber" placeholder="Enter phone number of User">
      </div>
         <button>Add Chat</button>
     </form>
  </div>


    <div class="smsForUser">
        ${sms}
    </div>

    <br>

    <form action="/menu/">
        <input type="hidden" name="id" value="${id}">
        <button>Menu</button>
    </form>

</body>
</html>
