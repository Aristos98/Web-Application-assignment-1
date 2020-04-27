<%@ page import="utilities.DbUtility" %>
<%@ page import="classes.Meal" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/26/20
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Place Your Order</title>
    <%@include file="html/head.html"%>
</head>
<body>
<%
    if(request.getSession().getAttribute("username") == null) {
        response.sendRedirect("login-page.jsp");
    }
%>
<jsp:include page="html/main-header.jsp"/>

<%
    Meal meal = DbUtility.getMealByName(request.getParameter("name"));
%>
<form action="add-to-cart.jsp?type=<%=request.getParameter("type")%>&name=<%=request.getParameter("name")%>" method="post">
    <img src="<%=meal.getUrl()%>" width="600px"/>
    <%
        if(request.getParameter("type").equalsIgnoreCase("burger")){
    %>
            <%@include file="html/burger-content.jsp"%>
    <%
        }
    %>
</form>


<%@include file="/html/tail.html"%>
</body>
</html>
