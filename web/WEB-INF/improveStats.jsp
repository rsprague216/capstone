<%-- 
    Document   : improveStats
    Created on : Jun 19, 2018, 8:30:12 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Improve Stats</title>
    </head>
    <body>
        
        <div class="container">
            
            <div class="jumbotron">
                ${myChar.name}
                <h1 class="display-4">Character Manager</h1>
                <p class="lead">
                    Select two stats to improve.
                </p>
                <hr class="my-4">
                <div class="row">
                    <div class="form-group col">
                        <form method="POST" action="/improvestats">
                            <div class="row">
                            
                                <div class="form-group col-md-4">
                                    <label for="stat1">Stat 1</label>
                                    <select class="form-control" id="stat1" name="stat1">
                                        <option value="str">Strength</option>
                                        <option value="dex">Dexterity</option>
                                        <option value="con">Constitution</option>
                                        <option value="int">Intelligence</option>
                                        <option value="wis">Wisdom</option>
                                        <option value="chr">Charisma</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="stat2">Stat 2</label>
                                    <select class="form-control" id="stat2" name="stat2">
                                        <option value="str">Strength</option>
                                        <option value="dex">Dexterity</option>
                                        <option value="con">Constitution</option>
                                        <option value="int">Intelligence</option>
                                        <option value="wis">Wisdom</option>
                                        <option value="chr">Charisma</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="form-group col">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.strength}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Strength</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.dexterity}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Dexterity</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.constitution}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Constitution</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.intelligence}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Intelligence</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.wisdom}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Wisdom</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${character.charisma}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Charisma</h6>
                                    </div>
                                </div>
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
