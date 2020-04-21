<%@ page import="classes.Meal" %>
<%
    Meal meal = (Meal) request.getAttribute("mealInfo");
%>

<div class="col-md-4">
    <div class="item-preview mb-5">
        <a class="item-preview-img box-shadow-lg d-block mb-3" href="https://shop.startbootstrap.com/product/sb-admin-pro/">
            <img class="lazy img-fluid" width="400px" height="100px" alt="Premium Bootstrap 4 Admin Theme - SB Admin Pro" src="<%=meal.getUrl()%>" style="">
        </a>
        <div class="item-preview-title d-flex align-items-center">
            <%=meal.getName()%>
            <span class="badge badge-warning ml-auto small badge-pill"><%=meal.getName()%></span>
        </div>
        <!--<div class="item-preview-description">A premium Bootstrap admin theme</div>-->
    </div>
</div>