document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('frmUser');
    const usersList = document.getElementById('usersList');

    const inputs = document.getElementsByClassName('formInput');

    Array.from(inputs).forEach(input => {
        input.addEventListener('input', function () {
            this.classList.add('press');
            setTimeout(() => {
                void this.offsetWidth;
                this.classList.remove('press');
            }, 100);
        });
    });

    function clearSpin() {
        Array.from(inputs).forEach(input => {
            input.classList.add('spin');
            input.value = "";
            setTimeout(() => {
                void input.offsetWidth;
                input.classList.remove('spin');
            }, 500);
        });
    }

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const name = document.getElementById('txtNome').value;
        const email = document.getElementById('txtEmail').value;

        const response = await fetch('http://localhost:8080/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, email })
        });

        if (response.ok) {
            loadUsers();
        } else {
            console.error('Erro ao registrar usuário:', response.statusText);
        }

        clearSpin();
    });

    // Função para carregar e exibir todos os usuários
    async function loadUsers() {
        try {
            const response = await fetch('http://localhost:8080/users/all');

            if (!response.ok) {
                throw new Error('Erro ao obter usuários');
            }

            const users = await response.json();
            usersList.innerHTML = ''; // Limpa a lista antes de adicionar os novos usuários

            users.forEach((user, index) => {
                setTimeout(() => {
                    const userElement = document.createElement('div');
                    userElement.textContent = `${user.name} | ${user.email}`;
                    userElement.classList.add('slide');
                    usersList.appendChild(userElement);
                }, index * 100);
            });

        } catch (error) {
            console.error('Erro ao carregar usuários:', error);
        }
    }

    // Carrega os usuários quando a página é carregada
    loadUsers();
});