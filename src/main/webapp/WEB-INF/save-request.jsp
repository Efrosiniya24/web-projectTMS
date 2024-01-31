<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление заявки</title>
</head>
<body>
<form action="save-request" method="post">
    <label for="name">Введите имя:</label>
    <input type="text" id="name" name="name">
    <br> <br>
    <label for="email">Введите email:</label>
    <input type="text" id="email" name="email">
    <br> <br>
    <label for="phone">Введите телефон:</label>
    <input type="text" id="phone" name="phone">
    <br> <br>
    <button type="submit">Оформить заявку</button>
</form>
</body>
</html>
