<jsp:include page="header-auth.jsp"/>

<section>

    <%

    if ((String)session.getAttribute("email") != null) {
        response.sendRedirect("show-data.jsp");
    }

    %>
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Sign In</h1>
        </div>
        <form action="auth/signin" method="POST">
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email" required onkeyup="this.value = this.value.toLowerCase();">
                <input type="password" id="password" placeholder="Password" name="password" required>
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Sign In"></input>
            </div>
            <div class="link-class">
                <%

                if (session.getAttribute("exist") != null) {
                %>
                    <p style="color: red;">Invalid Email and Password</p>
                <%

                session.removeAttribute("exist");
                }

                %>
            </div>
            <div class="link-class">
                <p class="text">Doesn't have an account? <a href="sign-up.jsp" class="link">Sign Up</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>