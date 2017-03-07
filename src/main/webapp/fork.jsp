<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8>
        <title>Kahvlid</title>
        <link rel="stylesheet" type="text/css" href="style.css" /> 
        <script type="text/javascript" src="fork.js"></script>
    </head>
    <body onload="unHide()">
    <center>
        <h1>Nimekiri</h1>
        <c:if test="${not empty forks}">
            <table class="forkTable">
                <tr>
                    <td>Id</td>
                    <td>Material</td>
                    <td>Pikkus</td>
                    <td>Harusid</td>
                    <td>Kirjeldus</td>
                    <td>Muutmine</td>
                    <td>Kustutamine</td>
                </tr>
                <c:forEach items="${forks}" var="kahvel">
                    <tr>
                        <td>${kahvel.id }</td>
                        <td>
                            <b>${kahvel.material }</b>
                        </td>
                        <td>${kahvel.length }</td>
                        <td>${kahvel.tines }</td>
                        <td>${kahvel.description }</td>
                        <td><a href="service?id=${kahvel.id }">Muuda</a></td>
                        <td><a href="service?remove=${kahvel.id }">Kustuta</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="service?add=true"><button>Lisa uus</button></a>
        </c:if>
    </center>
</body>
</html>
