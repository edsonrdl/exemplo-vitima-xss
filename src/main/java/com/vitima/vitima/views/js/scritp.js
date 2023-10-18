// Função para buscar todos os usuários na API e exibi-los na página
const getAllUsuarios = async () => {
    try {
        const response = await fetch('http://localhost:8080/usuario');
        if (response.ok) {
            const usuarios = await response.json();
            const usuariosContainer = document.getElementById('list-usuarios');
            usuarios.forEach(usuario => {
                usuariosContainer.innerHTML += generateUsuarioHtml(usuario);
            });
        } else {
            console.error('Erro ao buscar usuários na API');
        }
    } catch (error) {
        console.error('Erro na solicitação Fetch:', error);
    }
}

// Função para inserir um novo usuário na APIk 
const insertUsuario = async (usuario) => {
    try {
        const response = await fetch('http://localhost:8080/usuario', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuario)
        });
        if (response.ok) {
            clearInputs();
            alert('Usuário cadastrado com sucesso.');
        } else {
            console.error('Erro ao inserir usuário na API');
        }
    } catch (error) {
        console.error('Erro na solicitação Fetch:', error);
    }
}

const clearInputs = () => {
    document.getElementById('name').value = '';
    document.getElementById('password').value = '';
}

// Event listener para o botão de usuário
document.getElementById('usuario-btn').addEventListener('click', async () => {
    const name = document.getElementById('name').value;
    const password = document.getElementById('password').value;
    await insertUsuario({ name, password });
});

// Função para gerar HTML para representar um usuário
const generateUsuarioHtml = (usuario) => {
    console.log(usuario);
    return `<li class="list-group-item">${usuario.usuario}</li>`;
}

// Função a ser executada quando a página é carregada
window.onload = async () => {
    clearInputs();

    // Tenta extrair o parâmetro 'name' da URL
    const urlParams = new URLSearchParams(window.location.search);
    const userName = urlParams.get('name');

    // Exibe o nome da pessoa em um elemento da página
    document.getElementById('nome-pessoa').innerHTML += userName;

    // Chama a função para buscar e exibir os usuários na página
    await getAllUsuarios();
}

// Função para buscar todos os usuários na API e exibi-los na página
// const getAllUsuarios = async () => {
//     const response = await axios.get('http://localhost:8080/usuario');
//     const usuariosContainer = document.getElementById('list-usuarios');
//     const { usuarios } = response.data;
//     usuarios.forEach(usuario => {
//         usuariosContainer.innerHTML += generateCommentHtml(usuario)
//     });
// }

// // Função para inserir um novo usuário na API
// const insertUsuario = async (usuario) => {
//     await axios.post('http://localhost:8080/usuario', usuario)
// }

// const clearInputs = () => {
//     document.getElementById('name').value = '';
//     document.getElementById('password').value = '';
// }


// // Event listener para o botão de usuário
// document.getElementById('usuario-btn').addEventListener('click', async () => {
//     const name = document.getElementById('name').value;
//     const password = document.getElementById('password').value;
//     await insertComment({ name, password });
//     clearInputs();
//     alert('Usuário cadastrado com sucesso.')
// })

// // Função para gerar HTML para representar um usuário
// const generateUsuarioHtml = (usuario) => {
//     console.log(usuario)
//     return `<li class="list-group-item">${usuario.usuario}</li>`
// }


// // Função a ser executada quando a página é carregada
// window.onload = async () => {
//     clearInputs();

//     // Tenta extrair o parâmetro 'name' da URL
//     const urlParams = new URLSearchParams(window.location.search);
//     const userName = urlParams.get('name');

//     // Exibe o nome da pessoa em um elemento da página
//     document.getElementById('nome-pessoa').innerHTML += userName;

//     //Chama a função para buscar e exibir os usuários na página
//     await getAllUsuarios()
// }
