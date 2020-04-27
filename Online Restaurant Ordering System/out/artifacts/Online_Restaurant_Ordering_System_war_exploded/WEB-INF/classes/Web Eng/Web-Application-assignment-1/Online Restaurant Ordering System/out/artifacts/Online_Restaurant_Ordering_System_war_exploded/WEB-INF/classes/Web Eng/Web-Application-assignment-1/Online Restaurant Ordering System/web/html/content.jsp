<%@ page import="classes.Meal" %>
<%
    Meal meal = (Meal) request.getAttribute("mealInfo");
    String mealType = meal.getName().endsWith("Burger") ? "Burger" : (meal.getName().endsWith("Pizza") ? "Pizza" : "Pasta");
%>

<div class="col-md-4" id="<%=meal.getName()%>">
    <div class="item-preview mb-5">
        <a class="item-preview-img box-shadow-lg d-block mb-3" href="order-page.jsp?type=<%=mealType%>&name=<%=meal.getName()%>">
            <img class="lazy img-fluid" width="400px" alt="<%=meal.getName()%>" src="<%=meal.getUrl()%>" style="">
        </a>
        <div class="item-preview-title d-flex align-items-center">
            <%=meal.getName()%>
            <!--<span class="badge badge-warning ml-auto small badge-pill"><%=meal.getName()%></span>-->
        </div>
        <!--<div class="item-preview-description">A premium Bootstrap admin theme</div>-->
    </div>
</div>