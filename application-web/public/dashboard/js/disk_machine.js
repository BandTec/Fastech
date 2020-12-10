let incrementDisk = 0;

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

                    value_Disk.innerHTML = `${json[0].Metrica}`;

                    disk.data.labels = [];
                    disk.data.datasets[0].data = [];
                    disk.options.title.text = `${json[0].Name_Machine}`;

                    for (let i = 0; i < 8; i++) {
                        disk.data.labels.push(json[i].Moment);
                        disk.data.datasets[0].data.push(json[i].Metrica);

                        incrementDisk++;
                    }

                    plotDisk();


                });
            }
        });
}

/* Gerando dados de disco */
var disk = {
    type: 'line',
    data: {
        labels: [],
        datasets: [{
            label: 'Disco Rígido',
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

function updateDisk() {
    fetch(`/data/datas_disk/${sessionStorage.id_company}/${sessionStorage.machineId}`).then(res => {
        if (res.ok) {
            res.json().then((json) => {
              
                disk.options.title.text = `${json[0].Name_Machine}`;

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
                value_Disk.innerHTML = `${json[0].Metrica}`;

                if (incrementDisk < 8) {
                    disk.data.labels.push(json[0].Moment);
                    disk.data.datasets[0].data.push(json[0].Metrica);

                    incrementDisk++;
                } else {
                    disk.data.labels.shift();
                    disk.data.datasets[0].data.shift();

                    disk.data.labels.push(json[0].Moment);
                    disk.data.datasets[0].data.push(json[0].Metrica);
                }

                window.historico_disk.update();



            });
        } 
    });
}

function plotDisk() {
    var ctx = document.getElementById('disk_history').getContext('2d');
    window.historico_disk = new Chart(ctx, disk);
}

window.onload = plotDisk();

setInterval(() => {
    updateDisk();
}, 1500);