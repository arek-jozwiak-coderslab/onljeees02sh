<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 09.03.2021
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:select path="publisher.id" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <input type="submit">
</form:form>
</body>
</html>
