<%@ page import="java.util.ArrayList" %>
<%@ page import="utilities.DbUtility" %>
<%@ page import="utilities.ImagesUrl" %>
<%@ page import="classes.Meal" %>
<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/17/20
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Best Pasta in the world</title>
    <%@include file="html/head.html"%>
</head>
<body>
<%
    if(request.getSession().getAttribute("username") == null) {
        response.sendRedirect("login-page.jsp");
    }
%>
<jsp:include page="html/main-header.jsp"/>

<div class="container">
    <div class="row">

        <%
            ArrayList<Meal> pastas = DbUtility.pastaInfo();
            for(Meal pasta : pastas){
                request.setAttribute("mealInfo", pasta);
        %>
        <jsp:include page="html/content.jsp"/>
        <%
            }
        %>
    </div>
</div>

<%@include file="/html/tail.html"%>
</body>
</html>
