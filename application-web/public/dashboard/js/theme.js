function theme() {
    let button = switch_theme.checked == true;
    let root = document.documentElement;
    
    if (!button) {
        root.style.setProperty('--background','#FFF');
        root.style.setProperty('--secundary-bg','#9e9e9e');
        root.style.setProperty('--color-text','#000000');
        imgTheme.src = "./img/dashboard-color-theme-black.png";
    }else{
        root.style.setProperty('--background','#333333');
        root.style.setProperty('--secundary-bg','#515151');
        root.style.setProperty('--color-text','#FFFFFF');
        imgTheme.src = "./img/dashboard-color-theme-white.png";
    }
}