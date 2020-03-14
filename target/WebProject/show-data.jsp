<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insure</title>
    <link rel="icon" href="images/favicon-32x32.png" type="image/png" sizes="32*32">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/show-data.css">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Karla&display=swap');
        @import url('https://fonts.googleapis.com/css?family=DM+Serif+Display&display=swap');
    </style>
</head>
<body>
    <header class="header-class">
        <div class="mobile-header">
            <nav class="insure-icon">
                <a href="show-data.jsp" class="insure-icon"><img src="images/logo.svg"></a>
            </nav>
        </div>
        <div class="menu-list">
            <form action="LogOut" method="POST" class="form">
                <p>User Name </p>
                <input type="submit" value="LOG OUT" class="logout"/>
            </form>
        </div>
    </header>
    <section>
        <%@page import="java.util.*"%>
        <% 
        
       for(int i=0;i<5;i++) {
            out.println((String)request.getAttribute("hello"+" wefwjf"));
        }

        %>
    </section>
</body>
</html>