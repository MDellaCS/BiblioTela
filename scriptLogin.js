document.addEventListener('DOMContentLoaded', () => {
});

async function login() {

    let username = document.getElementById('txtUsuario').value;
    let password = document.getElementById('txtSenha').value;

    console.log('Usuário: ', username);
    console.log('Senha: ', password);

    const response = await fetch('http://localhost:8080/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const errorMessage = await response.text();
        document.getElementById('error').innerText = errorMessage;

        document.getElementById('error').classList.add('shiver');
        setTimeout(() => {
            void document.getElementById('error').offsetWidth;
            document.getElementById('error').classList.remove('shiver');
        }, 200);

    }

}

async function register() {

    let username = document.getElementById('txtUsuario').value;
    let password = document.getElementById('txtSenha').value;

    console.log('Usuário: ', username);
    console.log('Senha: ', password);

    await fetch('http://localhost:8080/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

}
