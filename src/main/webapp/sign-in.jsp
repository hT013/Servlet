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
            <h1 style="color: aliceblue;">Sign In</h1>
        </div>
        <form action="auth/signin" method="POST">
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email" required
                       value=<%=session.getAttribute("temp-email")%>>
                <input type="password" id="password" placeholder="Password" name="password" required>
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Sign In"></input>
            </div>
            <div class="link-class">
                <p class="text">Doesn't have an account? <a href="sign-up.jsp" class="link">Sign Up</a></p>
            </div>
            <div class="link-class">
                <%

                    session.setAttribute("temp-email", "");
                    if (session.getAttribute("invalid") != null) {
                %>
                <p style="color: red;">Invalid Email and Password</p>
                <%

                        session.removeAttribute("invalid");
                    }

                %>
            </div>
        </form>
    </div>
</section>
</body>
</html>