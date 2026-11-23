# REF-21 — Requisitos de cadastro e acesso

Sprint 2 — Refeição Solidária

## Objetivo

Nesta sprint, permitir escolher o perfil no cadastro e usar o site em **modo demonstrativo**. O login real com usuários persistidos, senha protegida e autorização no servidor não faz parte da REF-22.

## Perfis

| Perfil | Campos comuns | Campos adicionais na interface desta sprint |
|---|---|---|
| Doador | Nome, e-mail, telefone, endereço, documento, senha de demonstração | Tipo de doador (pessoa/empresa), frequência |
| Instituição | Nome, e-mail, telefone, endereço, documento, senha de demonstração | Razão social, responsável legal |
| Voluntário | Nome, e-mail, telefone, endereço, documento, senha de demonstração | Disponibilidade, possui veículo |
| Administrador | Nome, e-mail, telefone, endereço, documento, senha de demonstração | Departamento; perfil apenas para teste da interface |

Campos marcados como obrigatórios precisam ser preenchidos. Verificar formato de e-mail, mínimo de 6 caracteres na senha de demonstração e igualdade entre senha e confirmação. Não salvar senha no `localStorage`.

## Comportamento esperado

1. A página `/cadastro` muda os campos de acordo com o perfil selecionado.
2. Ao concluir o cadastro demonstrativo, o navegador mantém uma sessão simples com nome, e-mail e perfil.
3. A página `/login` permite entrar com dados fictícios e perfil escolhido, sem consultar a API.
4. Atualizar a página não deve apagar a sessão; clicar em **Sair** deve encerrá-la.
5. A área `/area-demo` deve redirecionar visitantes sem sessão para o login.
6. A área demonstra o perfil; painéis completos e rotas protegidas por perfil ficam para a Sprint 3.

## Modelo inicial da API (REF-23 e REF-24)

O back-end terá a entidade `Usuario` e o enum `TipoUsuario` com `DOADOR`, `INSTITUICAO`, `VOLUNTARIO`, `ADMIN`. E-mail e documento devem ser únicos no banco de dados. Isso **não significa** que a API de cadastro esteja pronta nesta sprint.

## Informações do formulário do professor

O professor pediu acesso por **e-mail e senha**, CPF/CNPJ, endereço, tipo de doador e documentos de comprovação. A Sprint 2 cobre parcialmente esses requisitos, por ser um protótipo de cadastro/login. Pontos ainda **não implementados**: validação real de CPF/CNPJ, anexos, aprovação de cadastro e autenticação segura com senha no back-end. Não apresentar o protótipo como sistema pronto para uso público.

Também foi informado que pessoas físicas podem ser beneficiárias. O planejamento atual concentra as solicitações nas instituições; isso permanece uma **diferença de escopo a esclarecer**, não uma funcionalidade aprovada para esta sprint.

## Critérios para validar as Stories

- **REF-17:** formulário muda por perfil; valida os dados básicos na interface.
- **REF-18:** login demonstrativo, sessão após atualizar e botão Sair; visitante sem sessão não entra na área demonstrativa.
- **REF-19:** entidade JPA, enum de perfis e repositório; unicidade de e-mail e documento no PostgreSQL.

A gerência só marca as Stories concluídas após receber os resultados reais do front-end, back-end, banco e testes.
