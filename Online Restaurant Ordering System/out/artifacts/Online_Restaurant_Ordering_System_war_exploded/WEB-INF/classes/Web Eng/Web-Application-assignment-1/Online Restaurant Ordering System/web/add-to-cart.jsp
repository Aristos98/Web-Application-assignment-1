<%@ page import="classes.Meal" %>
<%@ page import="utilities.DbUtility" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/21/20
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String mealName = request.getParameter("name");
    Meal meal = DbUtility.getMealByName(mealName);
%>
<h1> <%=meal.getName()%> </h1> <br>
<img src="<%=meal.getUrl()%>"/> <br>
<h1> <%=meal.getPrice()%> </h1> <br>
</body>
</html>
