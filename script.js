document.addEventListener("DOMContentLoaded", function () {
    footer = document.getElementById("footer");
});

function sunkFooter() {
    var bodyHeight = document.body.clientHeight;
    var windowHeight = window.innerHeight;
    var footerHeight = footer.offsetHeight;

    if (bodyHeight + footerHeight < windowHeight) {
        footer.style.position = 'fixed';
        footer.style.bottom = '0';
        footer.style.left = '0';
        footer.style.right = '0';
    } else {
        footer.style.position = 'static';
    }
}

window.onload = sunkFooter;
window.onresize = sunkFooter;