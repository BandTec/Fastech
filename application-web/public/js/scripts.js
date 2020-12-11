function entrar() {
    debugger;
    var formulario = new URLSearchParams(new FormData(form_login));
    fetch("/usuarios/autenticar", {
        method: "POST",
        body: formulario
    }).then(resposta => {

        if (resposta.ok) {

            resposta.json().then(json => {
                sessionStorage.user_login = json.login;
                window.location.href = './../dashboard/index.html';
            });

        } else {
            console.log('Erro de cadastro!');
            resposta.text().then(function (resposta) {
                console.log(resposta)
            });
        }
    });

    return false;
}


function cadastrar() {
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/usuarios/cadastrar", {
        method: "POST",
        body: formulario
    }).then(resposta => {
  
        if (resposta.ok) { 
          resposta.json().then(json => {
            sessionStorage.user_login = json.login;
            window.location.href = './../dashboard/index.html';
        });
        } else {
            
            console.log('Erro de cadastro!');
            resposta.text().then(function (resposta) {
                console.log(resposta)
            });
  
        }
    });
  
    return false;
  }

function show_company(){
    fetch(`/usuarios/select_company`)
    .then(res => {
        if (res.ok) {
            res.json().then((json) => {
                for(let i = 0; i < json.length; i++){
                    document.getElementById('companyBranch').innerHTML += `<option value ="${json[i].codCompany}">${json[i].nome}</option>`
                    console.log(json[i].codCompany);
                }
            });
        }
    });
}
