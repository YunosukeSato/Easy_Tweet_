<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="model.User, model.Mutter,
java.util.List" %> 
<% // Get the user information from session scope 
User loginUser = (User) session.getAttribute("loginUser"); 
// Get the tweet list from application scope 
List<Mutter>mutterList = (List<Mutter>) application.getAttribute("mutterList"); 
// Get the error message from request scope
String errorMsg = (String) request.getAttribute("errorMsg");
%>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Easy Tweet</title>
      </head>
      <body>
        <h1>Easy Tweet main page</h1>
        <p>
          <%= loginUser.getName() %><br />
          <a href="/EasyTweetApp/Logout">Log out</a>
        </p>
        <p><a href="/EasyTweetApp/Main">Tweet</a></p>
        <form action="/EasyTweetApp/Main" method="post">
          <input type="text" name="text" />
          <input type="submit" value="Tweet" />
        </form>
        <% if(errorMsg != null)  { %>
        <p><%= errorMsg %></p>
        <% } %>
        <% for(Mutter mutter : mutterList) { %>
        <p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
        <% } %>
      </body>
    </html></Mutter
  ></Mutter
>
