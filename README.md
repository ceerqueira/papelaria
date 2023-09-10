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

<img width="273" alt="Captura de Tela 2023-09-09 às 21 51 01" src="https://github.com/ceerqueira/papelaria/assets/50030996/e469138c-2ad3-4dd2-a463-fa3368aea5d8">

POST 
para realizar uma requisição do tipo Post é necessario informa a quantidade e o idProduto para cadastra, se não ele vai lança uma expection.


GET


<img width="260" alt="Captura de Tela 2023-09-09 às 21 54 00" src="https://github.com/ceerqueira/papelaria/assets/50030996/583e5bce-a8de-46f4-957d-cfe2d35f6414">

Essa requisição do tipo Get lista todos os pedidos feitos. 

<img width="290" alt="Captura de Tela 2023-09-09 às 21 55 14" src="https://github.com/ceerqueira/papelaria/assets/50030996/d9a66404-aff7-485a-b07e-1fb88879012d">

Essa requisição faz uma busca pelo codigo de acesso, e retorna a lista de produtos e quantidade selecionados.

<img width="321" alt="Captura de Tela 2023-09-09 às 21 58 06" src="https://github.com/ceerqueira/papelaria/assets/50030996/360f780d-8869-4b94-b697-4bbfddfc0a41">

Para realizar uma altereção é necessario informa idPedido, idProduto (Se deseja alterar o produto, se não, ele não vai fazer a alteração) e quantidade nova.


<img width="303" alt="Captura de Tela 2023-09-09 às 21 59 54" src="https://github.com/ceerqueira/papelaria/assets/50030996/8475e356-8daa-48f6-867c-c63186ba4386">

Para Deletar basta informa no fim da URL o ID do pedido.


### Carrinho de Compras (/endereco)

Nesta url os funcionarios podem criar e visualizar o endereco do cliente, podendo inserir informações pessoais como nome, telefone e endereço. 
<img width="272" alt="Captura de Tela 2023-09-09 às 22 01 18" src="https://github.com/ceerqueira/papelaria/assets/50030996/c98befb4-b071-4f61-8076-cb09f2e0a00b">

bastar preencher cada um dos campos 

<img width="280" alt="Captura de Tela 2023-09-09 às 22 02 58" src="https://github.com/ceerqueira/papelaria/assets/50030996/8b9e8b8e-7266-41b2-a4bc-e8aa2a165f14">

Por fim retornará um codigo de acesso que deve ser guardado para futuras consultas.

<img width="316" alt="Captura de Tela 2023-09-09 às 22 04 05" src="https://github.com/ceerqueira/papelaria/assets/50030996/e4a07ee1-836f-4b09-8889-b40a595fa65d">
com codigo de acesso é possivel ter acesso aos dados do cliente e a lista de produtos selecionados


### Itens do Carrinho (/produtos)

retorna todos os 

<img width="292" alt="Captura de Tela 2023-09-09 às 22 03 52" src="https://github.com/ceerqueira/papelaria/assets/50030996/c155f590-0f14-4468-a9e0-0e2dfeac6704">











