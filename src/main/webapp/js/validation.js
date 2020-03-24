function checkForValidEmail(email) {
    let value = email.value;
    let regex = /^[a-z0-9]+@[a-z]+\.[a-z]+$/;
    if (regex.test(value)) {
        email.style.color = "black";
        return true;
    } else {
        email.style.color = "red";
        return false;
    }
}

function checkForValidNumber(mobNum) {
    let value = mobNum.value;
    if (!isNaN(value) && value.length === 10) {
        mobNum.style.color = "black";
        return true;
    } else {
        mobNum.style.color = "red";
        return false;
    }
}