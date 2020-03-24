<jsp:include page="header-auth.jsp"/>

<section>

    <%

        if (session.getAttribute("email") != null) {
            request.getRequestDispatcher("show-data.jsp").forward(request, response);
        }

        if (session.getAttribute("temp-email") == null) {
            session.setAttribute("temp-uname", "");
            session.setAttribute("temp-email", "");
        }

    %>
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Sign Up</h1>
        </div>
        <form action="auth/signup" method="POST">
            <div class="name">
                <input type="text" id="uname" placeholder="User Name" name="u-name" required value=
                    <%=session.getAttribute("temp-uname")%>>
            </div>
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email" required value=
                    <%=session.getAttribute("temp-email")%>>
                <input type="password" id="password" placeholder="Password" name="password" required>
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Sign Up"></input>
            </div>
            <div class="link-class">
                <p class="text">Already have an account? <a href="sign-in.jsp" class="link">Sign In</a></p>
            </div>
            <div class="link-class">
                <%
                    session.setAttribute("temp-email", "");
                    session.setAttribute("temp-uname", "");

                    if (session.getAttribute("invalid") != null) {
                %>
                <p style="color: red;">Invalid data! Please enter again</p>
                <%

                    session.removeAttribute("invalid");
                } else if (session.getAttribute("exist") != null) {
                %>
                <p style="color: red;">E-mail already exists</p>
                <%

                        session.removeAttribute("exist");
                    }

                %>

            </div>
        </form>
    </div>
</section>
<script src="js/validation.js"></script>
<script src="js/sign-up.js"></script>
</body>
</html>