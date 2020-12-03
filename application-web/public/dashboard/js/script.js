
let var_name;
let var_cpf;
let var_login = sessionStorage.user_login;
let var_office;
let var_company;


function setVars() {
    fetch(`/usuarios/user/${var_login}`, { cache: 'no-store' })
    .then(res => {
        if(res.ok) {
            res.json().then((json) => {
                var_company = json.NameCompany;
                var_cpf = json.cpf;
                var_name = json.name;
                var_office = json.office;
                loginUser();
            })
        } else {
            logoff();
        }
    });
}

function loginUser() {
    validateUser();
    validar_sessao();
    userPrint();
}

function validateUser() {
    if (var_login == null || var_login == undefined || var_login == "") {
        window.location.href = '/';
    }
}

function userPrint() {
   
    user_name.innerHTML = var_name;
    user.innerHTML = var_name;
    email.innerHTML = var_login;
    cpf.innerHTML = var_cpf;
    company.innerHTML = var_company;
    office.innerHTML = var_office;
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
    fetch(`/usuarios/sessao/${var_login}`, { cache: 'no-store' })
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