# 📚 FórumHub API

API REST desenvolvida em **Java** utilizando **Spring Boot** para gerenciamento de tópicos de um fórum.

O projeto implementa **CRUD completo de tópicos**, autenticação com **JWT**, segurança com **Spring Security** e **documentação interativa com Swagger**.

Este projeto foi desenvolvido como prática de backend focada em **APIs REST seguras e bem estruturadas**.

---

# 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* MySQL
* Swagger / OpenAPI

---

# ⚙️ Funcionalidades

A API permite:

* Criar um tópico
* Listar todos os tópicos
* Detalhar um tópico específico
* Atualizar um tópico
* Deletar um tópico
* Autenticação de usuário
* Proteção de rotas com JWT
* Documentação interativa da API

---

# 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)** para autenticação.

## Endpoint de login

POST `/login`

Exemplo de requisição:

```json
{
  "login": "usuario",
  "senha": "123456"
}
```

Resposta:

```
TOKEN_JWT
```

---

# 🔑 Utilizando o Token

Após realizar o login, utilize o token no header das requisições protegidas:

```
Authorization: Bearer SEU_TOKEN
```

---

# 📖 Documentação da API

A documentação interativa está disponível através do Swagger:

```
http://localhost:8080/swagger-ui.html
```

No Swagger é possível:

* visualizar todos endpoints
* testar requisições
* autenticar utilizando JWT

---

# 📦 Endpoints Principais

## Criar tópico

POST `/topicos`

## Listar tópicos

GET `/topicos`

## Detalhar tópico

GET `/topicos/{id}`

## Atualizar tópico

PUT `/topicos/{id}`

## Deletar tópico

DELETE `/topicos/{id}`

---

# ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/forumhub
```

### 2️⃣ Entrar na pasta

```
cd forumhub
```

### 3️⃣ Configurar banco de dados

Configurar no arquivo:

```
application.properties
```

Exemplo:

```
spring.datasource.url=jdbc:mysql://localhost/forumhub
spring.datasource.username=root
spring.datasource.password=senha
```

### 4️⃣ Executar o projeto

```
./mvnw spring-boot:run
```

ou executar a classe:

```
ForumhubApplication
```

---

# 🧪 Testar API

Você pode testar usando:

* Swagger
* Postman
* Insomnia

---

# 📌 Estrutura do Projeto

```
controller
service
repository
dto
infra.security
```

---

# 👨‍💻 Autor

Projeto desenvolvido para estudo e prática de **APIs REST com Spring Boot e segurança com JWT**.
