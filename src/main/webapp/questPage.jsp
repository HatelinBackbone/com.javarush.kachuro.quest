<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Question, model.Answer" %>

<%
    String playerName = (String) session.getAttribute("playerName");
    Question currentQuestion = (Question) session.getAttribute("currentQuestion");
%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cemetery</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url(images/background_image.jpg); background-repeat: no-repeat; background-size: cover; background-position: center; min-height: 100vh;">

<div class="container text-center mt-4">
    <h1 class="card-title" style="color: dimgray">Квест "Неупокоенные"</h1>
</div>

<br>

<div class="card mx-auto" style="max-width: 700px; background-color: rgba(176, 196, 222, 0.6)">
    <div class="card-body text-center">
        <h3 class="card-title"><%= playerName != null ? playerName : "Игрок" %>,</h3>

        <%
            if (currentQuestion != null) {
        %>
        <p class="card-text fs-5"><%= currentQuestion.toString() %>
        </p>

        <%
                if (currentQuestion.getAnswers() != null && !currentQuestion.getAnswers().isEmpty()) {
        %>
        <form method="post" action="quest">
            <div class="d-grid gap-2">
                <%
                    for (Answer answer : currentQuestion.getAnswers()) {
                %>
                <button type="submit" name="answerId" value="<%= answer.getId() %>"
                        class="btn btn-dark mb-2">
                    <%= answer.toString() %>
                </button>
                <%
                    }
                %>
            </div>
        </form>

        <%
                } else {
        %>
        <p class="text-danger fs-5">Квест завершён!</p>
        <form method="post" action="restart">
            <button type="submit" class="btn btn-dark mt-3">Начать заново</button>
        </form>
        <%
            }
        %>
        <%
            } else {
        %>
        <p class="text-success fs-5">Квест завершён! Спасибо за игру.</p>
        <form method="post" action="restart">
            <button type="submit" class="btn btn-dark mt-3">Начать заново</button>
        </form>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
