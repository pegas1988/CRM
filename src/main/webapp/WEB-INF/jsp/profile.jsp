<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.hillel.crm.config.entity.User"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
<h2>Your data are under this text:</h2>
<p>Id : ${user.userID}</p>
<p>Name : ${user.firstName}</p>
<p>LastName : ${user.lastName}</p>
<p>Password : ${user.password}</p>
<p>UserRole : ${user.userRole}</p>
</body>
</html>