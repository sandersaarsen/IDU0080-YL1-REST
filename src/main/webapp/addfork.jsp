<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <center>
        <head>
            <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8>
            <title>Kahvlid</title>
            <link rel="stylesheet" type="text/css" href="style.css" /> 
            <script type="text/javascript" src="fork.js"></script>
        </head>
        <body>
            <c:if test="${not empty error}">
                <p style="color:red;">Viga salvestamisel, kontrollige andmeid!</p>
            </c:if>
                <form action="service?action=add" method="POST">
                    <h1>Muutmine</h1>
                    <table class="editTable">
                        <tr>
                            <td>Väli</td>
                            <td>Väärtus</td>
                        </tr>
                        <tr>
                            <td>Material:</td>
                            <td><input type="text" name="material"></td>
                        </tr>
                        <tr>
                            <td>Pikkus</td>
                            <td><input type="text" name="length"></td>
                        </tr>
                        <tr>
                            <td>Harusid</td>
                            <td><input type="text" name="tines"></td>
                        </tr>
                        <tr>
                            <td>Kirjeldus</td>
                            <td><input type="text" name="description"></td>
                        </tr>
                    </table>
                    <br/> <br/>
                    <input type="button" onclick="goBack()" value="Tühista">
                    <input type="submit" value="Salvesta">
                </form>
    </center>
</body>
</html>
