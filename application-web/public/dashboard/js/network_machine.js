function showNetworkValue() {
    fetch(`/data/network/${sessionStorage.id_company}/${sessionStorage.machineId}`, { cache: 'no-store' })
        .then(res => {
            if (res.ok) {
                res.json().then((json) => {
                    network_data.innerHTML = `${json[0].Metrica}ms`;
                });
            }
        });
}

setInterval(() => {
    showNetworkValue();
}, 1500);