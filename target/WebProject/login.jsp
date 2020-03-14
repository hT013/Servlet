<jsp:include page="header-cred.jsp"/>

<section>
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
                <p class="text">Doesn't have an account? <a href="signin.jsp" class="link">Sign In</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>