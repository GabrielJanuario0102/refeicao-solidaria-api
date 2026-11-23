# Sprint 3 — Relatório de encerramento

**Projeto:** FIREFLYTECH — Refeição Solidária  
**Período:** 23 a 25/11/2026  
**Gerente da sprint:** Matheus  
**Status do relatório:** Concluída — cenário de encerramento ilustrativo

## Objetivo alcançado

Foi estruturada a modelagem de doações e solicitações, incluindo os relacionamentos com usuários, os estados de cada operação e os repositórios JPA. Na aplicação web, foram organizados os painéis e a navegação por perfil, com layout compartilhado e proteção de rotas. Os fluxos de integração entre frontend e API foram documentados.

## Entregas da sprint

| Item | Responsável | Entrega realizada | Situação no cenário |
|---|---|---|---|
| REF-25 (Story) | Matheus — acompanhamento | Navegação direcionada conforme o perfil do usuário | Concluída |
| REF-26 (Story) | Matheus — acompanhamento | Modelo de doações e solicitações relacionado aos usuários, com repositórios JPA | Concluída |
| REF-27 (Story) | Matheus — acompanhamento | Painéis por perfil e layout de navegação compartilhado | Concluída |
| REF-28 | Gabriel | Entidades `Doacao` e `Solicitacao`, enums de status e relacionamentos JPA | Concluída |
| REF-29 | Robson | Roteiro de testes de navegação, papéis e persistência de sessão | Concluída |
| REF-30 | Matheus | Documentação dos fluxos de uso e dos contratos entre web e API | Concluída |
| REF-31 | Jefferson | Layout compartilhado, rotas protegidas e painéis demonstrativos | Concluída |
| REF-32 | Nelson | Repositórios JPA de doação e solicitação | Concluída |

## Resumo das atividades por responsável

**Gabriel — Banco de dados (REF-28):** concluiu a definição das entidades de doação e solicitação, seus atributos, relacionamentos com usuários e enums de status. A modelagem foi organizada para uso com Hibernate/JPA e PostgreSQL.

**Robson — Testes (REF-29):** organizou e concluiu a documentação dos cenários de validação de acesso às rotas, restrições por papel, redirecionamentos e manutenção da sessão. No cenário de encerramento, as verificações previstas foram consideradas satisfatórias.

**Matheus — Gerência e documentação (REF-30):** consolidou os fluxos de navegação e os contratos previstos entre frontend e API, acompanhou as dependências técnicas e encerrou as três Stories da sprint no cenário apresentado.

**Jefferson — Frontend (REF-31):** implementou a estrutura de layout compartilhado, a navegação por perfil, os painéis demonstrativos e os componentes de proteção de rotas.

**Nelson — Persistência (REF-32):** implementou os repositórios Spring Data JPA para doações e solicitações, permitindo consultas relacionadas a status, usuários e doações.

## Integração das entregas

A implementação considerou a autenticação e a sessão local da REF-22 como base para a navegação protegida. As entidades da REF-28 foram utilizadas como referência para os repositórios da REF-32. A REF-31 forneceu as rotas e os painéis analisados nos cenários da REF-29. A documentação da REF-30 consolidou os fluxos e delimitou os contratos previstos para as próximas sprints.

**Escopo da Sprint 3:** os painéis são demonstrativos. O CRUD completo de doações, as solicitações operacionais e a integração integral com a API permanecem no planejamento das sprints seguintes; não são tratados como entregas desta sprint.

## Check-in de encerramento — 25/11/2026

- **Situação geral:** todas as cinco Tasks e três Stories encerradas no cenário de referência.
- **Revisão de código:** entregas consideradas revisadas e integradas para fins deste modelo de encerramento; identificadores de PR não são informados porque não foram disponibilizados.
- **Testes:** cenários de acesso por perfil, bloqueio de rotas, redirecionamento e sessão considerados atendidos no cenário ilustrativo; não há logs ou relatórios de execução anexados.
- **Persistência:** mapeamentos JPA e repositórios considerados consistentes com o escopo proposto; a execução real das operações no PostgreSQL não foi comprovada neste documento.
- **Impedimentos ao encerramento:** nenhum impedimento pendente no cenário descrito.
- **Stories aceitas:** REF-25, REF-26 e REF-27.

## Critérios de aceite

- [x] Entidades e enums de doação e solicitação definidos.
- [x] Relacionamentos com usuários modelados em JPA.
- [x] Repositórios de doação e solicitação implementados.
- [x] Layout compartilhado e painéis demonstrativos organizados.
- [x] Rotas protegidas e redirecionamentos por perfil definidos.
- [x] Cenários de teste de navegação e sessão documentados.
- [x] Fluxos e contratos entre web e API documentados.
- [x] Stories REF-25, REF-26 e REF-27 encerradas no cenário apresentado.

## Resultado final

A Sprint 3 foi encerrada com o modelo de dados de doações e solicitações estruturado e a navegação demonstrativa por perfis organizada. As entregas formam a base técnica para a Sprint 4, voltada ao desenvolvimento das funcionalidades de doações. O objetivo planejado foi considerado alcançado no cenário de encerramento aqui documentado.