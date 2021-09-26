<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Form</title>
</head>
<body>
    <h1>Email Form</h1>
    <form:form method="post" action="/sendEmail" modelAttribute="email">
        <fieldset>
            <legend>Email Form</legend>
            <table>
                <tbody>
                <tr>
                    <td>
                        <form:label path="languages">
                            <h3>Languages</h3>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="languages" name="languages">
                            <form:option value="English">English</form:option>
                            <form:option value="Vietnamese">Vietnamese</form:option>
                            <form:option value="Japanese">Japanese</form:option>
                            <form:option value="Chinese">Chinese</form:option>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="pageSize">
                            <h3>Page Size:</h3>
                        </form:label>
                    </td>
                    <td>
                        <span>Show </span>
                        <form:select path="pageSize" name="pageSize">
                            <form:option value="5">5</form:option>
                            <form:option value="10">10</form:option>
                            <form:option value="15">15</form:option>
                            <form:option value="25">25</form:option>
                            <form:option value="50">50</form:option>
                            <form:option value="100">100</form:option>
                        </form:select>
                        <span>emails her page</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="filter">
                            <h3>Spams Filter:</h3>
                        </form:label>
                    </td>
                    <td>
                        <form:checkbox path="filter" name="filter"/>Enable spams filter
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="signature">
                            <h3>Signature</h3>
                        </form:label>
                    </td>
                    <td>
                        <form:textarea path="signature" name="signature" rows="15" cols="50"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Submit</button>
                        <button type="reset">Cancel</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </form:form>
</body>
</html>
