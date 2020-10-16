let user = {
    'name': sessionStorage.user_name,
    'login': sessionStorage.user_login
};

validarUser();

function validarUser() {
    for (x in user) {
        if (user[x] == null || user[x] == undefined || user[x] == "") {
            redirecionar_login()
        }
    }
    printUser();
}

function printUser() {
    nome_usuario.innerHTML = user.name;
    user_name.innerHTML = user.name;
    email.innerHTML = user.login;
    validar_sessao();
}

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
}