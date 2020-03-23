<jsp:include page="header-auth.jsp"/>

<section>
    <%

    if ((String)session.getAttribute("email") != null) {
        response.sendRedirect("show-data.jsp");
    }

    %>
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Sign Up</h1>
        </div>
        <form action="auth/signup" method="POST">
            <div class="name">
                <input type="text" id="uname" placeholder="User Name" name="uname" required>
            </div>
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email" required onkeyup="this.value = this.value.toLowerCase();">
                <input type="password" id="password" placeholder="Password" name="password" required>
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Sign Up"></input>
            </div>
            <div class="link-class">
                <%

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
            <div class="link-class">
                <p class="text">Already have an account? <a href="sign-in.jsp" class="link">Sign In</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>