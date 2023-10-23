// const responseUsers = 'http://localhost:8080/user/users';
// const responseCreate = 'http://localhost:8080/user';

const getAllUsers = async () => {
  try {
    const response = await fetch('http://localhost:8080/user/users');
    if (!response.ok) {
      throw new Error('Falha ao buscar usuários e passwords.');
    }
    const users = await response.json();
    console.log(users)
    const usersContainer = document.getElementById('list-users');
    users.forEach(user => {
      usersContainer.innerHTML += generatePasswordHtml(user);
      console.log(user)
    });
  } catch (error) {
    console.error(error);
  }
};

const insertPassword = async (data) => {
  try {
    const response = await fetch('http://localhost:8080/user', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error('Erro na tentativa de criar um User');
    }
  } catch (error) {
    console.error(error);
  }
};

//Limpar Campo de formulário
const clearInputs = () => {
  document.getElementById('name').value = '';
  document.getElementById('password').value = '';
};

const sendButton = document.getElementById('send-btn');

sendButton.addEventListener('click', async (event) => {
  event.preventDefault();
  const name = document.getElementById('name').value;
  const passwordText = document.getElementById('password').value;

  var data={
    name:name,
    password:passwordText,
  }; 
  await insertPassword(data);
  clearInputs();//vai chamar a função limpar o campo de formuãrio 
  alert('User inserido com sucesso.');
});


const generatePasswordHtml = (user) => {
  // return `<li class="list-group-item">${user}</li>`;

 return `
      <tr>
          <td scope="row">${user.id}</td>
          <td>${user.name}</td>
          <td>${user.password}</td>
      </tr>`;
};

window.onload = async () => {
  clearInputs();
  const urlParams = new URLSearchParams(window.location.search);
  const userName = urlParams.get('name');
  document.getElementById('nome-pessoa').innerHTML += userName;
  await getAllUsers();
};
