function goBack() {
    window.history.back();
}

function unHide() {
    var descriptions = document.getElementsByClassName("description"), i;
    for (var i = 0; i < descriptions.length; i++) {
        if (descriptions[i].style.visibility === "hidden") {
            descriptions[i].style.visibility = "visible";
        } else {
            descriptions[i].style.visibility = "hidden";
        }

    }
}


