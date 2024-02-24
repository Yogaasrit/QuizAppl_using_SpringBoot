<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Quiz Evaluation</title>
</head>
<body>
	<h1>Quiz Evaluation</h1>
	<table border="1">
		<tr>
			<th>Question ID</th>
			<th>Selected Option</th>
			<th>Correct Option</th>
			<th>Evaluation</th>
		</tr>
		<c:choose>
			<c:when test="${markScored > 1}">
				<h3>Congrat's on your attempt!!</h3>
			</c:when>
			<c:otherwise>
				<h3>OOPS! You failed. Try Again...</h3>
			</c:otherwise>
		</c:choose>

		<h2>Score: ${markScored}</h2>

		<c:forEach var="entry" items="${map}">
			<c:set var="questionId" value="${entry.key}" />
			<c:set var="selectedOption" value="${entry.value}" />
			<c:forEach var="quiz" items="${list}">
				<c:if test="${quiz.id eq questionId}">
					<tr>
						<td>${questionId}</td>
						<td>${selectedOption}</td>
						<td>${quiz.answer}</td>
						<c:choose>
							<c:when test="${selectedOption eq quiz.answer}">
								<td>Correct</td>
							</c:when>
							<c:otherwise>
								<td>Wrong</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:if>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>
