<jsp:include page="header.jsp"/>

<section id="section">
    <%

    if ((String)session.getAttribute("email") != null) {
        response.sendRedirect("show-data.jsp");
    }

    %>
    <div class="mobile-section">
        <img src="images/image-intro-mobile.jpg" class="main-image-mobile">
        <div class="middle">
            <img src="images/bg-pattern-intro-left-mobile.svg" class="bg-mobile-left">
            <p class="large-text">Humanizing your insurance.</p>
            <div class="image-container">
                <img src="images/bg-pattern-intro-right-mobile.svg" class="bg-right-mobile">
            </div>
            <p class="small-text-mobile">Get your life insurance coverage easier and faster. We blend our expertise
            and technology to help you find the plan that’s right for you. Ensure you
            and your loved ones are protected.</p>
            <button class="middle-button" type="button">VIEW PLANS</button>
        </div>
    </div>
    <div class="desktop-section">
        <div class="middle-bg-image">
            <img src="./images/bg-pattern-intro-right-desktop.svg" class="bg-top-image">
        </div>
        <div class="middle-section">
            <div class="middle-text">
                <p class="large-text-desktop">Humanizing</br>your insurance.</p>
                <p class="small-text">Get your life insurance coverage easier and faster. We blend our expertise</br>
                and technology to help you find the plan that's right for you. Ensure you</br>
                and your loved ones are protected.</p>
                <img src="./images/bg-pattern-intro-left-desktop.svg" class="bg-image">
                <button class="middle-button-desktop" type="button">VIEW PLANS</button>
            </div>
            <div class="main-image-class">
                <img src="./images/image-intro-desktop.jpg" class="main-image">
            </div>
        </div>
    </div>
    <div class="middle-details">
        <hr class="hr">
        <p class="heading">We're different </p>
        <div class="second-block">
            <div class="snappy-process">
                <img src="images/icon-snappy-process.svg" class="icon-detail">
                <h2 class="sec-heading">Snappy Process</h2>
                <h2 class="data">Our application process can be completed in minutes, not hours. Don't get
                stuck filling in tedious forms.</h2>
            </div>
            <div class="afford-price">
                <img src="images/icon-affordable-prices.svg" class="icon-detail">
                <h2 class="sec-heading">Affordable Price</h2>
                <h2 class="data">We don't want you worrying about high monthly costs. Our prices may be low,
                but we still offer the best coverage possible.</h2>
            </div>
            <div class="people-first">
                <img src="images/icon-people-first.svg" class="icon-detail">
                <h2 class="sec-heading">People First</h2>
                <h2 class="data">Our plans aren't full of conditions and clauses to prevent payouts. We make
                sure you're covered when you need it.</h2>
            </div>
        </div>
    </div>
    <div class="float">
        <img src="images/bg-pattern-how-we-work-mobile.svg" class="image-mobile">
        <div class="text">
            <p class="text-mobile">Find out more </br>about how we work</p>
            <button class="middle-button-float" type="button">HOW WE WORK</button>
            <img src="images/bg-pattern-how-we-work-desktop.svg" class="image">
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>