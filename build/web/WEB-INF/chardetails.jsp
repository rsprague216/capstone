<%-- 
    Document   : chardetails
    Created on : Jul 7, 2018, 2:57:28 PM
    Author     : Ryan Sprague
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>${character.name}</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                
                <div class="row">
                    <div class="col">
                        <a href="/resettohome">${user.firstName} ${user.lastName}</a> / <a href="/resettolist">Character List</a> / ${character.name}
                    </div>
                    <div class="col" align="right">
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
                                    <li class="nav-item active">
                                        <a class="nav-link" href="#">${character.name}<span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Chat Room</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Maps</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Spell Book</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                
                
                <div class="row">
                    <div class="form-group col">
                        <div class="card">
                            <div class="row">
                                <div class="form-group col">
                                    <div class="card-body">
                                
                                        <h3 class="card-title">${character.name}</h3>
                                        <h6 class="card-subtitle mb-2 text-muted">${character.race} ${character.gender}</h6>
                                        <c:forEach var="class" items="${charClasses}">
                                            <h6 class="card-subtitle mb-2 text-muted">Level ${class.classLevel} ${class.className}</h6>
                                        </c:forEach>
                                            <h6 class="card-subtitle mb-2 text-muted">${character.alignment}</h6>
                                        <c:choose>
                                            <c:when test="${classNum == 1}">
                                                One character class.
                                            </c:when>
                                        </c:choose>
                                
                                    </div>
                                </div>
                                <div class="form-group col">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col">
                                                <h4 class="card-subtitle mb-2 text-muted">Health</h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">${character.hitPoints} hp</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <c:choose>
                                                    <c:when test="${totalLevel == 20}">
                                                        <button type="submit" class="btn btn-primary btn-lg" disabled>Level up</button>
                                                    </c:when>
                                                    <c:when test="${charClasses.size() == 1}">
                                                    
                                                        <c:forEach var="class" items="${charClasses}">
                                                            <c:choose>
                                                                <c:when test="${improveStats != null}">

                                                                    <!-- Button trigger modal -->
                                                                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModal">
                                                                        Level Up ${class.className}
                                                                    </button>

                                                                    <!-- Modal -->
                                                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                        <div class="modal-dialog" role="document">
                                                                            <div class="modal-content">
                                                                                <div class="modal-header">
                                                                                    <h5 class="modal-title" id="exampleModalLabel">Select two stats to improve</h5>
                                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                        <span aria-hidden="true">&times;</span>
                                                                                    </button>
                                                                                </div>
                                                                                <form method="POST" action="/characterlist/info">
                                                                                    <div class="modal-body">

                                                                                        <div class="row">
                                                                                            <div class="form-group col">
                                                                                                <label for="stat1">Stat 1</label>
                                                                                                <select class="form-control" id="stat1" name="stat1">
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.strength < 20}">
                                                                                                            <option value="str">Strength</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.dexterity < 20}">
                                                                                                            <option value="dex">Dexterity</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.constitution < 20}">
                                                                                                            <option value="con">Constitution</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.intelligence < 20}">
                                                                                                            <option value="int">Intelligence</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.wisdom < 20}">
                                                                                                            <option value="wis">Wisdom</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.charisma < 20}">
                                                                                                            <option value="chr">Charisma</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                </select>
                                                                                            </div>
                                                                                            <div class="form-group col">
                                                                                                <label for="stat2">Stat 2</label>
                                                                                                <select class="form-control" id="stat2" name="stat2">
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.strength < 19}">
                                                                                                            <option value="str">Strength</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.dexterity < 19}">
                                                                                                            <option value="dex">Dexterity</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.constitution < 19}">
                                                                                                            <option value="con">Constitution</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.intelligence < 19}">
                                                                                                            <option value="int">Intelligence</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.wisdom < 19}">
                                                                                                            <option value="wis">Wisdom</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                    <c:choose>
                                                                                                        <c:when test="${character.charisma < 19}">
                                                                                                            <option value="chr">Charisma</option>
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                </select>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="container">
                                                                                            <div class="container">
                                                                                                <div class="row">
                                                                                                    <div class="form-group col-md-1"></div>
                                                                                                    <div class="form-group col-md-10">
                                                                                                        <div class="row">
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="str">Strength</label>
                                                                                                                <div class="card" id="str">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.strength}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="dex">Dexterity</label>
                                                                                                                <div class="card" id="dex">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.dexterity}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="con">Constitution</label>
                                                                                                                <div class="card" id="con">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.constitution}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="form-group col-md-1"></div>
                                                                                                </div>
                                                                                                <div class="row">
                                                                                                    <div class="form-group col-md-1"></div>
                                                                                                    <div class="form-group col-md-10">
                                                                                                        <div class="row">
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="int">Intelligence</label>
                                                                                                                <div class="card" id="int">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.intelligence}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="wis">Wisdom</label>
                                                                                                                <div class="card" id="wis">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.wisdom}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="form-group col-md-4">
                                                                                                                <label for="chr">Charisma</label>
                                                                                                                <div class="card" id="chr">
                                                                                                                    <div class="card-body" align="center">
                                                                                                                        ${character.charisma}
                                                                                                                    </div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="form-group col-md-1"></div>
                                                                                                </div>
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
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form method="POST" action="/level_up">
                                                                        <button type="submit" class="btn btn-primary btn-lg">Level up ${class.className}</button>
                                                                    </form>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <!-- this is where all the stats will be displayed -->
                        <div class="row">
                            
                            <div class="form-group col-md-6">
                                
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.strength}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${strMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Strength</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                               
                                
                            </div>
                        
                            <div class="form-group col-md-6">
                                
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.intelligence}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${intMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Intelligence</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                    
                        <div class="row">
                            <div class="form-group col-md-6">
                                
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.dexterity}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${dexMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Dexterity</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        
                            <div class="form-group col-md-6">
                                
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.wisdom}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${wisMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Wisdom</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                                    
                        <div class="row">
                            <div class="form-group col-md-6">
                                
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.constitution}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${conMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Constitution</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="form-group col-md-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${character.charisma}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                            <div class="form-group col-md-6">
                                                
                                                    <div class="card" align="center">
                                                        <div class="card-body">
                                                          <h5 class="card-title">${chrMod}</h5>
                                                        </div>
                                                    </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row" align="center">
                                            <div class="col" align="center">
                                                
                                                <h6 class="card-subtitle mb-2 text-muted">Charisma</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col">
                                
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <!-- this is where the skills will be dislpayed -->
                        
                        <div id="accordion">
                            <c:forEach var="count" items="${countNums}">
                                <div class="card">
                                    <div class="card-header" id="heading${numbers[count]}">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapse${numbers[count]}" aria-expanded="false" aria-controls="collapse${numbers[count]}">
                                                ${charSkills[count].skillName} - lvl ${charSkills[count].skillLevel}
                                            </button>
                                        </h5>
                                    </div>

                                    <div id="collapse${numbers[count]}" class="collapse" aria-labelledby="heading${numbers[count]}" data-parent="#accordion">
                                        <div class="card-body">
                                            <c:choose>
                                                <c:when test="${charSkills[count].skillPath != null}">
                                                    <b>${charSkills[count].skillPath}</b> <br />
                                                </c:when>
                                            </c:choose>
                                            ${charSkills[count].skillEffect}
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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
