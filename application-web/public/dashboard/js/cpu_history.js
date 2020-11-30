var cpu = {
    type: 'line',
    data: {
        labels: ['momento 1', 'momento 2', 'momento 3', 'momento 3', 'momento 4', 'momento 6', 'momento 7'],
        datasets: [{
            label: 'CPU',
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
        }, {
            label: 'Memoria',
            fill: false,
            backgroundColor: "#FE4242",
            borderColor: "#FE4242",
            data: [
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize()
            ],
        }, {
            label: 'Disco',
            fill: false,
            backgroundColor: "#b9c50e",
            borderColor: "#b9c50e",
            data: [
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize(),
                randomize()
            ],
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
                    labelString: 'Month'
                }
            }],
            yAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Value'
                }
            }]
        }
    }
}

window.onload = function() {
    var ctx = document.getElementById('processor_history').getContext('2d');
    window.historico_cpu = new Chart(ctx, cpu);
};

setInterval(() => {
    var ctx = document.getElementById('processor_history').getContext('2d');
    window.historico_cpu = new Chart(ctx, cpu);    
}, 3000);

function randomize(){
    return (Math.random()*100).toFixed(2);
}


