# Sprint 2 — Cadastros e acesso demonstrativo

**Período planejado:** 20 a 22 de novembro de 2026  
**Gerente:** Robson  
**Objetivo:** introduzir o cadastro por perfil, sessão local demonstrativa e modelo inicial de usuários na API.

## Distribuição no Jira

| Item | Responsável | Entrega esperada |
|---|---|---|
| REF-17 — Story | Robson acompanha | Cadastro por perfil validado |
| REF-18 — Story | Robson acompanha | Login e sessão demonstrativa validados |
| REF-19 — Story | Robson acompanha | Entidade, enum e repositório disponíveis |
| REF-20 — Testes | Gabriel | Relatório com testes positivos, negativos e impedimentos |
| REF-21 — Gerência | Robson | Requisitos e acompanhamento da sprint |
| REF-22 — Front-end | Matheus | Cadastro.tsx, Login.tsx, AuthContext e integração com rotas |
| REF-23 — Back-end | Jefferson | Usuario, TipoUsuario, UsuarioRepository, dependência JPA |
| REF-24 — Banco | Nelson | Datasource PostgreSQL e registro das restrições |

## Dependências e ordem sugerida

1. Conferir se a `main` contém a Sprint 1, em ambos os repositórios.
2. Matheus implementa o cadastro e login em branch própria; Gabriel prepara roteiro de testes e depois executa na versão integrada.
3. Jefferson adiciona entidade/repositório JPA e dependências Maven; Nelson valida a conexão usando o Compose da Sprint 1. Para testar o banco é preciso ter ambas as mudanças.
4. Pedir revisão de cada PR e registrar no Jira as evidências dos critérios de aceitação.
5. Concluir as Stories somente quando os resultados estiverem verificados; encerrar a sprint após a revisão da equipe.

## Check-in do gerente (preencher no Jira)

- Data:
- Itens concluídos:
- Itens em andamento:
- Impedimentos:
- PRs revisados:
- Casos de teste executados:

## Fora do escopo

Sem autenticação real via API, sem painéis completos por papel, sem CRUD de doações, sem transporte e sem módulo administrativo. Não registrar como concluídos recursos futuros.
