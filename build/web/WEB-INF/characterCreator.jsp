<%-- 
    Document   : characterCreator
    Created on : May 30, 2018, 11:18:11 PM
    Author     : rspra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Character</title>
    </head>
    <body>
        
        <div class="container">
            <div class="jumbotron">
                <h1 class="display-4">Character Manager</h1>
                <h6>New Character</h6>
                <p class="lead">
                <hr class="my-4">
                
                <div class="row">
                    <div class="form-group col-md-6">
                        <form method="POST" action="\newchar">

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="charName">Character Name</label>
                                    <input type="text" class="form-control" id="charName" name="charName" placeholder="Character Name">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label for="alignment">Alignment</label>
                                    <select class="form-control" id="alignment" list="alignment" name="alignment" placeholder="alignment">
                                        <option value="lawful good">Lawful Good</option>
                                        <option value="chaotic good">Chaotic Good</option>
                                        <option value="lawful neutral">Lawful Neutral</option>
                                        <option value="chatoic neutral">Chaotic Neutral</option>
                                        <option value="lawful evil">Lawful Evil</option>
                                        <option value="chaotic evil">Chaotic Evil</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="race">Race</label>
                                    <select class="form-control" id="race" list="race" name="race" placeholder="race">
                                        <option value="human">Human</option>
                                        <option value="elf">Elf</option>
                                        <option value="half-elf">Half-Elf</option>
                                        <option value="dwarf">Dwarf</option>
                                        <option value="halfling">Halfling</option>
                                        <option value="dragonborn">Dragonborn</option>
                                        <option value="gnome">Gnome</option>
                                        <option value="half-orc">Half-Orc</option>
                                        <option value="tiefling">Tiefling</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="charClass">Class</label>
                                    <select class="form-control" id="charClass" name="charClass">
                                        <option value="barbarian">Barbarian</option>
                                        <option value="bard">Bard</option>
                                        <option value="cleric">Cleric</option>
                                        <option value="druid">Druid</option>
                                        <option value="fighter">Fighter</option>
                                        <option value="monk">Monk</option>
                                        <option value="paladin">Paladin</option>
                                        <option value="ranger">Ranger</option>
                                        <option value="rogue">Rogue</option>
                                        <option value="sorcerer">Sorcerer</option>
                                        <option value="warlock">Warlock</option>
                                        <option value="wizard">Wizard</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-8">
                                    <label for="gender">Gender</label>
                                    <div id="gender">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="male">
                                            <label class="form-check-label" for="inlineRadio1">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="female">
                                            <label class="form-check-label" for="inlineRadio2">Female</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col">
                                    <!--<a class="btn btn-primary" href="/newcharroll" role="button">Stat Roll</a>-->
                                    
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                        Stat Roll
                                    </button>
                                    
                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Assign stats</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <c:forEach var="stat" items="${statNums}">
                                                        <div class="form-group col" align="center">
                                                            <div class="card">
                                                                ${stat}
                                                            </div>    
                                                        </div>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-4">
                                                            <label for="strStat">Strength</label>
                                                            <select class="form-control" id="strStat" name="strStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="dexStat">Dexterity</label>
                                                            <select class="form-control" id="dexStat" name="dexStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="conStat">Constitution</label>
                                                            <select class="form-control" id="conStat" name="conStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-4">
                                                            <label for="intStat">Intelligence</label>
                                                            <select class="form-control" id="intStat" name="intStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                                
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="wisStat">Wisdom</label>
                                                            <select class="form-control" id="wisStat" name="wisStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="chrStat">Charisma</label>
                                                            <select class="form-control" id="chrStat" name="chrStat">
                                                                <c:forEach var="stat" items="${statNums}">
                                                                    <option value="${stat}">${stat}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary">Save</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                        <div class="row">
                            <div class="form-group col" align="right">
                                <form method="POST" action="/reset">
                                    <button type="submit" class="btn btn-primary" name="submit">Done</button>
                                </form>
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
