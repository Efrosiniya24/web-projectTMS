<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявка</title>
</head>
<body>
<h1>Заявка успешно сохранена</h1>
<p>Имя: <%= request.getParameter("name")%></p>
<p>email: <%= request.getParameter("email")%></p>
<p>Телефон: <%= request.getParameter("phone")%></p>
</body>
</html>
