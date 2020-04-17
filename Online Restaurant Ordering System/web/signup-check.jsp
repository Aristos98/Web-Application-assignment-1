<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/15/20
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="utilities.DbUtility" %>
<%@ page import="utilities.SignupValidator" %>

<%
    String username = request.getParameter("username").toString().trim();
    String email = request.getParameter("email").toString().trim();
    String password = request.getParameter("password").toString().trim();
    String passwordConfirmation = request.getParameter("password2").toString().trim();

    if(SignupValidator.validateUser(username, email, password, passwordConfirmation)){ %>
        <script>
            /*console.log("<%= username %>");
            console.log("<%= email %>");
            console.log("<%= password %>");
            console.log("<%= passwordConfirmation %>");
            console.log("----------");
            console.log(<%= SignupValidator.validateUsernameBoolean(username) %>);
            console.log("<%= SignupValidator.validateEmailBoolean(email) %>");
            console.log(<%= SignupValidator.validatePassword(password) %>);
            console.log(<%= SignupValidator.validatePasswordConfirmation(password, passwordConfirmation) %>);
            */history.back();
        </script>
<%
}else{
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("username", username);
        response.sendRedirect("main-page.jsp");
}
%>
</body>
</html>
