<%-- 
    Document   : characterlist
    Created on : Jul 6, 2018, 1:27:30 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.firstName}'s characters</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                
                <div class="row">
                    <div class="form-group col">
                        <a href="/home">${user.firstName} ${user.lastName}</a> / Character List
                    </div>
                    <div class="form-group col" align="right">
                        <a href="/logout">Log out</a>
                    </div>
                
                </div>
                
                <h1 class="display-4">Character Manager</h1>
                
                <div class="row">
                    <div class="form-group col">
                        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/home">Home</a>
                                    </li>
                                    <li class="nav-item active">
                                         <a class="nav-link" href="#">My Characters<span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/newchar">New Character</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                
                <div class="container">
                    <div class="row">
                        <div class="form-group col-md-8">
                            <div class="card">
                                <ul class="list-group list-group-flush">
                                    <c:forEach var="character" items="${characters}">
                                        <li class="list-group-item">
                                            <a class="btn btn-outline-primary btn-lg btn-block" href="/characterlist/info?id=${character.id}" role="button" width="100px">${character.name} | ${character.race} ${character.charClass}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>

            
            
            
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
