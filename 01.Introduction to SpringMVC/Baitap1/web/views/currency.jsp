<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/convert" method="post">
    <form>
        <fieldset>
            <legend>Convert Currency</legend>
            <table>
                <tbody>
                <tr>
                    <th>Tỉ Giá: </th>
                    <td>
                        <label>
                            <input type="text" name="rate" value="20000"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>USD: </th>
                    <td>
                        <label>
                            <input type="text" name="usd" value="0"/>
                        </label>
                    </td>
                </tr>
                </tbody>
                <button type="submit">Converter</button>
            </table>
        </fieldset>
    </form>
</form>
</body>
</html>
