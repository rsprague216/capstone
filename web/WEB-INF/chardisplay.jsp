<%-- 
    Document   : chardisplay
    Created on : Jul 5, 2018, 11:23:52 PM
    Author     : rspra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>char display</title>
    </head>
    <body>
        <h1>Character Manager home page</h1>
        <form method="GET" action="home">
            <input type="text" name="charName" placeholder="Search by name" />
            <input type="submit" name="submit" value="Submit" />
        </form>
        <div class="charDisplay">
            Character: <br />
            <c:out value="${myChar.name}" /> <br />
            <c:out value="${myChar.alignment}" /> | level <c:out value="${myChar.level}" /> <c:out value="${myChar.charClass}" /><br />
            <c:out value="${myChar.gender}" /> | <c:out value="${myChar.race}" /> | HP: <c:out value="${myChar.hitPoints}" /><br />
            str: <c:out value="${myChar.strength} " />     | int: <c:out value="${myChar.intelligence}" /><br />
            dex: <c:out value="${myChar.dexterity}" />    | wis: <c:out value="${myChar.wisdom}" /><br />
            con: <c:out value="${myChar.constitution}" /> | chr: <c:out value="${myChar.charisma}" /><br />
            <c:forEach var="skill" items="${myChar.charSkills}">
                ${skill.skillName} <br />
            </c:forEach>

            <form method="POST" action="level_up">
                <input type="submit" value="level up" />
            </form>
        </div>
            <form method="GET" action="newchar">
                <input type="submit" value="new character" />
            </form>
    </body>
</html>
