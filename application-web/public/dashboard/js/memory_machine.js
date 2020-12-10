let incrementMem = 0;
function getMem() {
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
                    value_Mem.innerHTML = `${json[0].Metrica}`;

                    mem.data.labels = [];
                    mem.data.datasets[0].data = [];
                    mem.options.title.text = `${json[0].Name_Machine}`;

                    for (let i = 0; i < 8; i++) {
                        mem.data.labels.push(json[i].Moment);
                        mem.data.datasets[0].data.push(json[i].Metrica);

                        incrementMem++;
                    }

                    plotMem();

                });
            }
        });
}

var mem = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'Memória RAM',
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
            text: 'Máquina tal'
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

function updateMem() {
    fetch(`/data/datas_mem/${sessionStorage.id_company}/${sessionStorage.machineId}`).then(res => {
        if (res.ok) {
            res.json().then((json) => {
               
                cpu.options.title.text = `${json[0].Name_Machine}`;

                $("#progress_mem").each(function () {
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
                value_Mem.innerHTML = `${json[0].Metrica}`;

                if (incrementMem < 8) {
                    mem.data.labels.push(json[0].Moment);
                    mem.data.datasets[0].data.push(json[0].Metrica);

                    incrementMem++;
                } else {
                    mem.data.labels.shift();
                    mem.data.datasets[0].data.shift();

                    mem.data.labels.push(json[0].Moment);
                    mem.data.datasets[0].data.push(json[0].Metrica);
                }

                window.historico_Mem.update();



            });
        } 
    });
}

function plotMem() {
    var ctx = document.getElementById('memory_history').getContext('2d');
    window.historico_Mem = new Chart(ctx, mem);
}

window.onload = plotMem();

setInterval(() => {
    updateMem();
}, 1500);