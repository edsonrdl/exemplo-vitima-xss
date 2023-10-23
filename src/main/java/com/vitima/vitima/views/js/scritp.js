// const responseUsers = 'http://localhost:8080/user/users';
// const responseCreate = 'http://localhost:8080/user';

const getAllPasswords = async () => {
  try {
    const response = await fetch('http://localhost:8080/user/users');
    if (!response.ok) {
      throw new Error('Falha ao buscar usuários e passwords.');
    }

    const passwords = await response.json();
    const passwordsContainer = document.getElementById('list-passwords');
    passwords.forEach(password => {
      passwordsContainer.innerHTML += generatePasswordHtml(password.password);
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
  console.log(name);
  console.log(passwordText);
  var data={
    name:name,
    password:passwordText,
  }; 
  console.log(data);
  await insertPassword(data);
  clearInputs();//vai chamar a função limpar o campo de formuãrio 
  alert('User inserido com sucesso.');
});


const generatePasswordHtml = (password) => {
  return `<li class="list-group-item">${password.password}</li>`;
};

window.onload = async () => {
  clearInputs();
  const urlParams = new URLSearchParams(window.location.search);
  const userName = urlParams.get('name');
  document.getElementById('nome-pessoa').innerHTML += userName;
  await getAllPasswords();
};
