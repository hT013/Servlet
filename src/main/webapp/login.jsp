<jsp:include page="header-cred.jsp"/>

<section>
    <%

    if ((String)session.getAttribute("email") != null) {
        response.sendRedirect("show-data.jsp");
    }

    %>
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Log In</h1>
        </div>
        <form action="LogIn" method="POST">
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email">
                <input type="password" id="password" placeholder="Password" name="password">
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Log In"></input>
            </div>
            <div class="link-class">
                <%

                if (request.getAttribute("exist") != null) {
                %>
                    <p style="color: red;">Invalid Email and Password</p>
                <%

                request.removeAttribute("exist");
                }

                %>
            </div>
            <div class="link-class">
                <p class="text">Doesn't have an account? <a href="signup.jsp" class="link">Sign Up</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>