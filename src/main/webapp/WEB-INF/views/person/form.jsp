<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    login: <input type="text"  name="login"><br>
    password: <input type="text" name="password"><br>
    email: <input type="text" name="email"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
