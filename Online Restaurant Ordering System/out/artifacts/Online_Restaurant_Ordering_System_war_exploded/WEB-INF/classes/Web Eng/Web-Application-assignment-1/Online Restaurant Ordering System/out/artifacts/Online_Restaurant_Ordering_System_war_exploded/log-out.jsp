<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/21/20
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    request.getSession().setAttribute("username", null);
    request.getSession().setAttribute("attemptUsername", null);
    response.sendRedirect("login-page.jsp");
%>
</body>
</html>
