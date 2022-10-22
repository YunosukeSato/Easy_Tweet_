<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Easy Tweet</title>
</head>
<body>
    <h1>Easy Tweet login</h1>
    <% if(loginUser != null) { %>
    <p>Login succeeded</p>
    <p>Welcome <%= loginUser.getName() %></p>
    <a href="/EasyTweetApp/Main">Got to timeline</a>
    <% } else { %>
    <p>Cannot login</p>
    <a href="/EasyTweetApp/">Top page</a>
    <% } %>
</body>
</html>