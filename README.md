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
   git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/ceerqueira/papelaria.git)
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

2. Acesse a URL Swagger em `[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui/index.html)`.

3. Você verá a interface do Swagger, que lista todos os endpoints disponíveis e permite que você os teste diretamente a partir do navegador.

