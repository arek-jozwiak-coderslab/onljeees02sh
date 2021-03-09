<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>


<select name="">
    <option value="1">jeden</option>
</select>
<input type="hidden" value="123">

<form:form method="post" modelAttribute="student">
    <form:checkboxes items="${languages}" path="languages" />
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <input type="submit">
</form:form>

<%--<form method="post">--%>
<%--    First name: <input type="text" value="${student.firstName}" name="firstName"><br>--%>
<%--    Last name: <input type="text" name="lastName"><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>
</body>
</html>
