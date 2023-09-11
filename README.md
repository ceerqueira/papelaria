# Aplicação Fullstack com React e Spring Boot - Java

Um projeto para fornecer aos funcionários de uma papelaria o controle do estoque, fazer pedidos e buscar os pedidos feitos pelo código de acesso ao pedido.

Este é um guia de documentação para o projeto usando React e Java.

## Pré-requisitos

- **Git:** [Instalar Git](https://git-scm.com/downloads)


   -Para verificar se o Git está instalado: 

     ```bash
     git --version
    ```

- **Java Development Kit (JDK):** Versão compatível do JDK instalada. Recomendado Java 8 ou superior. [Download do JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

   -Para verificar se o JDK está instalado e qual versão está em uso: 

     ```bash
     java -version
    ```

- **Maven:** [Download do Maven](https://maven.apache.org/download.cgi)

    -Para verificar se o Maven está instalado: 

     ```bash
     mvn -version
    ```

- **Node.js e npm:** [Download do Node.js](https://nodejs.org/)


    -Para verificar se o Node.js e o npm estão instalados, você pode executar os seguintes comandos:: 

     ```bash
      node -v
    ```

     ```bash
      npm -v
    ```


- **MySQL:**  [Download do MySQL](https://dev.mysql.com/downloads/)

    -Para verificar se o MySQL esta instalado basta rodar o seguinte comando: 

     ```bash
      mysql --version
    ```



## Funcionamento do Projeto

no application.properties está como consta abaixo. Verifique se o acesso ao banco de dados MySQL está com o username e password padrão:
   ```bash
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.datasource.url=jdbc:mysql://localhost/papelaria?createDatabaseIfNotExist=true
      spring.datasource.username=root
      spring.datasource.password=root
      spring.jpa.show-sql=true
   ```


Utilizando o sistema de versionamento do Flyway, ele cria um databases, com três tabelas e insere 12 itens na tabela Produto.

<img width="323" alt="Captura de Tela 2023-09-10 às 11 38 41" src="https://github.com/ceerqueira/papelaria/assets/50030996/10a18235-25af-4857-adda-405a9bba2032">


- **Portas:** Certifique-se de que as portas padrão especificadas (8080 para o backend e 3000 para o frontend) não estejam sendo usadas por outros serviços em sua máquina.



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

1. Navegue até o diretório raiz do projeto:

   ```bash
   cd FRONTEND
   ```

2. Instale as depedências do projeto:

   ```bash
   npm install
   ```


3. Execute o servidor desenvolvido em React:

   ```bash
   npm start
   ```


4. A aplicação estará disponível em `http://localhost:3000`


## Estrutura do projeto frontend


<img width="1415" alt="Captura de Tela 2023-09-10 às 19 08 01" src="https://github.com/ceerqueira/papelaria/assets/50030996/b91934c4-fa42-42b8-beba-6c66243d82bd">


<img width="1409" alt="Captura de Tela 2023-09-10 às 19 08 26" src="https://github.com/ceerqueira/papelaria/assets/50030996/8bfab928-efb8-49cb-9cbf-fc168c0c971e">


<img width="1434" alt="Captura de Tela 2023-09-10 às 19 08 39" src="https://github.com/ceerqueira/papelaria/assets/50030996/492a71b8-41d5-40eb-b70a-da714f18345e">


<img width="1435" alt="Captura de Tela 2023-09-10 às 19 42 24" src="https://github.com/ceerqueira/papelaria/assets/50030996/e70f2de6-70eb-4af8-b72e-682984dc4805">


<img width="436" alt="Captura de Tela 2023-09-10 às 19 42 33" src="https://github.com/ceerqueira/papelaria/assets/50030996/53130612-4b42-4dca-ba6e-69843d15e33d">


<img width="438" alt="Captura de Tela 2023-09-10 às 19 42 46" src="https://github.com/ceerqueira/papelaria/assets/50030996/df0139d5-998d-4b75-8257-07d6c9d838e7">


<img width="438" alt="Captura de Tela 2023-09-10 às 19 43 05" src="https://github.com/ceerqueira/papelaria/assets/50030996/8f30d9d0-40ed-4923-add9-ad96c5ec4727">


<img width="441" alt="Captura de Tela 2023-09-10 às 19 43 17" src="https://github.com/ceerqueira/papelaria/assets/50030996/33d7a3d4-fa07-4842-bbea-201e4488e566">


<img width="1434" alt="Captura de Tela 2023-09-10 às 19 43 37" src="https://github.com/ceerqueira/papelaria/assets/50030996/b46b0ea9-695b-4849-9b1c-747b6ff966f0">



## Documentação backend

Para acessar a documentação Swagger, siga estas etapas:

1. Após iniciar o aplicativo, abra um navegador da web.

2. Acesse a URL Swagger em `http://localhost:8080/swagger-ui/index.html`.

3. Você verá a interface do Swagger, que lista todos os endpoints disponíveis e permite que você os teste diretamente a partir do navegador.

<img width="557" alt="Captura de Tela 2023-09-09 às 21 48 50" src="https://github.com/ceerqueira/papelaria/assets/50030996/f6f6c62b-b9f4-4eec-a491-67af89f8f5c3">

## Tipos de requisições:

### Pedidos (/pedido)

Nesta seção é possivel criar, editar, listar e deletar os pedidos.

**POST** `http://localhost:8080/pedido`

Para realizar uma requisição do tipo Post é necessário usar o formato JSON e informar a quantidade e o idProduto para cadastrar, do contrário ele vai lançar uma exception.


   ```bash
   {
     "idProduto":2,
     "quantidade":1
   }
   ```


**GET** `http://localhost:8080/pedido`

Vai listar em formato JSON todos os pedidos cadastrados.

**GET** `http://localhost:8080/pedido/(codigo de acesso)`

Essa requisição faz uma busca pelo código de acesso, e retorna a lista de produtos e quantidade selecionados no pedido.

**PUT** `http://localhost:8080/pedido`

Para realizar uma altereção é necessário informar o idPedido e a quantidade nova. Se deseja alterar o produto, é necessário informar o novo idProduto, do contrário ele não vai fazer a alteração.


   ```bash
   {
   	"idPedido":1,
   	"idProduto":5,
      "quantidade": 5
   }
   ```

**DELETE** `http://localhost:8080/pedido/(idPedido)`

Para Deletar basta informar no fim da URL o idPedido.


### Carrinho de Compras (/endereco)

Nesta url os funcionários podem criar e visualizar o endereço do cliente, podendo inserir informações pessoais como nome, telefone e endereço. 

**POST** `http://localhost:8080/endereco`

Para realizar uma requisição é necessário seguir os seguintes padrões em formato JSON:

   ```bash
   {
   	"nome":"Victor",
   	"endereco":"Rua 123",
   	"telefone":"123123123",
   	"numeroPedido":2
   }
   ```
Esta requisição retorna a mensagem abaixo. Lembre-se de guardar o código de acesso para realizar futuras consultas. 

```
   Pedido cadastrado com sucesso
   Seu codigo de acesso é 3458
```


**GET** `http://localhost:8080/endereco/(codigo de acesso)`


Com o código de acesso é possível ter acesso aos dados do cliente e a lista de produtos selecionados.


### Itens do Carrinho (/produtos)


**GET** `http://localhost:8080/produtos`

Esta requisição retorna todos os produtos em formato JSON que estão cadastrados no banco de dados.











