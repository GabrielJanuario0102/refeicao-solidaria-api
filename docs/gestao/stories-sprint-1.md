# Sprint 1 — Critérios de aceitação e validação das Stories

Os textos abaixo preservam os objetivos do CSV e detalham como verificar o resultado. A descrição original das Stories do Jira não precisa ser substituída; pode ser complementada.

## Story REF-10 — S1 | Como equipe, quero definir os perfis e o escopo do Refeição Solidária

**Objetivo do CSV:** Registrar as jornadas de doador, instituição, voluntário e administrador.

**Critério original do CSV:** Documento identifica objetivos, perfis, regras e limites da primeira versão.

### Critérios detalhados propostos

- [ ] Descrição do problema e da proposta de valor do Refeição Solidária.
- [ ] Quatro tipos de usuário identificados (`DOADOR`, `INSTITUICAO`, `VOLUNTARIO`, `ADMIN`), cada qual com sua jornada principal.
- [ ] Visitante identificado como ator público, sem ser confundido com tipo de usuário cadastrado.
- [ ] Funcionalidades previstas na primeira versão organizadas por sprint.
- [ ] Regras e limites declarados, distinguindo comportamento local/demonstrativo de API persistida.
- [ ] Documento revisado pela equipe e linkado no Jira.

**Evidência:** `docs/requisitos/visao-e-escopo.md`, revisão no PR e comentário na Story.

**Responsável pelo acompanhamento:** Gabriel. **Execução documental:** Task S1 de Gabriel (REF-12).

## Story REF-11 — S1 | Como visitante, quero conhecer a proposta da plataforma

**Objetivo do CSV:** Acessar início, sobre e como funciona.

**Critério original do CSV:** As três páginas públicas exibem o propósito da plataforma e links de navegação.

### Critérios detalhados propostos

- [ ] A rota `/` abre sem login e apresenta nome, missão e chamada para ação.
- [ ] A rota `/sobre` abre sem login e explica a finalidade da plataforma.
- [ ] A rota `/como-funciona` abre sem login e apresenta o fluxo doadores → instituições → voluntários.
- [ ] Existe navegação visível entre as páginas públicas (na versão de referência, o Header oferece Sobre e Como Funciona, e a marca retorna ao início).
- [ ] Há caminhos para cadastro e login, ainda que o cadastro funcional esteja planejado para S2.
- [ ] A interface é utilizável em viewport desktop e mobile, conforme avaliação manual.
- [ ] Robson demonstra a aplicação rodando; Gabriel valida e registra evidências.

**Evidência:** PR da Task S1 de Robson (REF-13), execução local e capturas ou registro de teste com resultados.

**Responsável pelo acompanhamento:** Gabriel. **Responsável pela implementação:** Robson.

### Roteiro de validação

1. Iniciar a aplicação React conforme README.
2. Abrir `http://localhost:5173/` (ou a porta informada pelo Vite) em janela sem login.
3. Verificar título, propósito e links principais.
4. Acessar `/sobre` pelo menu e validar o conteúdo.
5. Acessar `/como-funciona` pelo menu e validar três etapas (doador, instituição, voluntário).
6. Usar a marca/logo para voltar a `/`.
7. Verificar visualização em largura de celular e desktop.
8. Registrar resultado real, pendências e link do PR no Jira; concluir a Story apenas se os critérios forem atendidos.

**Atenção:** S1 exige páginas e navegação públicas; o cadastro/login funcional está previsto em S2.
