$(document).ready(function () {

    // Progress Bar
    let containerA = document.getElementById('circleA');

    let circleA = new ProgressBar.Circle(containerA, {
        color: '#1acff8',
        strokeWidth: 8,
        duration: 1400,
        from: { color: '#AAA' },
        to: { color: '#1acff8' },

        step: function (state, circle) {
            circle.path.setAttribute('stroke', state.color);

            let value = Math.round(circle.value() * 60);

            circle.setText(value);


        }
    });

    let containerB = document.getElementById('circleB');

    let circleB = new ProgressBar.Circle(containerB, {
        color: '#1acff8',
        strokeWidth: 8,
        duration: 1600,
        from: { color: '#AAA' },
        to: { color: '#1acff8' },

        step: function (state, circle) {
            circle.path.setAttribute('stroke', state.color);

            let value = Math.round(circle.value() * 254);

            circle.setText(value);


        }
    });

    let containerC = document.getElementById('circleC');

    let circleC = new ProgressBar.Circle(containerC, {
        color: '#1acff8',
        strokeWidth: 8,
        duration: 1000,
        from: { color: '#AAA' },
        to: { color: '#1acff8' },

        step: function (state, circle) {
            circle.path.setAttribute('stroke', state.color);

            let value = Math.round(circle.value() * 32);

            circle.setText(value);


        }
    });

    let containerD = document.getElementById('circleD');

    let circleD = new ProgressBar.Circle(containerD, {
        color: '#1acff8',
        strokeWidth: 8,
        duration: 1800,
        from: { color: '#AAA' },
        to: { color: '#1acff8' },

        step: function (state, circle) {
            circle.path.setAttribute('stroke', state.color);

            let value = Math.round(circle.value() * 7804);

            circle.setText(value);


        }
    });

    // Iniciando o loader quando o usuário chegar na função

    let dataAreaOffSet = $('#data-area').offset();
    let stop = 0;

    $(window).scroll(function (e) {
        let scroll = $(window).scrollTop();

        if (scroll > (dataAreaOffSet.top - 500) && stop == 0) {
            circleA.animate(1.0);
            circleB.animate(1.0);
            circleC.animate(1.0);
            circleD.animate(1.0);

            stop = 1;
        }
    });

    // Parallax
    setTimeout(function () {
        $('#data-area').parallax({ imageSrc: './img/cidadeparallax.png' });
        $('#apply-area').parallax({ imageSrc: './img/pattern.png' });
    }, 250);

    // Filtro do portfolio

    $('.filter-btn').on('click', function () {
        let type = $(this).attr('id');
        let boxes = $('.project-box');

        $('.main-btn').removeClass('active');
        $(this).addClass('active');


        if (type === 'dsg-btn') {
            eachBoxes('dsg', boxes);
        } else if (type === 'dev-btn') {
            eachBoxes('dev', boxes);
        } else if (type === 'seo-btn') {
            eachBoxes('seo', boxes);
        } else {
            eachBoxes('all', boxes);
        }
    });

    function eachBoxes(type, boxes) {
        if (type === 'all') {
            $(boxes).fadeIn();
        } else {
            $(boxes).each(function () {
                if (!$(this).hasClass(type)) {
                    $(this).fadeOut('slow');
                } else {
                    $(this).fadeIn();
                }
            })
        }
    }

    // Scroll para seções

    let navBtn = $('.nav-item');

    let bannerSection = $('#mainSlider');
    let aboutSection = $('#about-area');
    let serviceSection = $('#services-area');
    let teamSection = $('#team-area');
    let portfolioSection = $('#portfolio-area');
    let contactSection = $('#contact-area');

    let scrollTo = '';

    $(navBtn).click(function () {
        let btnId = $(this).attr('id');

        console.log(btnId);

        if (btnId === 'about-menu') {
            scrollTo = aboutSection;
        } else if (btnId === 'service-menu') {
            scrollTo = serviceSection;
        } else if (btnId === 'team-menu') {
            scrollTo = teamSection;
        } else if (btnId === 'portfolio-menu') {
            scrollTo = portfolioSection;
        } else if (btnId === 'contact-menu') {
            scrollTo = contactSection;
        } else {
            scrollTo = bannerSection;
        }


        $([document.documentElement, document.body]).animate({
            scrollTop: $(scrollTo).offset().top - 70
        }, 1500);
    });


});

/*----------------------- Login / Register ------------------ */

function btn_cadastre_click() {
    div_login.style.display = "none";
    div_register.style.display = "flex";
}

function btn_voltar_click() {
    div_login.style.display = "flex";
    div_register.style.display = "none";
}

/*---------------------- POST Login -----------------------*/

function entrar() {
    var formulario = new URLSearchParams(new FormData(form_login));
    fetch("/usuarios/autenticar", {
        method: "POST",
        body: formulario
    }).then(resposta => {

        if (resposta.ok) {

            resposta.json().then(json => {

                sessionStorage.login_usuario_meuapp = json.login;
                sessionStorage.nome_usuario_meuapp = json.nome;

                window.location.href = '/teste.html';
            });

        } else {
            console.log('Erro de login!');
        }
    });

    return false;
}

/*---------------- POST Register ---------------------*/

function cadastrar() {
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/usuarios/cadastrar", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {

            window.location.href = '/teste.html';

        } else {

            console.log('Erro de cadastro!');
            response.text().then(function (resposta) {
                div_erro.innerHTML = resposta;
            });

        }
    });

    return false;
}
