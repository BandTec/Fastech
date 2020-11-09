let user_name;
let user_login;
function loginUser() {
    user_name = sessionStorage.user_name;
    user_login = sessionStorage.user_login;
    validateUser();
}

function validateUser() {
    if (user_login == null || user_login == undefined || user_login == "") {
        window.location.href = '/';
    }
    validar_sessao();
    printUser();
}

function printUser() {
    nome_usuario.innerHTML = user_name;
    nome.innerHTML = user_name;
    email.innerHTML = user_login;
};

function redirecionar_login() {
    window.location.href = '/';
}

function logoff() {
    finalizar_sessao();
    sessionStorage.clear();
    redirecionar_login();
}

function validar_sessao() {
    fetch(`/usuarios/sessao/${user_login}`, { cache: 'no-store' })
        .then(resposta => {
            if (resposta.ok) {
                resposta.text().then(texto => {
                    console.log('Sessão :) ', texto);
                });
            } else {
                console.error('Sessão :.( ');
                logoff();
            }
        });
}

function finalizar_sessao() {
    fetch(`/usuarios/sair/${user_login}`, { cache: 'no-store' });
}