<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Easy Tweet</title>
</head>
<body>
    <h1>Welcome to Easy Tweet</h1>
    <form action="/EasyTweetApp/Login" method="post">
        UserName: <input type="text" name="name"><br>
        Password: <input type="password" name="pass"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>