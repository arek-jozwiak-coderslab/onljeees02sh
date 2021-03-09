<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Edytujesz ${person.login}</h1>
<form:form action="/person/update" method="post"
           modelAttribute="person">
    <jsp:include page="form.jsp"/>
    <input type="submit" value="Edit">
</form:form>
</body>
</html>
