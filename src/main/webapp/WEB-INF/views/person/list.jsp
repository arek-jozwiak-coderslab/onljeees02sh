<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>login</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <c:forEach items="${people}" var="person">
        <tr>
            <td>${person.login}</td>
            <td>${person.password}</td>
            <td>${person.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
