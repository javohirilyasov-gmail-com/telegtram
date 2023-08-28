<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/28/2023
  Time: 12:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>

    <h1>Your chats</h1>
    <h3>${id}</h3>

   <div class="chats">
    <table>
        <thead>
            <tr>
                <td>Name</td>
                <td>Username</td>
            </tr>
        </thead>
        <tbody>
<%--            <c:forEach var="" items="">--%>
<%--                <tr>--%>
<%--                    <td></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
        </tbody>
    </table>
   </div>

   <br>
   <br>

   <div class="createChat">
        <form action="/chat/create-chat">
            <input type="hidden" name="username" value="${username}">
            <input type="hidden" name="id" value="${id}">
             <button>Create new chat</button>
         </form>
   </div>

    <form action="/menu/">
        <input type="hidden" name="id" value="${id}">
        <button>Menu</button>
    </form>

</body>
</html>
