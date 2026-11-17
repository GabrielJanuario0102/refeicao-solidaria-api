# Refeição Solidária — Visão, perfis, escopo e regras

**Equipe:** FIREFLYTECH  
**Sprint:** 1 — Requisitos e estrutura inicial (16 a 19/11/2026)  
**Responsável pela elaboração e revisão:** Gabriel Januário — Gerente da Sprint 1  
**Status:** Proposta para revisão da equipe; não representa aprovação nem implementação concluída.

## 1. Visão do produto

O Refeição Solidária é uma plataforma social que busca reduzir o desperdício de alimentos e apoiar instituições comunitárias, conectando doadores de refeições ou excedentes alimentares, instituições que necessitam desses alimentos e voluntários que podem auxiliar no transporte. Administradores acompanham cadastros, denúncias e informações gerais da operação.

O produto é apresentado aos visitantes como uma ponte entre doadores, instituições e voluntários. A proposta pública deve explicar o objetivo do serviço e como participar.

## 2. Perfis de usuário

| Perfil | Papel no produto | Jornada principal planejada |
|---|---|---|
| Visitante (sem autenticação) | Conhecer o projeto | Consultar Início, Sobre e Como Funciona; acessar cadastro/login |
| Doador (`DOADOR`) | Ofertar alimentos/refeições | Cadastrar-se, publicar anúncio, consultar doações e analisar solicitações |
| Instituição (`INSTITUICAO`) | Solicitar alimentos para atendimento comunitário | Cadastrar-se, aguardar aprovação quando aplicável, localizar ofertas, solicitar e confirmar recebimento |
| Voluntário (`VOLUNTARIO`) | Apoiar a logística | Acompanhar transportes, assumir coletas e registrar etapas de entrega na demonstração web |
| Administrador (`ADMIN`) | Administrar a plataforma | Acompanhar cadastros, denúncias e relatórios; gerenciar situações previstas na interface |

**Nota:** O visitante é uma condição de acesso público, não um dos quatro tipos persistidos de usuário. A enumeração `TipoUsuario` da API e o tipo `TipoUsuario` do front-end contêm apenas DOADOR, INSTITUICAO, VOLUNTARIO e ADMIN.

## 3. Requisitos funcionais planejados

- **RF01 — Páginas públicas:** apresentar o projeto em `/`, `/sobre` e `/como-funciona` sem exigir login.
- **RF02 — Cadastro por perfil:** oferecer formulário conforme DOADOR, INSTITUICAO, VOLUNTARIO ou ADMIN; no front-end de referência, a autenticação é demonstrativa/local.
- **RF03 — Acesso por papel:** direcionar cada perfil a seu painel e impedir navegação comum em painéis alheios na interface.
- **RF04 — Doações:** permitir que doadores publiquem e gerenciem anúncios e disponibilizar operações REST de cadastro/consulta e manutenção previstas no backlog.
- **RF05 — Solicitações:** permitir que instituições solicitem ofertas e que doadores analisem solicitações; prever confirmação de recebimento na interface.
- **RF06 — Transportes:** mostrar transportes e permitir a atuação demonstrativa do voluntário nas etapas de coleta/entrega.
- **RF07 — Administração:** fornecer painéis de cadastros, denúncias, anúncios e relatórios.
- **RF08 — Perfil:** permitir consulta e atualização demonstrativa de informações do usuário.
- **RF09 — Persistência:** manter os dados de domínio da API em PostgreSQL; o projeto web de referência utiliza estado/localStorage em fluxos demonstrativos.

## 4. Regras de negócio identificadas nos projetos de referência

- Usuários possuem um tipo entre quatro papéis (`DOADOR`, `INSTITUICAO`, `VOLUNTARIO`, `ADMIN`).
- A entidade de usuário da API inclui nome, documento, e-mail, senha, telefone, endereço, tipo e indicador de aprovação. Documento e e-mail foram modelados como únicos na entidade.
- O cadastro web de instituição começa como **não aprovado**; a interface possui uma tela de espera de aprovação para usuários nessa condição.
- No modelo da API, uma doação pertence a um doador e registra alimento, quantidade disponível, validade de consumo, conservação, local e limite de retirada.
- Os status previstos na entidade de doação são `DISPONIVEL`, `PARCIALMENTE_RESERVADA`, `TOTALMENTE_RESERVADA`, `AGUARDANDO_RETIRADA`, `CONCLUIDA` e `CANCELADA`.
- No modelo da API, uma solicitação relaciona uma doação e uma instituição e possui quantidade solicitada; os status são `PENDENTE`, `APROVADA`, `RECUSADA` e `CANCELADA`.
- Na interface web, há estados demonstrativos adicionais para pedidos e transportes. Não assumir que todos esses estados já estejam expostos pela API REST.

Essas regras descrevem estrutura e fluxos observados; regras adicionais de validação devem ser confirmadas em testes e acordadas no desenvolvimento.

## 5. Escopo por sprint

| Sprint | Datas de 2026 | Entrega planejada |
|---|---|---|
| S1 — Requisitos | 16–19/11 | Documentação, estrutura React/API, modelo conceitual e testes iniciais |
| S2 — Cadastros | 20–22/11 | Cadastro por perfil, login demonstrativo e domínio de usuários |
| S3 — Modelagem e interface | 23–25/11 | Entidades e repositórios; navegação e painéis por perfil |
| S4 — Desenvolvimento | 26–28/11 | Anúncios e API de doações |
| S5 — Integração | 29/11–01/12 | Solicitações, aprovações e recebimentos previstos |
| S6 — Entrega | 02–06/12 | Voluntariado, administração, complementos da API, testes e documentação final |

A Sprint 1 **não exige** os painéis completos, a autenticação definitiva, o fluxo completo de doações ou toda a API pronta. Para a Story da página pública, ela exige as três páginas navegáveis e conteúdo introdutório.

## 6. Limites e premissas da primeira versão

- Os projetos enviados são **referência de funcionalidades**, não prova de que a nova implementação esteja pronta ou testada.
- O front-end de referência usa autenticação/dados locais demonstrativos; não declarar que existe autenticação de produção, login seguro pelo back-end ou sincronização HTTP completa com a API.
- A API de referência implementa entidades e operações de doações/solicitações; o módulo de transporte na web não implica uma API de transporte concluída.
- Relatórios, números exemplificativos e conteúdo de demonstração não devem ser apresentados como métricas reais da plataforma.
- Os registros criados em ambiente demonstrativo não garantem persistência multiusuário ou segurança de produção.
- Requisitos de segurança, privacidade e validações necessárias para uso real devem ser tratados antes de qualquer disponibilização pública.

## 7. Critérios de aceitação — Story de perfis e escopo

- [ ] A visão do produto está descrita em linguagem clara.
- [ ] Os quatro perfis de usuário estão definidos, com objetivos e ações principais.
- [ ] As jornadas de doações, solicitações, transporte e administração estão identificadas.
- [ ] O escopo da primeira versão está separado das funcionalidades futuras ou demonstrativas.
- [ ] Limites e premissas técnicas estão registrados.
- [ ] Equipe revisou o documento e registrou seu aceite no Jira ou no PR.

## 8. Referências internas verificadas

- Jira REF: Stories `REF-10`, `REF-11` e Task `REF-12`; planejamento validado com a exportação `Jira.csv`.
- Front-end enviado: `src/routes/index.tsx`, `src/contexts/AuthContext.tsx`, `src/contexts/CicloDoacaoContext.tsx`, `src/contexts/TransporteContext.tsx`, `src/pages/Cadastro.tsx`.
- API enviada: `domain/TipoUsuario.java`, `domain/Usuario.java`, `domain/Doacao.java`, `domain/Solicitacao.java`, `domain/StatusDoacao.java`, `domain/StatusSolicitacao.java`.
