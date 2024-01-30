<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Загрузить книгу</title>
</head>
<body>
<h1>Загрузить книгу</h1>
<form action="load-book" method="POST" enctype="multipart/form-data">
    <input type="file" name="file" required><br><br>
    <input type="submit" value="Upload">
</form>
</body>
</html>