
let var_name;
let var_cpf;
let var_login = sessionStorage.user_login;
let var_office;
let var_company;
let var_id_company;


function setVars() {
    fetch(`/usuarios/user/${var_login}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    var_company = json.NameCompany;
                    var_cpf = json.cpf;
                    var_name = json.name;
                    var_office = json.office;
                    var_id_company = json.idCompany;
                    loginUser();
                })
            } else {
                logoff();
            }
        });
}

function showMachine() {
    fetch(`/data/machine/${var_id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for(let i = 0; i < json.length; i++){

                        machines.innerHTML += `
                        <div class="col-md-4 col-sm-12">
                            <div class="card" id="${json[i].Status}">
                                <div class="card-body">
                
                                    <div class="card-title">
                                        ${json[i].nameMachine}
                                    </div>
                
                                    <i class="fas fa-plus"></i><span
                                        class="sr-only">Redirecionar</span>
                                </div>
                            </div>
                        </div>
                    `;
                    }
                });
            }
        });
}

function showGoodCount(){
    fetch(`/data/status_good/${var_id_company}`, { cache: 'no-store' })
    .then(res => {
        if(res.ok){
            res.json().then((json) => {
                status_good.innerHTML = json[0].statusCount;
            });
        }
    });
}

function showWarningCount(){
    fetch(`/data/status_warning/${var_id_company}`, { cache: 'no-store' })
    .then(res => {
        if(res.ok){
            res.json().then((json) => {
                status_warning.innerHTML = json[0].statusCount;
            });
        }
    });
}

function showDangerCount(){
    fetch(`/data/status_danger/${var_id_company}`, { cache: 'no-store' })
    .then(res => {
        if(res.ok){
            res.json().then((json) => {
                status_danger.innerHTML = json[0].statusCount;
            });
        }
    });
}

function loginUser() {
    validateUser();
    validar_sessao();
    userPrint();
    showMachine();
    showGoodCount();
    showWarningCount();
    showDangerCount();
}

function validateUser() {
    if (var_login == null || var_login == undefined || var_login == "") {
        window.location.href = '/';
    }
}

setInterval(() => {
    machines.innerHTML = '';
    showMachine();
    showGoodCount();
    showWarningCount();
    showDangerCount();
}, 10*1000);

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
    fetch(`/usuarios/sair/${var_login}`, { cache: 'no-store' });
}