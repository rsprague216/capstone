<%-- 
    Document   : home
    Created on : May 22, 2018, 7:09:16 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <c:choose>
                    <c:when test="${user != null}">
                        <div class="row">
                            <div class="col">
                                ${user.firstName} ${user.lastName}
                            </div>
                            <div class="col" align="right">
                                <a href="/logout">Log out</a>
                            </div>
                        </div>
                    </c:when>
                </c:choose>
                <h1 class="display-4">Character Manager</h1>
                <c:choose>
                    <c:when test="${user != null}">
                        <div class="row">
                            <div class="form-group col">
                                <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarNav">
                                        <ul class="navbar-nav">
                                            <li class="nav-item active">
                                                <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="/characterlist">My Characters</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="/newchar">New Character</a>
                                            </li>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>
                        
                        
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">My Campaigns</h5>
                                        <p class="card-text">Campaigns I am participating in.  Display most recent campaigns here.<br /></p>
                                        <a href="#" class="btn btn-primary">Go to campaigns</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                  <div class="card-body">
                                      <h5 class="card-title">Current Characters</h5>
                                    <p class="card-text">Quick access to characters you are currently using.</p>
                                    <a href="#" class="btn btn-primary">Go to characters.</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                  <div class="card-body">
                                      <h5 class="card-title">Chat Room</h5>
                                      <p class="card-text">Chat room for players within campaigns.  Will display recent messages to you.</p>
                                    <a href="#" class="btn btn-primary">Go to chat room</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </c:when>
                    <c:otherwise>
                        <p class="lead">
                            This is a character creator and manager for D&D.
                        </p>
                        <hr class="my-4">
                        <p>
                            You aren't logged in yet!
                        </p>
                        <p class="lead">
                            
                        <div class="row">
                            <div class="col-md-1">
                                
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">
                                    Login
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="loginModalLabel">Login</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <c:if test="${not empty error}">
                                                <c:out value="${error}" />
                                            </c:if>
                                            <form method="POST" action="/login">
                                                <div class="modal-body">
                                                    
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" id="username" name="username" aria-describedby="usernameHelp" placeholder="Enter Username">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                                    </div>
                                                    
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1">
                                
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#signupModal">
                                    Signup
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="signupModalLabel">Sign up</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <c:if test="${not empty error}">
                                                <c:out value="${error}" />
                                            </c:if>
                                            <form method="POST" action="/signup">
                                                <div class="modal-body">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <input type="text" class="form-control" id="fName" name="fName" placeholder="John">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <input type="text" class="form-control" id="lName" name="lName" placeholder="Doe">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12">
                                                            <input type="email" class="form-control" id="email" name="email" placeholder="john.doe18@gmail.com">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12">
                                                            <input type="text" class="form-control" id="username" name="username" placeholder="jDoe18">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12">
                                                            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12">
                                                            <input type="password" class="form-control" id="confirmpassword" name="confirmPassword" placeholder="Confirm Password">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </p>
                    </c:otherwise>
                </c:choose>
            </div>
       
        </div>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
