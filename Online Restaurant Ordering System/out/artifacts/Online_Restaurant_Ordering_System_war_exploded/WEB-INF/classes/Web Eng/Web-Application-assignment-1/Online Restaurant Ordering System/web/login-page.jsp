<html lang="en">
<head>
    <title>
        Login Page
    </title>
    <%@include file="/html/head.html"%>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        /* The message box is shown when the user clicks on the password field */

        #message {
            display:none;
            background: #f1f1f1;
            color: #000;
            position: center;
            margin-top: 1px;
        }

        #message p {
            font-size: 12px;
        }

        /* Add a red text color and an "x" when the requirements are wrong */
        .invalid {
            color: red;
        }

    </style>
</head>
<body>
<%
    if(request.getSession().getAttribute("username") != null) {
        response.sendRedirect("main-page.jsp");
    }
%>
<%@include file="/html/login-and-signup-header.html"%>

<div class="login-form">
    <form action="LoginServlet" method="post" _lpchecked="1">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input type="text" id="username" class="form-control" name="username" placeholder="Username" required="required" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAPhJREFUOBHlU70KgzAQPlMhEvoQTg6OPoOjT+JWOnRqkUKHgqWP4OQbOPokTk6OTkVULNSLVc62oJmbIdzd95NcuGjX2/3YVI/Ts+t0WLE2ut5xsQ0O+90F6UxFjAI8qNcEGONia08e6MNONYwCS7EQAizLmtGUDEzTBNd1fxsYhjEBnHPQNG3KKTYV34F8ec/zwHEciOMYyrIE3/ehKAqIoggo9inGXKmFXwbyBkmSQJqmUNe15IRhCG3byphitm1/eUzDM4qR0TTNjEixGdAnSi3keS5vSk2UDKqqgizLqB4YzvassiKhGtZ/jDMtLOnHz7TE+yf8BaDZXA509yeBAAAAAElFTkSuQmCC&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: auto;">
            <div id="message">
                <p id="equal" class="invalid"><b>Username and/or Password is incorrect</b></p>
            </div>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAPhJREFUOBHlU70KgzAQPlMhEvoQTg6OPoOjT+JWOnRqkUKHgqWP4OQbOPokTk6OTkVULNSLVc62oJmbIdzd95NcuGjX2/3YVI/Ts+t0WLE2ut5xsQ0O+90F6UxFjAI8qNcEGONia08e6MNONYwCS7EQAizLmtGUDEzTBNd1fxsYhjEBnHPQNG3KKTYV34F8ec/zwHEciOMYyrIE3/ehKAqIoggo9inGXKmFXwbyBkmSQJqmUNe15IRhCG3byphitm1/eUzDM4qR0TTNjEixGdAnSi3keS5vSk2UDKqqgizLqB4YzvassiKhGtZ/jDMtLOnHz7TE+yf8BaDZXA509yeBAAAAAElFTkSuQmCC&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: pointer;">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
    </form>
    <p class="text-center"><a href="/Online_Restaurant_Ordering_System_war_exploded/signup-page.jsp">Create an Account</a></p>
</div>

<script>
    $(document).ready(function(){
        console.log("hello2");
        var temp = "<%=(String)request.getSession().getAttribute("attemptUsername")%>";
        console.log("hello: " + temp);
        if(temp.localeCompare("null") != 0){
            document.getElementById("message").style.display = "block";
        }else{
            document.getElementById("message").style.display = "none";
        }
    });
</script>

</body>
</html>