/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "nav_menu") {
      x.className += " responsive";
    } else {
      x.className = "nav_menu";
    }
  }