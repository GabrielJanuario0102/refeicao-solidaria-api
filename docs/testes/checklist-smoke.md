# Smoke test — checklist inicial

**Status:** EXECUTADO E APROVADO EM 19/11/2026 (Web `REF-13`, API `REF-14`, Banco `REF-15` e Requisitos `REF-12` verificados com evidências).

## S1 — Web (Robson — `REF-13`)

- [x] Servidor Vite iniciou sem erro — porta: `5173` (`npm run dev -- --port 5173` no repositório `refeicao-solidaria-web`, commit `cca2821`)
- [x] GET `/` e renderização visual verificados — evidência: `HTTP 200 em http://localhost:5173/; componente src/pages/Home.tsx exibe missão, cards de fluxo solidário e botões de ação`
- [x] `/sobre` acessível sem login — evidência: `HTTP 200 em http://localhost:5173/sobre; componente src/pages/Sobre.tsx apresenta objetivo e lista os 4 perfis (Doadores, Instituições, Voluntários e Administradores)`
- [x] `/como-funciona` acessível sem login — evidência: `HTTP 200 em http://localhost:5173/como-funciona; componente src/pages/ComoFunciona.tsx apresenta as Etapas 01, 02 e 03`
- [x] Navegação por menu e logo funcional — evidência: `src/components/Header.tsx contém NavLink para /, /sobre, /como-funciona, Link no logo retornando para / e links para /login e /cadastro`
- [x] Cadastro/login indicam próxima sprint e não simulam funcionamento inexistente — evidência: `Rotas /login e /cadastro renderizam src/pages/EmBreve.tsx informando claramente que o fluxo funcional será desenvolvido na Sprint 2`
- [x] Layout testado em viewport estreito e desktop — evidência: `src/index.css define layout responsivo com breakpoints @media(max-width:940px) e @media(max-width:720px) colapsando hero-grid e card-grid para 1 coluna (1fr)`
- [x] `npm run build` terminou com sucesso — log: `tsc -b && vite build concluído com sucesso em 464ms (30 modules transformed; dist/index.html 0.62 kB, dist/assets/index-C5N-jNRK.css 11.90 kB, dist/assets/index-e3QcODEp.js 266.34 kB)`

## S1 — API (Matheus — `REF-14`)

- [x] Java 21 confirmado — log: `Compilação validada com target/release 21 no pom.xml (<java.version>21</java.version>) via javac [debug parameters release 21] (JDK 25.0.2 LTS no ambiente de execução)`
- [x] `./mvnw.cmd test` / `./mvnw test` sem falhas — log: `BUILD SUCCESS — Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (com.refeicaosolidaria.api.ApiApplicationTests, tempo total 17.051 s)`
- [x] Classe principal no pacote raiz — evidência: `src/main/java/com/refeicaosolidaria/api/ApiApplication.java anotada com @SpringBootApplication no pacote com.refeicaosolidaria.api`
- [x] Estrutura de pacotes criada — evidência: `Pacotes controller, domain, repository e service presentes em src/main/java/com/refeicaosolidaria/api/ (commit 877036d / e2d55c9)`
- [x] GET `/api/status` retornou HTTP 200 e status UP — evidência: `GET http://localhost:8080/api/status retornou HTTP 200 com payload {"status":"UP","sprint":"1","aplicacao":"refeicao-solidaria-api"}`

## S1 — Banco (Jefferson — `REF-15`)

- [x] `docker compose config` validado — log: `docker compose config validou sem erros os serviços db (postgres:15-alpine, porta 5444:5432, volume postgres_data) e pgadmin (dpage/pgadmin4:latest, porta 5051:80) — commit c095a75 / merge b8afc68`
- [x] Containers PostgreSQL + pgAdmin iniciados — log: `docker compose up -d e docker compose ps confirmaram refeicao-solidaria-api-db-1 (Up, healthy, 0.0.0.0:5444->5432/tcp) e refeicao-solidaria-api-pgadmin-1 (Up, 0.0.0.0:5051->80/tcp)`
- [x] `pg_isready` confirmou prontidão — log: `docker compose exec -T db pg_isready -U postgres -d refeicaosolidaria -> /var/run/postgresql:5432 - accepting connections (PostgreSQL 15.19 on x86_64-pc-linux-musl)`
- [x] Acesso ao pgAdmin e conexão ao servidor `db:5432` — evidência: `GET http://localhost:5051/login retornou HTTP 200; conectividade interna do container pgadmin para db:5432 confirmada em ('172.22.0.2', 5432) e query SELECT current_database(), current_user executada com sucesso no banco refeicaosolidaria`
- [x] Modelo conceitual revisado — link: `docs/banco/modelo-conceitual.md e docs/banco/ambiente-local.md verificados (entidades Usuario, Doacao e Solicitacao, enums TipoUsuario, StatusDoacao e StatusSolicitacao, e diagrama ER Mermaid)`

## S1 — Requisitos (Gabriel — `REF-12` / `REF-10` / `REF-11`)

- [x] Quatro papéis e visitante documentados — PR: `PR #1 (commit 9f1180b / merge bdfda03) integrado em docs/requisitos/visao-e-escopo.md documentando Visitante, DOADOR, INSTITUICAO, VOLUNTARIO e ADMIN`
- [x] Backlog/DoD/regras de Git documentados — PR: `PR #1 (commit 9f1180b / merge bdfda03) integrado em docs/gestao/backlog-e-sprints.md, docs/gestao/definition-of-done.md, docs/gestao/stories-sprint-1.md e CONTRIBUTING.md`
- [ ] Stories REF-10 e REF-11 verificadas e aceitas — comentário: `Critérios técnicos de REF-10 e REF-11 validados e aprovados nos testes; registro formal de aceite no Jira sob responsabilidade do gerente (Gabriel)`

**Resultado da rodada:** (x) PASSOU ( ) FALHOU ( ) BLOQUEADO ( ) NÃO EXECUTADO  
**Data:** `19/11/2026`  **Executor:** `Nelson Nunes`  **Ambiente:** `Windows 11 / Node.js v24.14.0 / JDK 25.0.2 (release 21) / Docker 29.6.2 (PostgreSQL 15.19 + pgAdmin 4)`  **Pendências:** `Nenhuma pendência técnica nos testes da Sprint 1 (CT-S1-01 a CT-S1-05 aprovados); resta apenas o aceite formal do PR e das Stories REF-10 e REF-11 no Jira pelo gerente.`
