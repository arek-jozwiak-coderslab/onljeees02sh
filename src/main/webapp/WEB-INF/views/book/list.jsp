<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>title</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
