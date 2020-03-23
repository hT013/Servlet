let mobNum = document.getElementById('phone');
let email = document.getElementById('email');
mobNum.addEventListener('input', checkForValidNumber);
email.addEventListener('input', checkForValidEmail);
let phoneState = true;
let emailState = true;

function checkForValidNumber(){
    let value = mobNum.value;
    if(!isNaN(value) && value.length === 10 && value.length !== 0) {
        mobNum.style.color="black";
        phoneState=true;
    } else {
        mobNum.style.color="red";
        phoneState=false;
    }
}

function checkForValidEmail(){
    let value = email.value;
    let regex = /^[a-z0-9\._]+@[a-z]+\.[a-z]+$/;
    if(regex.test(value)){
        email.style.color="black";
        emailState=true;
    } else {
        email.style.color="red";
        emailState=false;
    }
}

function sendData() {
    checkForValidEmail();
    checkForValidNumber();
    event.preventDefault();
    if(phoneState === true && emailState === true) {
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
          .then((response) => {return response.json()})
      .then((response) => {
        if(response.status === "Success") {
            alert(response.message);
            location.reload(true);
        } else{
            alert(response.message);
        }
      });
    } else{
      alert("Invalid values");
    }
    
}