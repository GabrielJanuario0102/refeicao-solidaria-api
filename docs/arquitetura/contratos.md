# REF-30 — Contratos previstos entre Web e API

**Objetivo:** deixar claro o que já existe e quais rotas serão acrescentadas nas próximas sprints.

## Situação atual (Sprint 3)

| Parte | Onde os dados ficam | Situação |
|---|---|---|
| Cadastro demonstrativo | Navegador (estado/localStorage) | REF-22; não cria conta na API |
| Sessão demonstrativa | Navegador (`localStorage`) | REF-22; não há JWT nem sessão de servidor |
| Rotas por perfil | React | REF-31; bloqueio apenas na interface |
| Usuários | PostgreSQL via JPA | Modelo REF-23 e datasource REF-24 |
| Doações | PostgreSQL via JPA | Entidade REF-28 e repositório REF-32 |
| Solicitações | PostgreSQL via JPA | Entidade REF-28 e repositório REF-32 |

**Atenção:** mapeamento JPA não equivale a cadastro via HTTP. Nesta sprint, `Doacao` e `Solicitacao` não têm endpoints para criar, editar ou consultar pela web.

## Endpoint já existente

- `GET /api/status` — status básico da API (REF-14). Não envolve login nem banco.

## Rotas propostas (AINDA NÃO IMPLEMENTADAS nesta sprint)

| Método | Caminho proposto | Futuro objetivo |
|---|---|---|
| POST | `/api/doacoes` | Criar oferta de doação (Sprint 4) |
| GET | `/api/doacoes` | Listar doações com filtros (Sprint 4) |
| GET | `/api/doacoes/{id}` | Consultar uma doação (Sprint 4) |
| POST | `/api/solicitacoes` | Criar pedido de instituição (Sprint 5) |
| GET | `/api/solicitacoes` | Consultar pedidos por usuário ou doação (Sprint 5) |
| PATCH | `/api/solicitacoes/{id}` | Aprovar ou recusar, conforme regra futura (Sprint 5/6) |

Os nomes e respostas HTTP são **propostas de contrato**, sujeitos à revisão quando os serviços forem implementados. Não usar essa tabela como documentação de API funcional.

## Modelo de dados acordado

`Usuario (Long id)` é o cadastro base, com `TipoUsuario` (`DOADOR`, `INSTITUICAO`, `VOLUNTARIO`, `ADMIN`). `Doacao (Long id)` referencia `Usuario doador`. `Solicitacao (Long id)` referencia tanto `Doacao doacao` quanto `Usuario instituicao`.

**Doação:** nome do alimento, descrição, quantidade disponível, data de preparo, validade, armazenamento, aceite da declaração do doador, local e horário de retirada, foto, status e criação.  
**Solicitação:** quantidade solicitada, situação, justificativa eventual, data e vínculos com instituição e doação.

### Estados

- `StatusDoacao`: `DISPONIVEL`, `PARCIALMENTE_RESERVADA`, `TOTALMENTE_RESERVADA`, `AGUARDANDO_RETIRADA`, `CONCLUIDA`, `CANCELADA`.
- `StatusSolicitacao`: `PENDENTE`, `APROVADA`, `RECUSADA`, `CANCELADA`.

## Decisões e limites

1. Padronizar IDs do modelo em `Long`, inclusive nos repositórios JPA.
2. Persistir enums como `EnumType.STRING` para evitar depender de ordinais.
3. Regras como reservar quantidade, bloquear perfis não aprovados, autenticar e autorizar **não foram implementadas na Sprint 3**.
4. As mudanças dos dois repositórios devem ser integradas com PRs e revisadas antes de declarar as Stories concluídas.
