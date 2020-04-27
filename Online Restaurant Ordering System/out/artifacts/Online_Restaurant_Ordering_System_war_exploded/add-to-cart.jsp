<%@ page import="classes.Cart" %>
<%@ page import="utilities.DbUtility" %>
<%@ page import="classes.OrderInterface" %>
<%@ page import="classes.BurgerOrder" %>
<%@ page import="classes.PizzaOrder" %>
<%@ page import="classes.PastaOrder" %><%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/26/20
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    Cart cart = (Cart) session1.getAttribute("cart");
    if(cart == null){
        cart = DbUtility.getCart((String) session1.getAttribute("username"));
        if(cart == null){
            cart = DbUtility.newCart((String) session1.getAttribute("username"));
        }
    }
    session1.setAttribute("cart", cart);
    String type = request.getParameter("type");
    OrderInterface order = new BurgerOrder();
    if(type.equalsIgnoreCase("burger")){
        order = new BurgerOrder();
        ((BurgerOrder)order).setName(request.getParameter("name"));
        ((BurgerOrder)order).setOrderId(cart.getOrderId());
        ((BurgerOrder)order).setMeatWeight(request.getParameter("meat"));
        ((BurgerOrder)order).setCheese(request.getParameter("cheese"));
        ((BurgerOrder)order).setTomato(request.getParameter("tomato"));
        ((BurgerOrder)order).setLettuce(request.getParameter("lettuce"));
        double price = 3;
        if(((BurgerOrder)order).getMeatWeight().equals("200g"))
            price += 1;
        if(((BurgerOrder)order).getMeatWeight().equals("250g"))
            price += 1;
        if(((BurgerOrder)order).getCheese().equalsIgnoreCase("extra"))
            price += 0.5;
        if(((BurgerOrder)order).getTomato().equalsIgnoreCase("extra"))
            price += 0.15;
        if(((BurgerOrder)order).getLettuce().equalsIgnoreCase("extra"))
            price += 0.15;

        ((BurgerOrder)order).setTotalPrice(price);
    }else if(type.equalsIgnoreCase("pizza")){
        order = new PizzaOrder();
        ((PizzaOrder)order).setName(request.getParameter("name"));
        ((PizzaOrder)order).setOrderId(cart.getOrderId());
        ((PizzaOrder)order).setOnion(request.getParameter("onion"));
        ((PizzaOrder)order).setOlive(request.getParameter("olive"));
        ((PizzaOrder)order).setCorn(request.getParameter("corn"));
        double price = 5;
        if(((PizzaOrder)order).getCorn().equalsIgnoreCase("extra"))
            price += 0.25;
        if(((PizzaOrder)order).getOnion().equalsIgnoreCase("extra"))
            price += 0.25;
        if(((PizzaOrder)order).getOlive().equalsIgnoreCase("extra"))
            price += 0.25;

        ((PizzaOrder)order).setTotalPrice(price);
    }else{
        order = new PastaOrder();
        ((PastaOrder)order).setName(request.getParameter("name"));
        ((PastaOrder)order).setOrderId(cart.getOrderId());
        ((PastaOrder)order).setMeatType(request.getParameter("meat"));
        double price = 5;
        if(((PastaOrder)order).getMeatType().equalsIgnoreCase("beef"))
            price += 1.5;

        ((PastaOrder)order).setTotalPrice(price);
    }

    cart.addOrder(order);
    response.sendRedirect("cart-page.jsp");
%>

</body>
</html>
