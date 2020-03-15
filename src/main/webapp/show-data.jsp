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
                <p><%=session.getAttribute("user")%></p>
                <input type="submit" value="LOG OUT" class="logout"/>
            </form>
        </div>
    </header>
    <section>
        <%@page import="com.Insure.ContactForm"%>
        <%@page import="java.util.*"%>
        

        <table>
            <tr>
                <th>Fname</th>
                <th>Lname</th>
                <th>Phone No.</th>
                <th>Email</th>
                <th>Message</th>
            </tr>
                <% 
                response.setHeader("Pragma","no-cache");
                response.setHeader("Cache-Control","no-store");
                response.setHeader("Expires","0");
                response.setDateHeader("Expires",-1);
                

                if ((String)session.getAttribute("email") == null) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    List<ContactForm> list = (List<ContactForm>)session.getAttribute("contactform");
                        for(ContactForm contactform: list) {
                    %>
                    <tr>
                        <td><%=contactform.getFname()%></td>
                        <td><%=contactform.getLname()%></td>
                        <td><%=contactform.getPhoneNumber()%></td>
                        <td><%=contactform.getEmail()%></td>
                        <td><%=contactform.getMessage()%></td>
                    </tr>
                    <%
                        }
                    }
                    %>
        </table>
    </section>
</body>
</html>