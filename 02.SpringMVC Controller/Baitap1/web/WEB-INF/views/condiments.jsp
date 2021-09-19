<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose Condiments</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save" method="post">
    <fieldset>
        <legend>Sandwich Condiments</legend>
        <table>
            <tbody>
            <tr>
                <td>
                    <label for="lettuce">Lettuce</label>
                    <input type="checkbox" name="condiment" value="Lettuce" id="lettuce">
                </td>
                <td>
                    <label for="tomato">Tomato</label>
                    <input type="checkbox" name="condiment" value="Tomato" id="tomato">
                </td>
                <td>
                    <label for="mustard">Mustard</label>
                    <input type="checkbox" name="condiment" value="Mustard" id="mustard">
                </td>
                <td>
                    <label for="sprouts">Sprouts</label>
                    <input type="checkbox" name="condiment" value="Sprouts" id="sprouts">
                </td>
                <hr/>
                <button type="submit">Save</button>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
