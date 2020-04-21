<%--
  Created by IntelliJ IDEA.
  User: sahyoun
  Date: 4/15/20
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Sign up</title>
    <%@include file="/html/head.html"%>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        /* The message box is shown when the user clicks on the password field */

        #message {
            background: #f1f1f1;
            color: #000;
            position: center;
            padding: 5px;
            margin-top: 10px;
        }

        #message p {
            padding: 5px 35px;
            font-size: 15px;
        }

        #message2 {
            display:none;
            background: #f1f1f1;
            color: #000;
            position: center;
            margin-top: 1px;
        }

        #message2 p {
            font-size: 12px;
        }

        #message3 {
            display:none;
            background: #f1f1f1;
            color: #000;
            position: center;
            margin-top: 1px;
        }

        #message3 p {
            font-size: 12px;
        }

        #message4 {
            display:none;
            background: #f1f1f1;
            color: #000;
            position: center;
            margin-top: 1px;
        }

        #message4 p {
            font-size: 12px;
        }

        /* Add a green text color and a checkmark when the requirements are right */
        .valid {
            color: green;
        }

        .valid:before {
            position: center;
            content: "✔";
        }

        /* Add a red text color and an "x" when the requirements are wrong */
        .invalid {
            color: red;
        }

        .invalid:before {
            position: center;
            content: "✖";
        }

    </style>
</head>
<body>
<%@include file="/html/login-and-signup-header.html"%>
<%@ page import="utilities.DbUtility" %>

<div class="login-form">
    <form action="signup-check.jsp" method="post" _lpchecked="1">
        <h2 class="text-center">Sign up</h2>
        <div class="form-group">
            <input type="text" class="form-control" name="username" id="username" placeholder="Username" required="required" >
            <div id="message3"></div>
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" id="email" placeholder="Email" required="required">
            <div id="message4"></div>
        </div>
        <div class="form-group">
            <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" class="form-control" id="password"
                   name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Confirm Password" required="required" name="password2" id="password2">
            <div id="message2">
                <p id="equal" class="invalid"> <b>Passwords DO NOT Match</b></p>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" id="myButton" class="btn btn-primary btn-block">Sign Up</button>
        </div>
    </form>
</div>

<div id="message">
    <h3>Password must contain the following:</h3>
    <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
    <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
    <p id="number" class="invalid">A <b>number</b></p>
    <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>



<script>
    var myInput = document.getElementById("password");
    var letter = document.getElementById("letter");
    var capital = document.getElementById("capital");
    var number = document.getElementById("number");
    var length = document.getElementById("length");


    var myInput2 = document.getElementById("password2");
    var passwordCheck = document.getElementById("equal");

    var username = document.getElementById("username");
    var email = document.getElementById("email");


    myInput2.onfocus = function() {
        showMessage2();
    }

    // When the user clicks outside of the password field, hide the message box
    myInput2.onblur = function() {
        document.getElementById("message2").style.display = "none";
    }

    username.onblur = function() {
        if(username.value.length != 0) {
            document.getElementById("message3").style.display = "block";
            doSubmitUsername();
        }
        check();
    }

    email.onblur = function() {
        if (email.value.length != 0) {
            document.getElementById("message4").style.display = "block";
            doSubmitEmail();
        }
        check();
    }

    // When the user starts to type something inside the password field

    myInput.onkeyup = function() {
        // Validate lowercase letters
        var lowerCaseLetters = /[a-z]/g;
        if(myInput.value.match(lowerCaseLetters)) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        // Validate capital letters
        var upperCaseLetters = /[A-Z]/g;
        if(myInput.value.match(upperCaseLetters)) {
            capital.classList.remove("invalid");
            capital.classList.add("valid");
        } else {
            capital.classList.remove("valid");
            capital.classList.add("invalid");
        }

        // Validate numbers
        var numbers = /[0-9]/g;
        if(myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
        } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
        }

        // Validate length
        if(myInput.value.length >= 8) {
            length.classList.remove("invalid");
            length.classList.add("valid");
        } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
        }
        check();
    }

    myInput2.onkeyup = function() {
        showMessage2();

        if(myInput2.value == myInput.value) {
            passwordCheck.classList.remove("invalid");
            passwordCheck.classList.add("valid");
            passwordCheck.innerText="Passwords Match";
        }else {
            passwordCheck.classList.remove("valid");
            passwordCheck.classList.add("invalid");
            passwordCheck.innerText="Passwords DO NOT Match";
        }
        check();
    }

    function check() {
        if(myInput2.value.length > 0 && username.value.length > 0 && email.value.length > 0
            && passwordCheck.className == "valid" && myInput.value == myInput2.value){
            //console.log("ITS TRUE");
            document.getElementById("myButton").disabled = false;
        }else {
            /*console.log(myInput2.value.length > 0);
            console.log(username.value.length > 0);
            console.log(email.value.length > 0);
            console.log(passwordCheck.className == "valid");
            console.log(myInput.value == myInput2.value);
            console.log(passwordCheck.className.localeCompare("valid"));
            console.log(myInput.value.localeCompare(myInput2.value));
            console.log(myInput.value);
            console.log(myInput2.value);


            console.log("ITS FALSE");*/
            document.getElementById("myButton").disabled = true;
        }
    }

    function showMessage2() {
        if(myInput2.value.length != 0){
            document.getElementById("message2").style.display = "block";
        }
    }

    function doSubmitUsername() {
        $.ajax({
            type: 'POST',
            url: 'user-check.jsp',
            data: {'username': username.value},
            error: function(response) {
                // Gets called when an error occurs with error details in variable response
            },
            success: function(response) {
                /*console.log((response.toString().trim() === "true").toString());

                console.log((response.toString().trim() == "true").toString());

                console.log((response.toString().trim().localeCompare("true")).toString());

                console.log(response + " ---- " + typeof response +  " ---- " + response.toString().trim().length);

                console.log("true".toString().trim() + " ---- " + typeof "true".toString().trim() + " ---- " + "true".toString().trim().length);*/

                $("#message3").html(response);
            }
        });
    }

    function doSubmitEmail() {
        $.ajax({
            type: 'POST',
            url: 'email-check.jsp',
            data: {'email': email.value},
            error: function(response) {
                // Gets called when an error occurs with error details in variable response
            },
            success: function(response) {
                $("#message4").html(response);
            }
        });
    }

</script>

</body>
</html>
