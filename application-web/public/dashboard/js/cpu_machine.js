var cpu = {
    type: 'line',
    data: {
        labels: ['momento 1', 'momento 2', 'momento 3', 'momento 3', 'momento 4', 'momento 6', 'momento 7'],
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
            text: 'Máquina tal'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
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

window.onload = function() {
    var ctx = document.getElementById('cpu_history').getContext('2d');
    window.historico_cpu = new Chart(ctx, cpu);
};

setInterval(() => {
    var ctx = document.getElementById('cpu_history').getContext('2d');
    window.historico_cpu = new Chart(ctx, cpu);    
}, 3000);


