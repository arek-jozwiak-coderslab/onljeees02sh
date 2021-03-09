<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Dodaj osobę</h1>
<form:form method="post" modelAttribute="person">
    <jsp:include page="form.jsp"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
