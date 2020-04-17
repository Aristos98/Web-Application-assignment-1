<%@ page import="utilities.SignupValidator" %>
<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/15/20
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username").toString().trim();
    String message = SignupValidator.validateUsername(username);
    response.getWriter().write(message);
%>
</body>
</html>
