<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8>
        <title>Kahvlid</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
    <center>
        <a href="Forks">servlet</a> | <a href="Forks?error=true">log.txt</a> <br>
        <h1>Veateated</h1>
        <c:forEach items="${errors}" var="error">
            <p>${error}</p>
        </c:forEach>
    </center>
</body>
</html>
