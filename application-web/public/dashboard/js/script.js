

function setVars() {
    fetch(`/usuarios/user/${sessionStorage.user_login}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    sessionStorage.company = json.NameCompany;
                    sessionStorage.cpf = json.cpf;
                    sessionStorage.name = json.name;
                    sessionStorage.office = json.office;
                    sessionStorage.id_company = json.idCompany;
                    loginUser();
                })
            } else {
                logoff();
            }
        });
}

function searchMachine(nameMachine) {
    machines.innerHTML = "";
    fetch(`/data/search/${nameMachine}/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {
                        machines.innerHTML += `
                        <div class="col-md-4 col-sm-12"  onclick ="redirect(${json[i].IdMachine})">
                            <div class="card" id="${json[i].Status}">
                                <div class="card-body">
                
                                    <div class="card-title">
                                        ${json[i].nameMachine}
                                    </div>

                                    <input type="hidden" id="idMachine" value = "${json[i].IdMachine}">

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

function showMachine() {
    fetch(`/data/machine/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {

                        machines.innerHTML += `
                            <div class="col-md-4 col-sm-12" onclick ="redirect(${json[i].IdMachine})">
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

function redirect(machine) {
    sessionStorage.machineId = machine;
    window.location = 'machines_individual_datas.html';
}

function showGoodCount() {
    fetch(`/data/status_good/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    status_good.innerHTML = json[0].statusCount;
                });
            }
        });
}

function showWarningCount() {
    fetch(`/data/status_warning/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    status_warning.innerHTML = json[0].statusCount;
                });
            }
        });
}

function showDangerCount() {
    fetch(`/data/status_danger/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    status_danger.innerHTML = json[0].statusCount;
                });
            }
        });
}

function showDangerDisk() {
    fetch(`/data/disk_danger/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    full_disk.innerHTML = json[0].diskDanger;
                });
            }
        });
}

function showOnlyDanger() {
    machines.innerHTML = '';
    fetch(`/data/only_danger/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {

                        machines.innerHTML += `
                            <div class="col-md-4 col-sm-12" onclick ="redirect(${json[i].IdMachine})">
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

function showOnlyWarning() {
    machines.innerHTML = '';
    fetch(`/data/only_warning/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {

                        machines.innerHTML += `
                            <div class="col-md-4 col-sm-12" onclick ="redirect(${json[i].IdMachine})">
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

function showOnlyGood() {
    machines.innerHTML = '';
    fetch(`/data/only_good/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {

                        machines.innerHTML += `
                            <div class="col-md-4 col-sm-12" onclick ="redirect(${json[i].IdMachine})">
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

function showOnlyDangerDisk() {
    machines.innerHTML = '';
    fetch(`/data/only_danger_disk/${sessionStorage.id_company}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    for (let i = 0; i < json.length; i++) {

                        machines.innerHTML += `
                            <div class="col-md-4 col-sm-12" onclick ="redirect(${json[i].IdMachine})">
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

function loginUser() {
    validateUser();
    validar_sessao();
    userPrint();
    showMachine();
    showGoodCount();
    showWarningCount();
    showDangerCount();
    showDangerDisk();
}

function validateUser() {
    if (sessionStorage.user_login == null || sessionStorage.user_login == undefined || sessionStorage.user_login == "") {
        window.location.href = '/';
    }
}


function userPrint() {

    user_name.innerHTML = sessionStorage.name;
    user.innerHTML = sessionStorage.name;
    email.innerHTML = sessionStorage.user_login;
    cpf.innerHTML = sessionStorage.cpf;
    company.innerHTML = sessionStorage.company;
    office.innerHTML = sessionStorage.office;
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
    fetch(`/usuarios/sessao/${sessionStorage.user_login}`, { cache: 'no-store' })
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
    fetch(`/usuarios/sair/${sessionStorage.user_login}`, { cache: 'no-store' });
}