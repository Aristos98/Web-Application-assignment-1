<%@ page import="utilities.SignupValidator" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/15/20
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email = request.getParameter("email").toString().trim();
    String message = SignupValidator.validateEmail(email);
    response.getWriter().write(message);
%>
</body>
</html>
