# Lumina Academy Auth User Service

![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Wrapper-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-5434-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-Enabled-BC4521?style=for-the-badge)

Microservico Spring Boot responsavel pelo contexto de autenticacao e usuarios da plataforma Lumina Academy.

O projeto usa uma organizacao por dominio/feature, mantendo o codigo de usuario agrupado em `user` e os recursos compartilhados em `shared`. Essa estrutura evita pacotes genericos muito grandes como `controller`, `service` e `repository` soltos na raiz.

## Informacoes Do Projeto

| Item | Valor |
| --- | --- |
| Group ID | `com.lumina.academy` |
| Artifact ID | `authuser` |
| Versao | `0.0.1-SNAPSHOT` |
| Java | `21` |
| Spring Boot | `3.5.0` |
| Porta local | `8081` |
| Profile ativo | `dev` |
| Banco | `PostgreSQL` |
| URL do banco dev | `jdbc:postgresql://localhost:5434/db_lumina_auth` |
| Usuario do banco dev | `postgres` |
| Migracoes | `classpath:db/migration` |

## Stack

- Spring Boot Web
- Spring Data JPA
- Jakarta Validation
- PostgreSQL Driver
- Flyway
- Lombok
- JUnit/Spring Boot Test
- Maven Wrapper

## Organizacao Do Projeto

```text
src/main/java/com/lumina/academy/authuser
├── user
│   ├── api
│   ├── application
│   │   ├── dto
│   │   └── impl
│   ├── domain
│   │   ├── enums
│   │   └── vo
│   ├── infrastructure
│   │   ├── converters
│   │   └── persistence
│   └── mapper
├── shared
│   ├── api
│   ├── domain
│   └── exception
├── auth
├── config
└── security
```

## Responsabilidades Dos Pacotes

### `user`

Agrupa tudo que pertence ao dominio de usuarios.

| Pacote | Responsabilidade |
| --- | --- |
| `user.api` | Controllers REST e entrada HTTP. Exemplo: `UserController`. |
| `user.application` | Contratos de servico e regras de aplicacao. |
| `user.application.dto` | Objetos de entrada e saida da API. |
| `user.application.impl` | Implementacoes dos servicos de aplicacao. |
| `user.domain` | Entidades e conceitos centrais do dominio. |
| `user.domain.enums` | Enumeracoes do usuario, como status, tipo e genero. |
| `user.domain.vo` | Value Objects, como email, senha, CPF e telefone. |
| `user.infrastructure.persistence` | Repositorios e detalhes de persistencia. |
| `user.infrastructure.converters` | Converters JPA para Value Objects. |
| `user.mapper` | Conversao entre DTOs e entidade de dominio. |

### `shared`

Agrupa recursos compartilhados entre dominios.

| Pacote | Responsabilidade |
| --- | --- |
| `shared.api` | Padroes de API, constantes de rotas e envelope de resposta. |
| `shared.domain` | Classes base de dominio, como entidade auditavel/base. |
| `shared.exception` | Excecoes e tratamento global de erros. |

### Pacotes De Infraestrutura Geral

| Pacote | Responsabilidade |
| --- | --- |
| `auth` | Espaco reservado para o contexto de autenticacao. |
| `config` | Configuracoes globais da aplicacao. |
| `security` | Configuracoes e componentes de seguranca. |

## Endpoints De Usuario

Base path:

```text
/api/v1/users
```

Endpoints implementados em `UserController`:

| Metodo | Rota | Acao |
| --- | --- | --- |
| `GET` | `/api/v1/users` | Lista usuarios. |
| `GET` | `/api/v1/users/email/{email}` | Busca usuario por email. |
| `GET` | `/api/v1/users/{id}` | Busca usuario por ID. |
| `POST` | `/api/v1/users` | Cria usuario. |
| `DELETE` | `/api/v1/users/{userId}` | Remove usuario. |

## Banco De Dados

Configuracao local do profile `dev`:

```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:postgresql://localhost:5434/db_lumina_auth
    username: postgres
    password: postgres
```

As migracoes ficam em:

```text
src/main/resources/db/migration
```

Arquivos atuais:

```text
V1__create_users_table.sql
V2__add_user_fields.sql
V3__adjust_user_columns.sql
```

## Como Executar

Suba um PostgreSQL local acessivel em `localhost:5434` com o banco `db_lumina_auth`.

Depois execute:

```bash
./mvnw spring-boot:run
```

A aplicacao sobe em:

```text
http://localhost:8081
```

## Comandos Uteis

Compilar e empacotar sem testes:

```bash
./mvnw -DskipTests package
```

Rodar testes:

```bash
./mvnw test
```

Limpar build e rodar testes:

```bash
./mvnw clean test
```

## Observacoes

- Os testes de contexto dependem do PostgreSQL local configurado no profile `dev`.
- O `pom.xml` possui duas declaracoes de `spring-boot-starter-test`; isso nao impede o build, mas deve ser limpo para evitar warnings do Maven.
- A entidade de usuario usa `@Entity(name = "UserEntity")` para manter a classe `User` com nome limpo e evitar ambiguidade nas queries JPQL.
