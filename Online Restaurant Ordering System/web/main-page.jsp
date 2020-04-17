<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/15/20
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>
        My Online Restaurant &amp; More Main Page
    </title>
    <%@include file="/html/head.html"%>
</head>
<body>

<jsp:include page="/html/main-header.jsp"/>


<!--   tishdjkfhasjklfdhaskjdfhajksldfhsdjakf -->

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="item-preview mb-5">
                <a class="item-preview-img box-shadow-lg d-block mb-3" href="/themes/sb-admin-2">
                    <img class="lazy img-fluid" alt="Free Bootstrap Admin Theme - SB Admin 2" src="https://i.ndtvimg.com/i/2017-10/lasagna_650x400_81508844288.jpg" style="">
                </a>
                <div class="item-preview-title d-flex align-items-center">
                    SB Admin 2
                    <span class="badge badge-success ml-auto small badge-pill">Free</span>
                </div>
                <div class="item-preview-description">A free Bootstrap admin theme</div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item-preview mb-5">
                <a class="item-preview-img box-shadow-lg d-block mb-3" href="https://shop.startbootstrap.com/product/sb-ui-kit-pro/">
                    <img class="lazy img-fluid" alt="Premium Bootstrap 4 UI Kit - SB UI Kit Pro" src="https://i.ndtvimg.com/i/2017-10/lasagna_650x400_81508844288.jpg" style="">
                </a>
                <div class="item-preview-title d-flex align-items-center">
                    SB UI Kit Pro
                    <span class="badge badge-warning ml-auto small badge-pill">Pro</span>
                </div>
                <div class="item-preview-description">A premium Bootstrap 4 UI Kit</div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item-preview mb-5">
                <a class="item-preview-img box-shadow-lg d-block mb-3" href="https://shop.startbootstrap.com/product/sb-admin-pro/">
                    <img class="lazy img-fluid" alt="Premium Bootstrap 4 Admin Theme - SB Admin Pro" src="https://i.ndtvimg.com/i/2017-10/lasagna_650x400_81508844288.jpg" style="">
                </a>
                <div class="item-preview-title d-flex align-items-center">
                    SB Admin Pro
                    <span class="badge badge-warning ml-auto small badge-pill">Pro</span>
                </div>
                <div class="item-preview-description">A premium Bootstrap admin theme</div>
            </div>
        </div>
    </div>

</div>



</body>
</html>
