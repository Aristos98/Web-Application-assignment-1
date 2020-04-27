<%@ page import="utilities.DbUtility" %><%
    DbUtility.cleanCart((String) request.getSession().getAttribute("username"), (Double) request.getSession().getAttribute("price"));
    request.getSession().setAttribute("cart", null);
    request.getSession().setAttribute("cart", null);
%>

<jsp:forward page="main-page.jsp"/>