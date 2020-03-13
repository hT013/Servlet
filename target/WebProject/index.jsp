<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Contact Form
    </title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/contact.css">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Karla&display=swap');
    </style>
<body>
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
            <div class="submit">
                <input type="submit" id="sub-button"></input>
            </div>
        </form>
    </div>
</section>

</body>
</html>


