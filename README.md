# Projeto Java com Spring Boot e Documentação Swagger para uma papelaria

Este é um guia de documentação para o projeto Java desenvolvido com o framework Spring Boot, incluindo a integração da documentação Swagger


## Introdução

Este projeto é uma aplicação Java baseada em Spring Boot que demonstra como criar uma API RESTful simples. O objetivo é fornecer um exemplo claro de como configurar o Spring Boot e integrar a documentação Swagger para facilitar o desenvolvimento e a documentação da API.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Configuração do Ambiente

1. Clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/ceerqueira/papelaria.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd nome-do-repositorio
   ```

3. Importe o projeto em sua IDE de escolha (por exemplo, Eclipse, IntelliJ) como um projeto Maven.

## Executando o Projeto

Para iniciar a aplicação Spring Boot, siga estas etapas:

1. Navegue até o diretório raiz do projeto.

2. Execute o seguinte comando Maven para compilar e executar o aplicativo:

   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em `http://localhost:8080`.

## Documentação Swagger

A documentação Swagger é uma parte essencial deste projeto para documentar e testar sua API RESTful. Para acessar a documentação Swagger, siga estas etapas:

1. Após iniciar o aplicativo, abra um navegador da web.

2. Acesse a URL Swagger em `http://localhost:8080/swagger-ui/index.html`.

3. Você verá a interface do Swagger, que lista todos os endpoints disponíveis e permite que você os teste diretamente a partir do navegador.

<img width="580" alt="Captura de Tela 2023-09-06 às 17 18 13" src="https://github.com/ceerqueira/papelaria/assets/50030996/d618165f-66cd-4e57-8374-955e2ade23a6">

<img width="570" alt="Captura de Tela 2023-09-06 às 17 18 51" src="https://github.com/ceerqueira/papelaria/assets/50030996/73b1aafc-b85e-4296-a36c-1ef9309b7e32">

## Funcionamento do Projeto

O projeto cria automanticamente um banco de dados, com três tabelas:

Primeiro verifique se o acesso ao banco de dados segue os padrões como mostra na imagem:


<img width="742" alt="Captura de Tela 2023-09-06 às 17 32 53" src="https://github.com/ceerqueira/papelaria/assets/50030996/d9dd04fb-5166-4e53-94af-0c9c8b2cf1d4">

Versionamento no Flyway, já inclui a inserção de 10 itens na tabela Produto.

<img width="378" alt="Captura de Tela 2023-09-06 às 17 34 49" src="https://github.com/ceerqueira/papelaria/assets/50030996/52b92b70-dcb0-4399-a70c-e043105ca78d">


### Produtos (/produto)

Nesta seção, é possível gerenciar a lista de produtos disponíveis na papelaria. Esses produtos estão diretamente relacionados aos itens em estoque da papelaria, permitindo a visualização, adição, atualização e exclusão de produtos. 

### Carrinho de Compras (/compras)

Nesta url os clientes podem criar, editar, visualizar e excluir seus carrinhos de compras, podendo inserir informações pessoais como nome, telefone e endereço. 

### Itens do Carrinho (/adicionar)

Nesta parte do sistema os funcionários da papelaria podem adicionar, remover, editar e excluir os itens solicitados pelos clientes aos seus respectivos carrinhos de compras.












