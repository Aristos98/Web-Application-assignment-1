<%@ page import="classes.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="utilities.DbUtility" %>
<%@ page import="utilities.History" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/26/20
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View History</title>
    <%@include file="/html/head.html"%>
</head>
<body>
<%
    if(request.getSession().getAttribute("username") == null) {
        response.sendRedirect("login-page.jsp");
    }
%>
<jsp:include page="/html/main-header.jsp"/>

<%
    History history = DbUtility.getHistory((String)request.getSession().getAttribute("username"));
    if(history != null){
        List<Cart> items = history.getHistory();
        for(Cart item : items){
            request.setAttribute("order", item);
%>
            <h3>Order ID: <%=item.getOrderId()%></h3> <br>
            <h3>Order Date: <%=item.getDate()%></h3> <br> <br>
            <jsp:include page="html/order-view.jsp"/>
<%
        }
    }else{
%>
        <h1>No History Found</h1>
<%
    }
%>
<%@include file="/html/tail.html"%>
</body>
</html>
