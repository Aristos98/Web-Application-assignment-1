<%@ page import="classes.OrderInterface" %>
<%@ page import="utilities.Pair" %>
<%@ page import="java.util.List" %>

<%
    OrderInterface order = (OrderInterface) request.getAttribute("orderInfo");
    List<Pair> items = order.getItems();
%>


<h4> <%=order.getName()%> </h4> <br>

<%
    for (Pair pair : items){
%>
    <p> <%=pair.getFirst() + ": " + pair.getSecond()%> </p> <br>
<%
    }
%>
<p> <%=order.getTotalPrice()%> </p> <br>
<br>
<br>