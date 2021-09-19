<%--
  Created by IntelliJ IDEA.
  User: lomahs
  Date: 18/09/2021
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calculator">
    <fieldset>
        <legend><h1>Calculator</h1></legend>
        <label>
            <input type="text" name="firstOperand" value="${firstOperand}">
        </label>
        <label>
            <input type="text" name="secondOperand" value="${secondOperand}">
        </label>
        <h1 style="color: red">${error}</h1>
        <h4>Result: ${result}</h4>
        <button type="submit" name="operator" value="addition">Addition(+)</button>
        <button type="submit" name="operator" value="subtraction">Subtraction(-)</button>
        <button type="submit" name="operator" value="multiplication">Multiplication(x)</button>
        <button type="submit" name="operator" value="division">Division(/)</button>
    </fieldset>
</form>
</body>
</html>
