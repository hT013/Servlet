<jsp:include page="header.jsp"/>

<section id="section">
    <div class="container">
        <div class="heading-contact">
            <h1 style="color: aliceblue;">Contact Form</h1>
        </div>
        <form action="FormSubmit" method="POST">
            <div class="name">
                <input type="text" id="fname" placeholder="Name" name="fname">
                <input type="text" id="lname" placeholder="Last Name" name="lname">
            </div>
            <div class="id">
                <input type="text" id="phone" placeholder="Mobile Number" name="phone">
                <input type="text" id="email" placeholder="E mail" name="email">
                <textarea type="text" id="message" placeholder="Message" rows="4" name="message"></textarea>
            </div>
            <div>
                <%

                if (request.getAttribute("invalid") != null) {
                %>
                    <p style="color: red;">Invalid Data</p>
                <%

                request.removeAttribute("invalid");
                }

                %>
            </div>
            <div class="submit">
                <input type="submit" id="sub-button"></input>
            </div>
        </form>
    </div>
</section>

<jsp:include page="footer.jsp"/>