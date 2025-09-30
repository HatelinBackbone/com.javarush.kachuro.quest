<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Cemetery</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url(images/background_image.jpg); background-repeat: no-repeat; background-size: cover; background-position: center; min-height: 100vh;">
<div class="container" style="text-align: center; align-items: center; justify-content: center;">
    <h1 class="card-title" style="color: dimgray">Квест "Неупокоенные"</h1>
</div>

<br>

<div class="card" style="background-color: rgba(176, 196, 222, 0.6)">
    <div class="card-body" style="text-align: center;">
        <h3 class="card-title">Пролог</h3>
        <p class="card-text">Туманным летним вечером вы возвращались домой, как всегда срезая путь через тёмные проулки. В этот день вас не покидало чувство тревоги,
        как будто что-то должно было случится. На работе уже неделю вам не даёт покоя один безумный старик - он каждый день приходит в редакцию и кричит, чтобы вы дали
            огласку загадочным пропажам людей в вашем городке. Якобы он видел как мёртвые со старого кладбища в лесу на окраине восстали и шныряют по городу в поисках
            свежей крови. Конечно же это всё полный бред, городские сумасшедшие есть в каждом городе и вы просто стараетесь не обращать внимания. Рабочий день окончен,
            статья завершена в срок, но почему же так неспокойно на душе... Очнулись вы уже лёжа на надгробии, на том самом кладбище, о котором всё это время неумолкал безумный
            старик. Что произошло? Почему вы здесь? Ясно одно - надо поскорее отсюда убираться. Первое, что вы всмнили, придя в себя - это
        </p>
        <h4 class="card-title">Ваше имя:</h4>
        <form method="post" action="start">
            <input type="text" class="form-control-sm" name="username" maxlength="15"><br> <br>
            <button class="btn btn-dark" type="submit">Подтвердить</button>
        </form>
    </div>
</div>

</body>
</html>
