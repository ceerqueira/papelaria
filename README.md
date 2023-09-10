# Aplicação Fullstack com React e Spring Boot

Um projeto para fornecer aos funcionarios de uma papelaria um controle do estoque, a possibilidade de fazer de um pedido e buscar os pedidos feitos pelo codigo do pedido.

Este é um guia de documentação para o projeto usando React e Java.


## Introdução

Este projeto é uma aplicação Java baseada em Spring Boot que demonstra como criar uma API RESTful simples. O objetivo é fornecer um exemplo claro de como configurar o Spring Boot e integrar a documentação Swagger para facilitar o desenvolvimento e a documentação da API.


## Configuração do Ambiente

1. Clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/ceerqueira/papelaria.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd FRONTEND
   ```

   ```bash
   cd BACKEND
   ```


## Executando o Projeto Backend

Para iniciar a aplicação Spring Boot, siga estas etapas:

1. Navegue até o diretório raiz do projeto.

2. Execute o seguinte comando Maven para compilar e executar o aplicativo:

   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em `http://localhost:8080`.

## Executando o Projeto Frontend

Para iniciar a aplicação Spring Boot, siga estas etapas:

1. Navegue até o diretório raiz do projeto.

2. Instale as depedências do projeto

   ```bash
   npm install
   ```
3. Execute o servidor desenvolvido em React

   ```bash
   npm start
   ```
4. A aplicação estará disponível em `http://localhost:3000`



## Documentação Swagger

Para acessar a documentação Swagger, siga estas etapas:

1. Após iniciar o aplicativo, abra um navegador da web.

2. Acesse a URL Swagger em `http://localhost:8080/swagger-ui/index.html`.

3. Você verá a interface do Swagger, que lista todos os endpoints disponíveis e permite que você os teste diretamente a partir do navegador.

<img width="557" alt="Captura de Tela 2023-09-09 às 21 48 50" src="https://github.com/ceerqueira/papelaria/assets/50030996/f6f6c62b-b9f4-4eec-a491-67af89f8f5c3">

## Funcionamento do Projeto

O projeto cria automanticamente um banco de dados, com três tabelas:

Primeiro verifique se o acesso ao banco de dados segue os padrões como mostra na imagem:


<img width="742" alt="Captura de Tela 2023-09-06 às 17 32 53" src="https://github.com/ceerqueira/papelaria/assets/50030996/d9dd04fb-5166-4e53-94af-0c9c8b2cf1d4">

Versionamento no Flyway, já inclui a inserção de 10 itens na tabela Produto.

<img width="378" alt="Captura de Tela 2023-09-06 às 17 34 49" src="https://github.com/ceerqueira/papelaria/assets/50030996/52b92b70-dcb0-4399-a70c-e043105ca78d">


### Pedidos (/pedido)

Nesta seção é possivel criar,editar,listar e deletar os Pedidos

Tipos de requisições:

**POST** `http://localhost:8080/pedido`

para realizar uma requisição do tipo Post é necessario usar o formato JSON e informa a quantidade e o idProduto para cadastra, se não ele vai lança uma expection.


   ```bash
   {
     "idProduto":2,
     "quantidade":1
   }
   ```


**GET** `http://localhost:8080/pedido`

Vai listar em formato JSON 

**GET** `http://localhost:8080/pedido/(codigo de acesso)`

Essa requisição faz uma busca pelo codigo de acesso, e retorna a lista de produtos e quantidade selecionados no pedido.

**PUT** `http://localhost:8080/pedido`

Para realizar uma altereção é necessario informa quantidade nova, se deseja alterar o produto,é necessario informa o novo idProduto se não, ele não vai fazer a alteração.


   ```bash
   {
   	"idPedido":1,
   	"idProduto":5,
      "quantidade": 5
   }
   ```

**DELETE** `http://localhost:8080/pedido/(idPedido)`

Para Deletar basta informa no fim da URL o ID do pedido.


### Carrinho de Compras (/endereco)

Nesta url os funcionarios podem criar e visualizar o endereco do cliente, podendo inserir informações pessoais como nome, telefone e endereço. 

**POST** `http://localhost:8080/endereco`

Para realizar uma requisição é necessario seguir os seguintes padrões em formato JSON

   ```bash
   {
   	"nome":"Victor",
   	"endereco":"Rua 123",
   	"telefone":"123123123",
   	"numeroPedido":2
   }
   ```
Essa requisição retorna dessa forma, lembre-se de guardar o código de acesso para realizar futuras consultas 

```
   Pedido cadastrado com sucesso
   Seu codigo de acesso é 3458
```


**GET** `http://localhost:8080/endereco/(codigo de acesso)`


com codigo de acesso é possivel ter acesso aos dados do cliente e a lista de produtos selecionados


### Itens do Carrinho (/produtos)


**GET** `http://localhost:8080/produtos`

Retornar todos os produtos em formato JSON que estão cadastrado do banco de dados











