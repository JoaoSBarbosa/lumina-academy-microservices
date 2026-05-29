
# 📚 Lumia Academy

<p align="center">
    <img src="https://img.shields.io/badge/Java-11-orange?style=for-the-badge&logo=openjdk" />
    <img src="https://img.shields.io/badge/Spring_Boot-2.x-6DB33F?style=for-the-badge&logo=springboot" />
    <img src="https://img.shields.io/badge/Spring_Cloud-2021.x-6DB33F?style=for-the-badge&logo=spring" />
    <img src="https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql" />
    <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq" />
    <img src="https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge&logo=jsonwebtokens" />
    <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity" />
    <img src="https://img.shields.io/badge/Eureka-Service_Discovery-red?style=for-the-badge&logo=netflix" />
    <img src="https://img.shields.io/badge/Config_Server-Configuration-blue?style=for-the-badge&logo=spring" />
    <img src="https://img.shields.io/badge/Elasticsearch-005571?style=for-the-badge&logo=elasticsearch" />
    <img src="https://img.shields.io/badge/Kibana-E8478B?style=for-the-badge&logo=kibana" />
    <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker" />
</p>

---

# 📖 Sobre o Projeto

O **Lumia Academy** é uma plataforma EAD desenvolvida utilizando arquitetura de microsserviços com Java e ecossistema Spring.

O projeto foi criado com foco em:

- Arquitetura distribuída
- Escalabilidade
- Desacoplamento entre serviços
- Comunicação assíncrona
- Segurança com JWT
- Observabilidade
- Boas práticas enterprise

---

# 🏗️ Arquitetura do Projeto

A aplicação é composta por múltiplos microsserviços independentes, comunicando-se através de APIs REST e mensageria com RabbitMQ.

## Componentes Principais

- API Gateway
- Eureka Server
- Config Server
- Auth User Service
- Course Service
- Payment Service
- Notification Service
- RabbitMQ
- PostgreSQL
- Elasticsearch + Kibana

---

# 📐 Diagrama da Arquitetura

<p align="center">
    <img src="./docs/architecture.png" width="1000"/>
</p>

---

# 🚀 Stack Tecnológica

## 🔧 Backend

- Java 11
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Spring Security
- JWT Authentication
- Maven

---

## ☁️ Microsserviços

- API Gateway
- Service Discovery
- Configuração Centralizada
- Comunicação Assíncrona
- Arquitetura Distribuída

---

## 🗄️ Banco de Dados

- PostgreSQL
- Hibernate
- JPA

---

## 📨 Mensageria

- RabbitMQ
- Event Driven Architecture

---

## 📊 Observabilidade

- Elasticsearch
- Kibana
- Beats

---

# 📦 Microsserviços

---

## 🔐 Auth User Service

Responsável por:

- Autenticação
- Autorização
- Geração de JWT
- Controle de acesso
- Segurança da plataforma

### Funcionalidades

- Login
- Geração de Token
- Validação JWT
- Controle de Roles
- Proteção de Rotas

---

## 📚 Course Service

Responsável por:

- Gestão de cursos
- Gestão de aulas
- Matrículas
- Catálogo da plataforma

### Funcionalidades

- Cadastro de cursos
- Atualização de cursos
- Matrículas
- Consulta de conteúdo

---

## 💳 Payment Service

Responsável por:

- Processamento de pagamentos
- Aprovação financeira
- Eventos de pagamento

### Funcionalidades

- Aprovação de pagamentos
- Processamento financeiro
- Integração entre serviços

---

## 📩 Notification Service

Responsável por:

- Envio de emails
- Notificações
- Processamento assíncrono

### Funcionalidades

- Emails automáticos
- Notificações da plataforma
- Eventos de comunicação

---

# 🌐 API Gateway

O API Gateway é responsável por centralizar o acesso da aplicação.

## Responsabilidades

- Roteamento de requisições
- Segurança
- Balanceamento
- Filtros globais
- Cross-Cutting Concerns

---

# 🔎 Eureka Server

Responsável pelo Service Discovery da arquitetura.

## Funcionalidades

- Registro dinâmico de serviços
- Descoberta automática
- Comunicação interna

---

# ⚙️ Config Server

Responsável pela centralização das configurações da aplicação.

## Benefícios

- Configuração centralizada
- Separação por ambiente
- Facilidade de manutenção
- Externalização de propriedades

---

# 📨 Comunicação Assíncrona

A comunicação entre serviços utiliza RabbitMQ para garantir desacoplamento e processamento assíncrono.

## Eventos

- Pagamento aprovado
- Matrícula realizada
- Envio de notificações
- Processamento de emails

---

# 🗄️ Estratégia de Banco de Dados

Cada microsserviço possui seu próprio banco PostgreSQL.

## Benefícios

- Escalabilidade independente
- Isolamento de domínio
- Redução de acoplamento
- Independência entre serviços

---

# 🔐 Segurança

A autenticação e autorização utilizam:

- Spring Security
- JWT
- Stateless Authentication
- Proteção de endpoints

---

# 📊 Observabilidade e Logs

A stack Elastic é utilizada para centralização e monitoramento de logs.

## Stack

- Elasticsearch
- Kibana
- Beats

## Benefícios

- Centralização de logs
- Observabilidade distribuída
- Indexação
- Monitoramento

---

# 📁 Estrutura do Projeto

```bash
lumia-academy-ms/
│
├── api-gateway/
├── discovery-server/
├── config-server/
├── auth-service/
├── course-service/
├── payment-service/
├── notification-service/
│
├── docker-compose/
│
└── docs/
    └── architecture.png
```

---

# ⚡ Executando o Projeto

## 📥 Clonar Repositório

```bash
git clone https://github.com/seu-usuario/lumia-academy-ms.git
```

---

## 🚀 Subir Infraestrutura

```bash
docker-compose up -d
```

---

## ▶️ Executar Microsserviços

```bash
mvn spring-boot:run
```

---

# 🔥 Melhorias Futuras

- Resilience4J
- Circuit Breaker
- Distributed Tracing
- OpenAPI / Swagger
- Kubernetes
- CI/CD
- Prometheus + Grafana
- OAuth2 / Keycloak

---

# 🎯 Conceitos Arquiteturais Aplicados

- Microsserviços
- Arquitetura Distribuída
- Event Driven Architecture
- Service Discovery
- API Gateway Pattern
- Database per Service
- Configuração Centralizada
- Comunicação Assíncrona
- Stateless Authentication

---

# 👨‍💻 Autor

Projeto desenvolvido com foco em estudos avançados de arquitetura backend moderna utilizando Java e ecossistema Spring.
