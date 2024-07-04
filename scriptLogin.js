document.addEventListener('DOMContentLoaded', () => {
});

async function login() {

    console.log('Usuário: ', document.getElementById('txtUsuario').value);
    console.log('Senha: ', document.getElementById('txtSenha').value);

    const response = await fetch('http://localhost:8080/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ usuario, senha})
    });

    if (response.ok) {
        console.log('Foi');
    } else {
        console.error('Erro ao registrar livro: ', response.statusText);
    }
}
