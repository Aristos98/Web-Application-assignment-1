<%@ page import="classes.OrderInterface" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="utilities.DbUtility" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/26/20
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
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
    Cart cart = ((Cart)request.getSession().getAttribute("cart"));
    double totalPrice = 0;
    List<OrderInterface> orders = null;
    if(cart == null){
        cart = DbUtility.getCart((String) request.getSession().getAttribute("username"));
    }

    if(cart != null){
        request.getSession().setAttribute("cart", cart);
        orders = cart.getOrders();
        for(OrderInterface order : orders){
            totalPrice += order.getTotalPrice();
            request.setAttribute("orderInfo", order);
%>
            <jsp:include page="html/cart-item-preview.jsp"/>
<%
        }
    }else{
%>
        <h1>No Orders Yet</h1>
<%
    }
%>

<h5>Total Price = <%=totalPrice%></h5>
<%
    request.getSession().setAttribute("price", totalPrice);
%>
<form action="purchase.jsp" method="post">
    <input type="submit" name="Purchase">
</form>
<%@include file="/html/tail.html"%>
</body>
</html>
