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
    title:
    <form:input path="title"/><br/>
    <form:errors path="title"/><br/>
    rating:
    <form:input path="rating"/><br/>
    <form:errors path="rating"/><br/>
    description:
    <form:textarea path="description"/><br/>
    <form:errors path="description"/><br/>
    pages:
    <form:input path="pages"/><br/>
    <form:errors path="pages"/><br/>
    publisher:
    <form:select path="publisher.id" items="${publishers}"
                 itemValue="id" itemLabel="name"/>
    <br/>
    <form:errors path="publisher"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
