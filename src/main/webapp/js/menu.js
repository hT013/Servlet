document.getElementById('image-menu').addEventListener('click',menuDropDown);
var section = document.getElementById('section');
var footer = document.getElementById('footer');
var menu = document.getElementById('image-menu');
var menuList = document.querySelector('.menu-list1');
var hamburgerMenu = document.getElementById('hamburger-menu');
var headerClass = document.querySelector('.header-class');


function menuDropDown(){
    if(section.style.display !== "none"){
        menu.src = "images/icon-close.svg";
        section.style.display = "none";
        footer.style.display = "none";
        hamburgerMenu.style.cssText="display: flex;flex-direction: column;"+
        "justify-content: space-between;align-items: center;"+
        "background-color: #2c2640;height: 90vh;";
        menuList.style.cssText = "display: flex;flex-direction: column;"+
        "align-items: center;margin-top: 10%;";
        headerClass.style.cssText="height: 100vh;overflow: hidden;";
    } else{
        menu.src = "images/icon-hamburger.svg";
        section.style.display = "block";
        footer.style.display = "block";
        menuList.style.display = "none";
        hamburgerMenu.style.display="none";
        headerClass.style.cssText="height: auto;overflow: auto;";
    }
}