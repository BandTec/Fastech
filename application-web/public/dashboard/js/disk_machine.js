function getDisk() {
    fetch(`/data/datas_disk/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {

                res.json().then((json) => {
                    console.log(json[0]);

                    name_disk.innerHTML = `${json[0].Componente}`;

                    plotDisk();
                });
            }
        });
}

var disk = {
    type: 'doughnut',
    data: {
        datasets: [{
            data: [],
            backgroundColor: [
                '#333333',
                '#252baf'
            ],
            label: 'Disco Rígido'
        }],
        labels: [
            'Espaço Usado',
            'Espaço Livre'
        ]
    },
    options: {
        responsive: true
    }
};

function updateDisk() {
    fetch(`/data/datas_disk/${sessionStorage.id_company}/${sessionStorage.machineId}`).then(res => {
        if (res.ok) {
            res.json().then((json) => {

                disk.options.title.text = `${json[0].Name_Machine}`;


                let freeSpaces = 100 - (json[0].Metrica);
               
                disk.data.datasets[0].data.shift();
                disk.data.datasets[0].data.shift();


                disk.data.datasets[0].data.push(json[0].Metrica);
                disk.data.datasets[0].data.push(freeSpaces);



                window.historico_disk.update();



            });
        }
    });
}

function plotDisk() {
    var ctx = document.getElementById('disk_history').getContext('2d');
    window.historico_disk = new Chart(ctx, disk);
}

window.onload = plotDisk(); updateDisk();

setInterval(() => {
    updateDisk();
}, 60 * 1000);