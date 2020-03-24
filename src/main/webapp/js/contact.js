function sendData() {
    let emailState = checkForValidEmail(document.getElementById('email'));
    let phoneState = checkForValidNumber(document.getElementById('phone'));
    event.preventDefault();
    if (emailState === true && phoneState === true) {
        let obj = {};
        obj.fname = document.getElementById("fname").value;
        obj.lname = document.getElementById("lname").value;
        obj.phoneNumber = document.getElementById("phone").value;
        obj.email = document.getElementById("email").value;
        obj.message = document.getElementById("message").value;

        fetch('FormSubmit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(obj)
        })
            .then((response) => {
                return response.json()
            })
            .then((response) => {
                if (response.status === "Success") {
                    alert(response.message);
                    location.reload(true);
                } else {
                    alert(response.message);
                }
            });
    } else {
        alert("Invalid values");
    }

}