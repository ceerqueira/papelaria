# Aplicação Fullstack com React e Spring Boot - Java

Um projeto para fornecer aos funcionarios de uma papelaria o controle do estoque, fazer pedidos e buscar os pedidos feitos pelo codigo de acesso ao pedido.

Este é um guia de documentação para o projeto usando React e Java.

## Funcionamento do Projeto

O projeto cria automanticamente um databases, com três tabelas:

no application.properties esta da seguinte maneira, verifique se o acesso ao banco de dados MySQL esta com o username e password padrão:
   ```bash
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.datasource.url=jdbc:mysql://localhost/papelaria?createDatabaseIfNotExist=true
      spring.datasource.username=root
      spring.datasource.password=root
      spring.jpa.show-sql=true
   ```


Versionamento no Flyway, já inclui a inserção de 12 itens na tabela Produto.

<img width="323" alt="Captura de Tela 2023-09-10 às 11 38 41" src="https://github.com/ceerqueira/papelaria/assets/50030996/10a18235-25af-4857-adda-405a9bba2032">




## Executando o Projeto

1. Clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/ceerqueira/papelaria.git
   ```


## Executando o Projeto Backend

Para iniciar a aplicação Spring Boot, siga estas etapas:

1. Navegue até o diretório raiz do projeto.

   ```bash
   cd BACKEND
   ```


2. Execute o seguinte comando Maven para compilar e executar o aplicativo:

   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em `http://localhost:8080`.

## Executando o Projeto Frontend

Para iniciar a aplicação Spring Boot, siga estas etapas:

1. Navegue até o diretório raiz do projeto.

   ```bash
   cd FRONTEND
   ```

2. Instale as depedências do projeto

   ```bash
   npm install
   ```
3. Execute o servidor desenvolvido em React

   ```bash
   npm start
   ```
4. A aplicação estará disponível em `http://localhost:3000`

## Estrutura do projeto frontend


<img width="1415" alt="Captura de Tela 2023-09-10 às 19 08 01" src="https://github.com/ceerqueira/papelaria/assets/50030996/b91934c4-fa42-42b8-beba-6c66243d82bd">


<img width="1409" alt="Captura de Tela 2023-09-10 às 19 08 26" src="https://github.com/ceerqueira/papelaria/assets/50030996/8bfab928-efb8-49cb-9cbf-fc168c0c971e">


<img width="1434" alt="Captura de Tela 2023-09-10 às 19 08 39" src="https://github.com/ceerqueira/papelaria/assets/50030996/492a71b8-41d5-40eb-b70a-da714f18345e">


<img width="446" alt="Captura de Tela 2023-09-10 às 19 08 47" src="https://github.com/ceerqueira/papelaria/assets/50030996/6b4d422d-4892-4d2a-a79c-ee29d6d15893">


<img width="439" alt="Captura de Tela 2023-09-10 às 19 21 57" src="https://github.com/ceerqueira/papelaria/assets/50030996/852c14d0-66f9-48a4-b8d7-1f91128da740">


<img width="439" alt="Captura de Tela 2023-09-10 às 19 22 05" src="https://github.com/ceerqueira/papelaria/assets/50030996/bb307832-63e9-40ac-a367-2dd5dd27c9d8">


<img width="441" alt="Captura de Tela 2023-09-10 às 19 22 24" src="https://github.com/ceerqueira/papelaria/assets/50030996/4847ce8b-85ad-4d49-9a0d-7e09b5aa4734">


<img width="1430" alt="Captura de Tela 2023-09-10 às 19 09 35" src="https://github.com/ceerqueira/papelaria/assets/50030996/fab4bc9b-0485-42e8-b1f6-accf22dc4500">



## Documentação backend

Para acessar a documentação Swagger, siga estas etapas:

1. Após iniciar o aplicativo, abra um navegador da web.

2. Acesse a URL Swagger em `http://localhost:8080/swagger-ui/index.html`.

3. Você verá a interface do Swagger, que lista todos os endpoints disponíveis e permite que você os teste diretamente a partir do navegador.

<img width="557" alt="Captura de Tela 2023-09-09 às 21 48 50" src="https://github.com/ceerqueira/papelaria/assets/50030996/f6f6c62b-b9f4-4eec-a491-67af89f8f5c3">


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











