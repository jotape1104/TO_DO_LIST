
<h1 align="center">To-Do List</h1>

Este projeto é uma aplicação To-Do List desenvolvida com back-end em Java utilizando o framework Spring Boot e front-end com React.
<br>
A aplicação permite que os usuários gerenciem suas tarefas através de operações CRUD (criar, visualizar, atualizar e excluir tarefas) em uma interface gráfica simples e intuitiva.
<br>
Além disso, o projeto inclui uma robusta suíte de testes unitários para garantir a qualidade e a confiabilidade do código.

## 📚 Funcionalidades
- **Adicionar tarefas:** Criação de novas tarefas com título obrigatório e descrição opcional.
- **Visualizar tarefas:** A interface mostra todas as tarefas criadas em uma lista da mais recente para a mais antiga.
- **Atualizar tarefas:** Possibilidade de fazer alterações no título e descrição da tarefa.
- **Excluir tarefas:** Remoção de tarefas existentes pelo ID.

## 👨‍💻 Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Maven para gerenciamento de dependências
- MySQL como banco de dados
- JUnit 5 para testes unitários
- Mockito para simulação de dependências
- JaCoCo para análise de cobertura de código
  
## 🧱 Estrutura do Projeto
- Controller: Gerencia as requisições HTTP.
- Service: Contém a lógica de negócios da aplicação.
- Repository: Gerencia a persistência e recuperação de dados.
- Entity: Representa as entidades do banco de dados.
- Testes: Abrange casos de testes unitários para todas as funcionalidades principais.

## ⚙ Configuração do Projeto
- Pré-requisitos
- Java 17 ou superior
- Maven
- Banco de dados MySQL configurado
- Node.js

## 🛠 Como executar o projeto
### back-end:
1. Clone o repositório: ``git clone https://github.com/KarlosEKaminski/todolist-api.git``
2. Abra o arquivo **_application.properties_** em: ``backend\src\main\resources``
3. Altere as linhas 4 e 5 do arquivo inserindo o usuário e senha do banco de dados
4. Certifique-se de ter criado um schema com o nome de "todo_list" no MySQL
5. Navegue até o caminho: ``backend\src\main\java\com\karlos\todolist``
6. E execute o arquivo **_TodolistApplication.java_** via terminal ou utilizando uma IDE
<hr>

### front-end
1. Navegue até a pasta **_frontend_**
2. Utilize o comando ``npm start`` para subir a aplicação
3. Se necessário, instale as dependências requeridas
<hr>

### testes
1. Navegue até a pasta **_backend_**
2. Em um terminal, utilize o comando ``mvn clean test`` para executar os testes e gerar o relatório de cobertura de código
3. Após a execução dos testes, o relatório gerado pelo _JaCoCo_ pode ser encontrado no diretório: ``backend/target/site/jacoco/index.html``

## 👋 Contribuições
Contribuições são bem-vindas! Para contribuir:
1. Faça um fork do repositório
2. Crie uma branch para suas alterações: ``git checkout -b minha-contribuicao``
3. Envie suas alterações: ``git push origin minha-contribuicao``
4. Abra um Pull Request descrevendo suas alterações

## 📄 Licença
Este projeto está sob a licença [MIT](LICENSE.txt)<br>
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
   
