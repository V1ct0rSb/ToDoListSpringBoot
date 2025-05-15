# 📝 ToDo List

Este é um projeto pessoal de uma API RESTful para gerenciamento de tarefas (ToDo List), desenvolvido com **Spring Boot**. A aplicação permite **criar**, **listar**, **atualizar** e **excluir** tarefas, ordenadas por **prioridade** e **nome**.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Web
- Spring Boot DevTools
- MySQL Connector
- H2 Database (para testes)
- Spring Boot Starter Validation
- Springdoc OpenAPI (Swagger)

---

## 📦 Instalação

### Pré-requisitos

- [JDK 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/) (ou configure o H2)

### Configuração do banco de dados

Edite o arquivo `src/main/resources/application.properties` com suas credenciais e URL do banco de dados. 

---

## 📌 Endpoints da API

| Método | Rota           | Descrição                 |
|--------|----------------|---------------------------|
| POST   | `/todos`       | Cria uma nova tarefa      |
| GET    | `/todos`       | Lista todas as tarefas    |
| PUT    | `/todos`       | Atualiza uma tarefa       |
| DELETE | `/todos/{id}`  | Exclui uma tarefa por ID  |

🔄 As tarefas são retornadas ordenadas por:
1. **Prioridade (descendente)**
2. **Nome (ascendente)**

---

## ✅ Testes

Os testes automatizados utilizam `WebTestClient` para simular requisições HTTP aos endpoints.

## 📚  Documentação da API

A aplicação conta com documentação interativa via Swagger.

Após subir o projeto, acesse: http://localhost:8080/swagger-ui/index.html



