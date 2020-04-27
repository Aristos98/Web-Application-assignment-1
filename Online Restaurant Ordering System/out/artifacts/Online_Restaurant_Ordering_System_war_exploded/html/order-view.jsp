<%@ page import="classes.OrderInterface" %>
<%@ page import="classes.Cart" %>
<%@ page import="java.util.List" %><%
    double totalPrice = 0;
    List<OrderInterface> orders = ((Cart)request.getAttribute("order")).getOrders();
    for(OrderInterface order : orders){
        totalPrice += order.getTotalPrice();
        request.setAttribute("orderInfo", order);
%>
<jsp:include page="cart-item-preview.jsp"/>
<%
    }
%>

<h5>Total Price = <%=totalPrice%></h5>
<%
    request.getSession().setAttribute("price", totalPrice);
%>