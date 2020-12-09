

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
                        <div class="col-md-4 col-sm-12">
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

function getDatas() {

    fetch(`/data/datas_cpu/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {

                res.json().then((json) => {


                    name_processor.innerHTML = `${json[0].Componente}`;

                    name_machine.innerHTML = `${json[0].Name_Machine}`;

                    $(".progress").each(function () {
                        var $bar = $(this).find(".bar");
                        var $val = $(this).find("span");
                        var perc = parseInt(json[0].Metrica, 10);
                        $({ p: json[0].Metrica }).animate({ p: perc }, {
                            duration: 3000,
                            easing: "swing",
                            step: function (p) {
                                $bar.css({
                                    transform: "rotate(" + (45 + (p * 1.8)) + "deg)", // 100%=180° so: ° = % * 1.8
                                    // 45 is to add the needed rotation to have the green borders at the bottom
                                });
                                $val.text(p | json[0].Metrica);
                            }
                        });
                    });
                    value_Cpu.innerHTML = `${json[0].Metrica}`;

                    cpu.data.labels = [];
                    cpu.data.datasets[0].data = [];
                    cpu.options.title.text = `${json[0].Name_Machine}`;

                    for (i = 0; i < json.length; i++) {
                        cpu.data.labels.push(json[i].Moment);
                        // cpu.data.labels.shift();
                        cpu.data.datasets[0].data.push(json[i].Metrica);

                        increment++;
                    }

                    plotCpu();

                });
            }
        });
}

function getMemory() {
    fetch(`/data/datas_mem/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {

                res.json().then((json) => {
                    console.log(json[0]);

                    name_memory.innerHTML = `${json[0].Componente}`;

                    $("#progress_memory").each(function () {
                        var $bar = $(this).find(".bar");
                        var $val = $(this).find("span");
                        var perc = parseInt(json[0].Metrica, 10);
                        $({ p: json[0].Metrica }).animate({ p: perc }, {
                            duration: 3000,
                            easing: "swing",
                            step: function (p) {
                                $bar.css({
                                    transform: "rotate(" + (45 + (p * 1.8)) + "deg)", // 100%=180° so: ° = % * 1.8
                                    // 45 is to add the needed rotation to have the green borders at the bottom
                                });
                                $val.text(p | json[0].Metrica);
                            }
                        });
                    });

                });
            }
        });
}

function getDisk() {
    fetch(`/data/datas_disk/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {

                res.json().then((json) => {
                    console.log(json[0]);

                    name_disk.innerHTML = `${json[0].Componente}`;

                    $("#progress_disk").each(function () {
                        var $bar = $(this).find(".bar");
                        var $val = $(this).find("span");
                        var perc = parseInt(json[0].Metrica, 10);
                        $({ p: json[0].Metrica }).animate({ p: perc }, {
                            duration: 3000,
                            easing: "swing",
                            step: function (p) {
                                $bar.css({
                                    transform: "rotate(" + (45 + (p * 1.8)) + "deg)", // 100%=180° so: ° = % * 1.8
                                    // 45 is to add the needed rotation to have the green borders at the bottom
                                });
                                $val.text(p | json[0].Metrica);
                            }
                        });
                    });

                });
            }
        });
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
    if (sessionStorage.user_login == null || sessionStorage.user_login == undefined || sessionStorage.user_login == "") {
        window.location.href = '/';
    }
}

// setInterval(() => {
//     machines.innerHTML = '';
//     showMachine();
//     showGoodCount();
//     showWarningCount();
//     showDangerCount();
// }, 10*1000);

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

/* grafico de cpu */

var cpu = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'Processador',
            backgroundColor: "#3B5998",
            borderColor: "#3B5998",
            data: [

            ],
            fill: false,
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: ''
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Horário'
                }
            }],
            yAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Valor'
                }
            }]
        }
    }
}


function updateCpu() {
    fetch(`/data/datas_cpu/${sessionStorage.id_company}/${sessionStorage.machineId}`).then(res => {
        if (res.ok) {
            res.json().then((json) => {
               // debugger;
                // cpu.data.labels = [];
                // cpu.data.datasets[0].data = [];
                cpu.options.title.text = `${json[0].Name_Machine}`;

                $(".progress").each(function () {
                    var $bar = $(this).find(".bar");
                    var $val = $(this).find("span");
                    var perc = parseInt(json[0].Metrica, 10);
                    $({ p: json[0].Metrica }).animate({ p: perc }, {
                        duration: 3000,
                        easing: "swing",
                        step: function (p) {
                            $bar.css({
                                transform: "rotate(" + (45 + (p * 1.8)) + "deg)", // 100%=180° so: ° = % * 1.8
                                // 45 is to add the needed rotation to have the green borders at the bottom
                            });
                            $val.text(p | json[0].Metrica);
                        }
                    });
                });
                value_Cpu.innerHTML = `${json[0].Metrica}`;

                if (increment < 8) {
                    cpu.data.labels.push(json[0].Moment);
                    cpu.data.datasets[0].data.push(json[0].Metrica);

                    increment++;
                } else {
                    cpu.data.labels.shift();
                    cpu.data.datasets[0].data.shift();

                    cpu.data.labels.push(json[0].Moment);
                    cpu.data.datasets[0].data.push(json[0].Metrica);
                }

                window.historico_cpu.update();



            });
        } else {
            console.log('Maquina não encontrado');
        }
    });


}

function plotCpu() {
    var ctx = document.getElementById('cpu_history').getContext('2d');
    window.historico_cpu = new Chart(ctx, cpu);
}

window.onload = plotCpu();

setInterval(() => {
    updateCpu();
}, 1500);

