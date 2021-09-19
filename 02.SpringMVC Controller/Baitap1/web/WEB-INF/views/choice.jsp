<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich condiments:</h1>
<ul style="list-style-type: circle">
    <c:forEach var="condiment" items="${condiment}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
