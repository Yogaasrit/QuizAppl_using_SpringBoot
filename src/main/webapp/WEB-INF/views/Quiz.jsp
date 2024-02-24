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
<form id="quizForm" action="/submit-quiz" method="post">
<c:forEach var="question" items="${list}">
    <h3>${question.level}</h3>
    <h3>${question.question}</h3>
    <input type="radio" name="${question.id}" value="1">${question.option1}<br>
    <input type="radio" name="${question.id}" value="2">${question.option2}<br>
    <input type="radio" name="${question.id}" value="3">${question.option3}<br>
    <input type="radio" name="${question.id}" value="4">${question.option4}<br>
</c:forEach>
<button type="submit">Submit</button>
</form>
</body>
</html>
