var memory = {
    type: 'line',
    data: {
        labels: ['momento 1', 'momento 2', 'momento 3', 'momento 3', 'momento 4', 'momento 6', 'momento 7'],
        datasets: [{
            label: 'Memória RAM',
            backgroundColor: "#3B5998",
            borderColor: "#3B5998",
            data: [
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize()
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
    var ctx = document.getElementById('memory_history').getContext('2d');
    window.historico_memory = new Chart(ctx, memory);
};

setInterval(() => {
    var ctx = document.getElementById('memory_history').getContext('2d');
    window.historico_memory = new Chart(ctx, memory);    
}, 3000);

function randomize(){
    return (Math.random()*100).toFixed(2);
}


