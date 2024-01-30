<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Скачать книгу</title>
</head>
<body>

<h3>Скачать книгу</h3>
<form action="book" method="get">
    <label for="bookName">Введите название книги:</label>
    <input type="text" id="bookName" name="bookName">
    <br>
    <button type="submit">Скачать</button>
</form>
</body>
</html>