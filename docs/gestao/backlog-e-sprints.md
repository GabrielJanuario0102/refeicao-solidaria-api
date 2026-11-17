# FIREFLYTECH — Product Backlog e cronograma

Referência de acompanhamento: exportação do Jira `Jira.csv` do projeto `REF`.
Os números `REF-...` são as chaves reais do Jira. O planejamento pode ser ajustado pela equipe durante as revisões.

## Escopo do produto

São 9 Epics, 18 Histórias e 32 Tarefas. As 50 Histórias/Tarefas estão distribuídas em seis sprints. A prioridade reproduz o campo da exportação; a ordenação por sprint é o plano de entrega.

## Sprint 1 — Requisitos e estrutura inicial (16 a 19/11/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-10 | Story | S1 — Como equipe, quero definir os perfis e o escopo do Refeição Solidária | High |
| REF-11 | Story | S1 — Como visitante, quero conhecer a proposta da plataforma | Medium |
| REF-12 | Task | S1 — Especificar visão, requisitos e regras de trabalho | High |
| REF-13 | Task | S1 — Inicializar front-end React e páginas públicas | High |
| REF-14 | Task | S1 — Inicializar API Spring Boot e estrutura de camadas | High |
| REF-15 | Task | S1 — Desenhar modelo inicial e configurar infraestrutura de banco | High |
| REF-16 | Task | S1 — Definir plano de testes e checklist inicial | Medium |

## Sprint 2 — Cadastros e acesso (20 a 22/11/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-17 | Story | S2 — Como visitante, quero me cadastrar conforme meu perfil | High |
| REF-18 | Story | S2 — Como usuário, quero entrar em modo demonstração e manter minha sessão | High |
| REF-19 | Story | S2 — Como equipe, quero guardar os dados básicos de usuários | High |
| REF-20 | Task | S2 — Verificar cadastro e login demonstrativo | High |
| REF-21 | Task | S2 — Detalhar requisitos de cadastros e conduzir Sprint 2 | High |
| REF-22 | Task | S2 — Implementar cadastro por perfil e login local | High |
| REF-23 | Task | S2 — Criar domínio e repositório de usuários | High |
| REF-24 | Task | S2 — Configurar datasource e restrições de usuário | High |

## Sprint 3 — Modelagem e interfaces (23 a 25/11/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-25 | Story | S3 — Como usuário, quero navegar em rotas apropriadas ao meu perfil | High |
| REF-26 | Story | S3 — Como equipe, quero persistir doações e solicitações relacionadas a usuários | High |
| REF-27 | Story | S3 — Como usuário, quero acessar painéis organizados de acordo com meu papel | Medium |
| REF-28 | Task | S3 — Modelar doações e solicitações com enums JPA | High |
| REF-29 | Task | S3 — Testar navegação, papéis e persistência de sessão | High |
| REF-30 | Task | S3 — Documentar fluxos e contratos entre web e API | High |
| REF-31 | Task | S3 — Criar layout compartilhado e rotas protegidas por perfil | High |
| REF-32 | Task | S3 — Criar repositórios de doação e solicitação | High |

## Sprint 4 — Doações e anúncios (26 a 28/11/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-33 | Story | S4 — Como doador, quero publicar e gerenciar anúncios de alimentos | High |
| REF-34 | Story | S4 — Como consumidor da API, quero cadastrar e consultar doações | High |
| REF-35 | Story | S4 — Como equipe, quero manter a disponibilidade coerente com o status da doação | High |
| REF-36 | Task | S4 — Implementar serviço e controlador REST de doações | High |
| REF-37 | Task | S4 — Conferir persistência e consultas das doações | Medium |
| REF-38 | Task | S4 — Testar cadastro, consulta e cancelamento na API de doações | High |
| REF-39 | Task | S4 — Gerenciar Sprint 4 e registrar andamento e revisão | Medium |
| REF-40 | Task | S4 — Construir formulário e gestão local de anúncios | High |

## Sprint 5 — Solicitações e recebimento (29/11 a 01/12/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-41 | Story | S5 — Como instituição, quero procurar ofertas e solicitar alimentos | High |
| REF-42 | Story | S5 — Como doador, quero analisar solicitações recebidas | High |
| REF-43 | Story | S5 — Como instituição, quero confirmar o recebimento da doação | Medium |
| REF-44 | Task | S5 — Criar fluxo institucional e ações de recebimento na interface | High |
| REF-45 | Task | S5 — Implementar serviço e endpoints de solicitações | High |
| REF-46 | Task | S5 — Validar relacionamentos e transações de solicitações | High |
| REF-47 | Task | S5 — Testar jornadas de solicitações no web e na API | High |
| REF-48 | Task | S5 — Coordenar Sprint 5 e registrar a arquitetura de integração | High |

## Sprint 6 — Transporte, administração e entrega (02 a 06/12/2026)

| Chave | Tipo | Atividade | Prioridade |
|---|---|---|---|
| REF-49 | Story | S6 — Como voluntário, quero acompanhar coletas e entregas | High |
| REF-50 | Story | S6 — Como administrador, quero acompanhar cadastros, denúncias e relatórios | High |
| REF-51 | Story | S6 — Como avaliador, quero executar e verificar os principais fluxos da entrega | High |
| REF-52 | Story | S6 — Como usuário, quero consultar e ajustar as informações do meu perfil | Medium |
| REF-53 | Task | S6 — Consolidar documentação e roteiro de apresentação | High |
| REF-54 | Task | S6 — Validar infraestrutura final e documentação do banco | Medium |
| REF-55 | Task | S6 — Executar smoke tests e homologar a versão final | High |
| REF-56 | Task | S6 — Implementar painéis de voluntários e fluxo de transportes | High |
| REF-57 | Task | S6 — Implementar painel administrativo e configurações do perfil | High |
| REF-58 | Task | S6 — Finalizar atualização e cancelamento de doações na API | High |
| REF-59 | Task | S6 — Finalizar recusa e cancelamento de solicitações na API | High |

## Rodízio de funções

| Integrante | S1 | S2 | S3 | S4 | S5 | S6 |
|---|---|---|---|---|---|---|
| Gabriel Januário | Gerente | Testes | Banco | Back-end | Front-end | Gerente |
| Robson Magalhães | Front-end | Gerente | Testes | Banco | Back-end | Front-end |
| Matheus Eduardo | Back-end | Front-end | Gerente | Testes | Banco | Back-end |
| Jefferson Lima | Banco | Back-end | Front-end | Gerente | Testes | Banco |
| Nelson Nunes | Testes | Banco | Back-end | Front-end | Gerente | Testes |

**Importante:** a pessoa que acompanha uma Story não é necessariamente quem implementa a funcionalidade. A execução técnica é acompanhada pelas Tasks e pelos Pull Requests.
