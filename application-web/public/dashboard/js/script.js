window.document.onload = loginUser();

function loginUser() {
    console.log(sessionStorage.user_name)
    let user = {
        "name": sessionStorage.user_name,
        "login": sessionStorage.user_login
    }
    validateUser(user.name, user.login);
}

function validateUser(user) {
    for (x in user) {
        if (user[x] == null || user[x] == undefined || user[x] == "") {
            window.location.href = "http://127.0.0.1:3000";
        }
    }
    console.log(user);
    printUser(user);
}

function printUser(user) {
    nome_usuario.innerHTML = user.name;
    name.innerHTML = user.name;
    email.innerHTML = user.login;
let user = {
    'name': sessionStorage.user_name,
    'login': sessionStorage.user_login
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
    fetch(`/usuarios/sessao/${user.login}`, { cache: 'no-store' })
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
    fetch(`/usuarios/sair/${user.login}`, { cache: 'no-store' });
}}