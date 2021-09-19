<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/translate" method="post">
    <form>
        <fieldset>
            <legend>Dictionary</legend>
            <table>
                <tbody>
                <tr>
                    <th>English: </th>
                    <td>
                        <label>
                            <input type="text" name="english" value="${english}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>Vietnamese: </th>
                    <td>
                        <label>
                            <input type="text" name="vietnamese" value="${vietnamese}"/>
                        </label>
                    </td>
                </tr>
                </tbody>
                <button type="submit">Translate</button>
            </table>
        </fieldset>
    </form>
</form>
</body>
</html>
