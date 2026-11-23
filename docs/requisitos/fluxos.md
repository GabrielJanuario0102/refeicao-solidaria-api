# REF-30 — Fluxos previstos do Refeição Solidária

**Sprint:** 3 | **Gerência:** Matheus  
**Base:** requisitos da REF-12, login demonstrativo REF-22 e modelo de usuários REF-23.

## Participantes

- **Doador:** cadastra ofertas de alimentos (Sprint 4).
- **Instituição:** consulta ofertas e envia solicitações (Sprint 5).
- **Voluntário:** acompanha coletas e transporte (Sprint 6).
- **Administrador:** acompanha usuários, denúncias e relatórios (Sprint 6).

## Fluxo 1 — Publicação de doação (próxima sprint)

1. O doador entra na área correspondente ao seu perfil.
2. Informa alimento, quantidade, validade, conservação, ponto e horário de retirada.
3. A API receberá dados para persistir uma `Doacao` vinculada ao `Usuario` doador.
4. A doação começa em `DISPONIVEL` e pode mudar de status conforme solicitações.

**Na Sprint 3:** somente modelo JPA e páginas de painel demonstrativas. O formulário de anúncio e seu CRUD ainda não fazem parte desta entrega.

## Fluxo 2 — Solicitação de doação (Sprint 5)

1. A instituição consulta ofertas elegíveis.
2. Envia a quantidade desejada para uma doação.
3. A API registra `Solicitacao` com `PENDENTE`, ligada à doação e à instituição.
4. O doador avalia; a solicitação poderá ser `APROVADA`, `RECUSADA` ou `CANCELADA`.
5. A disponibilidade da doação deverá ser atualizada de forma consistente.

**Na Sprint 3:** apenas relacionamentos e enums, sem telas completas nem regras de transação.

## Fluxo 3 — Retirada e transporte (Sprint 6)

1. Uma solicitação aprovada poderá originar acompanhamento da retirada.
2. O voluntário acompanhará os dados de coleta e entrega previstos.
3. O fluxo final deve registrar confirmação de recebimento e histórico.

**Na Sprint 3:** o painel do voluntário é apenas informativo, sem agendamento ou entrega funcional.

## Navegação e sessão nesta sprint

- Visitas a `/`, `/sobre`, `/como-funciona` não exigem login.
- O login e a sessão atual são **demonstrativos em `localStorage`**.
- O front-end apresenta `/painel` e quatro painéis por perfil.
- Um usuário demonstrativo que tentar painel de outro papel verá acesso negado.
- A tela de aprovação pendente é demonstrativa; ainda não consulta um serviço de aprovação.
- Controle real de acesso e autenticação do servidor permanecem pendentes.

## Ajustes futuros de escopo

O formulário do professor inclui distribuição de refeições a beneficiários, controle de locais e horários. O planejamento inicial prioriza intermediação entre doadores e instituições. Manter essa diferença registrada para avaliação; ela não significa que tais fluxos já foram implementados.
