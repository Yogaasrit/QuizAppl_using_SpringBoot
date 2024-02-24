<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>
<h1>Quiz details</h1>
<h3>Choose your category</h3>
<c:forEach var = "category" items = "${list}">
<a href = "category/${category}"><button>${category}</button></a>
</c:forEach>
</body>
</html>