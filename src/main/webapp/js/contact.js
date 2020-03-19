var mobNum = document.getElementById('phone');
var email = document.getElementById('email');
mobNum.addEventListener('input', checkForValidNumber);
email.addEventListener('input', checkForValidEmail);
var phoneState = true;
var emailState = true;

function checkForValidNumber(){
    var value = mobNum.value;
    if(!isNaN(value) && value.length ==10 && value.length != 0) {
        mobNum.style.color="black";
        phoneState=true;
    } else {
        mobNum.style.color="red";
        phoneState=false;
    }
}

function checkForValidEmail(){
    var value = email.value;
    var regex = /^[a-z0-9\._]+@[a-z]+\.[a-z]+$/;
    if(regex.test(value)){
        email.style.color="black";
        emailState=true;
    } else {
        email.style.color="red";
        emailState=false;
    }
}

function submitForm(){
    var fname = document.getElementById('fname');
    var lname = document.getElementById('lname');
    var flag = true;
    if(fname.value.length == 0) {
        flag = false;
        fname.style.color = "red";
    }
    if(lname.value.length == 0) {
        flag = false;
        lname.style.color = "red";
    }
    checkForValidEmail();
    checkForValidNumber();
    if(phoneState == false || emailState == false || flag ==false){
        return false;
    } else {
      return true;
    }
    
}

function sendData() {
    event.preventDefault();
    if(submitForm() == true) {
      var obj = {};
      obj.fname = document.getElementById("fname").value;
      obj.lname = document.getElementById("lname").value;
      obj.phoneNumber = document.getElementById("phone").value;
      obj.email = document.getElementById("email").value;
      obj.message = document.getElementById("message").value;
    
      fetch('FormSubmit', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(obj)
      })
      .then((response) => response.json());
      alert("Success");
      location.reload(true); 
    } else{
      alert("Enter all values");
    }
    
}