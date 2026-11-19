# Refeição Solidária — API

API do projeto FIREFLYTECH.

Tecnologias previstas:
- Java 21
- Spring Boot
- PostgreSQL
- Maven

## Organização
O desenvolvimento será realizado em branches individuais
,
com Pull Requests e atividades vinculadas ao Jira.
API Spring Boot do FIREFLYTECH. Estrutura inicial criada na Sprint 1 (`REF-14`).

## Requisitos

- JDK 21
- Maven 3.9+ ou Maven Wrapper do repositório

## Executar

No Windows (PowerShell):

```powershell
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

Em Linux/macOS:

```bash
./mvnw test
./mvnw spring-boot:run
```

Verifique a aplicação em `http://localhost:8080/api/status`.

## Organização de pacotes

- `controller`: endpoints REST; nesta sprint contém apenas rota diagnóstica.
- `domain`: entidades e enums (Sprint 2/3).
- `repository`: persistência (Sprint 2/3).
- `service`: regras de negócio (sprints seguintes).

O PostgreSQL e o Docker Compose são preparados na Task `REF-15`, mas esta primeira versão da API não usa banco de dados. Isso evita dependência do ambiente do colega para compilar a estrutura inicial.
