<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Information</title>
</head>
<body>
    <h1>Email Information:</h1>
    <form:form method="get" action="/update" modelAttribute="email">
        <table>
            <tr>
                <th>Languages:</th>
                <td>
                    <p>${email.languages}</p>
                </td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td>
                    <p>${email.pageSize}</p>
                </td>
            </tr>
            <tr>
                <th>Spams Filter:</th>
                <td>
                    <p>${email.filter}</p>
                </td>
            </tr>
            <tr>
                <th>Signature:</th>
                <td>
                    <p>${email.signature}</p>
                </td>
            </tr>
            <form:hidden path="languages" disabled="true"></form:hidden>
            <form:hidden path="pageSize" disabled="true"></form:hidden>
            <form:hidden path="filter" disabled="true"></form:hidden>
            <form:hidden path="signature" disabled="true"></form:hidden>
        </table>
        <h2>Would you like to update?</h2>
        <button type="submit">Update</button>
    </form:form>
    <button>
        <a href="${pageContext.request.contextPath}/email">Back</a>
    </button>
</body>
</html>
