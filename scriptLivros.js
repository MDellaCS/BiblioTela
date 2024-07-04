document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('frmBook');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        let titulo = document.getElementById('txtTitulo').value;
        let isbn = document.getElementById('txtIsbn').value;
        let editora = document.getElementById('txtEditora').value;
        let anoPublicacao = document.getElementById('txtAno').value;
        let genero = document.getElementById('txtGenero').value;
        let autor = document.getElementById('txtAutor').value.split(',');
        let sinopse = document.getElementById('txtSinopse').value;

        let autorList = autor.map(nome => ({ nome: nome.trim() }));

        console.log('Título: ', titulo);
        console.log('ISBN: ', isbn);
        console.log('Editora: ', editora);
        console.log('Ano de Publicação: ', anoPublicacao);
        console.log('Gênero: ', genero);
        console.log('Autor: ', autorList);
        console.log('Sinopse: ', sinopse);

        const response = await fetch('http://localhost:8080/books/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ titulo, isbn, editora, anoPublicacao, genero, autores: autorList, sinopse })
        });

        if (response.ok) {
            console.log('Foi');
        } else {
            console.error('Erro ao registrar livro: ', response.statusText);
        }
    });
});
