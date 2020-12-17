let increment = 0;

function getCpu() {

    fetch(`/data/datas_cpu/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {

                res.json().then((json) => {


                    name_processor.innerHTML = `${json[0].Componente}`;

                    name_machine.innerHTML = `${json[0].Name_Machine}`;

                    $("#progress_cpu").each(function () {
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

                    for (let i = 0; i < 8; i++) {
                        var date = new Date(json[i].Moment);
                        var hr = date.getHours()
                        var m = date.getMinutes()
                        var ss = date.getSeconds()
                        var d = `${ hr }: ${ m }: ${ ss }`;

                        cpu.data.labels.push(d);
                        cpu.data.datasets[0].data.push(json[i].Metrica);

                        increment++;
                    }

                    plotCpu();

                });
            }
        });
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
            data: [],
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
                },
                ticks: {
                    beginAtZero: true,
                    steps: 10,
                    stepValue: 10,
                    max: 100
                }
            }]
        }
    }
}


function updateCpu() {
    fetch(`/data/datas_cpu/${sessionStorage.id_company}/${sessionStorage.machineId}`).then(res => {
        if (res.ok) {
            res.json().then((json) => {

                cpu.options.title.text = `${json[0].Name_Machine}`;

                $("#progress_cpu").each(function () {
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
                var dateD = new Date(json[0].Moment);
                var    hrD = dateD.getHours()
                var    mD = dateD.getMinutes()
                var    ssD = dateD.getSeconds()
                var    dD = `${hrD}: ${mD}: ${ssD}`;
                
                if (increment < 8) {
                    cpu.data.labels.push(dD);
                    cpu.data.datasets[0].data.push(json[0].Metrica);

                    increment++;
                } else {
                    cpu.data.labels.shift();
                    cpu.data.datasets[0].data.shift();
                        
                    cpu.data.labels.push(dD);
                    cpu.data.datasets[0].data.push(json[0].Metrica);
                }

                window.historico_cpu.update();



            });
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