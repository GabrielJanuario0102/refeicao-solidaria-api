# Contribuição — FIREFLYTECH

Este documento estabelece o fluxo combinado para o projeto Refeição Solidária. O uso das convenções deve ser confirmado pela equipe.

## Fluxo de trabalho

1. Verifique a Task no projeto `REF` no Jira e leia seus critérios de aceitação.
2. Atualize sua `main`: `git switch main` e `git pull origin main`.
3. Crie uma branch com o código da atividade, por exemplo `feat/REF-13-paginas-publicas`.
4. Implemente, revise, execute os comandos aplicáveis e registre seus resultados reais.
5. Faça commit com a chave da atividade, por exemplo `feat(REF-13): adiciona paginas publicas`.
6. Envie a branch, abra Pull Request para `main` e peça revisão de outro integrante.
7. Corrija o que for necessário; depois da aprovação, integre o PR e vincule a evidência ao Jira.

## Convenções

- Branches: `feat/REF-N-...`, `docs/REF-N-...`, `chore/REF-N-...`, `test/REF-N-...`.
- Commits: `feat(REF-N): ...`, `docs(REF-N): ...`, `fix(REF-N): ...`, `test(REF-N): ...`.
- Cada PR deve indicar objetivo, arquivos alterados, comandos executados e resultados observados.
- Não commitar `node_modules`, `target`, `.env`, credenciais reais, ZIPs, bancos locais ou diretórios `.git` copiados.
- Os commits devem corresponder ao trabalho efetivamente revisado ou realizado pelo autor do commit. Materiais de apoio não equivalem a implementação validada.

## Revisão

- O responsável técnico valida sua Task; outro integrante revisa quando possível.
- Gabriel acompanha `REF-10` e `REF-11` na Sprint 1, mas `REF-11` depende da página pública feita na Task `REF-13`.
- Uma Story só é concluída depois de verificados seus critérios de aceitação, mesmo que a Task esteja finalizada.
