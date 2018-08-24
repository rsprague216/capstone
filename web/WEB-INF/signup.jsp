<%-- 
    Document   : signup
    Created on : Jul 6, 2018, 11:57:48 AM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
    </head>
    <body>
        
        <div class="container">
            <div class="jumbotron">
            <h1>Sign up</h1>
        <c:if test="${not empty error}">
            <c:out value="${error}" />
        </c:if>
        <form method="POST" action="/signup">
            <div class="form-row">
                <div class="col-md-2">
                    <label for="fName">First Name</label>
                    <input type="text" class="form-control" id="fName" name="fName" placeholder="John">
                </div>
                <div class="col-md-2">
                    <label for="lName">Last Name</label>
                    <input type="text" class="form-control" id="lName" name="lName" placeholder="Doe">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-4">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="john.doe18@gmail.com">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-4">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="jDoe18">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-4">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-4">
                    <label for="confirmpassword">Password</label>
                    <input type="password" class="form-control" id="confirmpassword" name="confirmPassword" placeholder="Confirm Password">
                </div>
            </div>
            <div class="form-row"></div>
            <br /><button type="submit" class="btn btn-primary">Submit</button>    
        </form>
            </div>
        </div>
            
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
