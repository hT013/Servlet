<jsp:include page="header-cred.jsp"/>

<section>
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Sign In</h1>
        </div>
        <form action="SignIn" method="POST">
            <div class="name">
                <input type="text" id="uname" placeholder="User Name" name="uname">
            </div>
            <div class="id">
                <input type="text" id="email" placeholder="E mail" name="email">
                <input type="password" id="password" placeholder="Password" name="password">
            </div>
            <div class="submit">
                <input type="submit" id="sub-button" value="Sign In"></input>
            </div>
            <div class="link-class">
                <p class="text">Already have an account? <a href="login.jsp" class="link">Log In</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>