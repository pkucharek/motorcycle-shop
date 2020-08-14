const chargeUser = () => {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = () => {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("user-balance").innerHTML = xhttp.responseText + " zł";
        }
    }
    xhttp.open("GET", "/user/charge", true);
    xhttp.send();
}

window.onload = () => {
    let chargeButton = document.getElementById("charge");
    chargeButton.addEventListener("click", chargeUser);
}
