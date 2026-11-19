# Banco local — PostgreSQL e pgAdmin

**Task:** REF-15. O ambiente aqui é apenas para desenvolvimento local.

## Requisitos

Docker Desktop com Docker Compose habilitado.

## Subir os serviços

Na raiz do repositório `refeicao-solidaria-api`:

```bash
docker compose config
docker compose up -d
docker compose ps
```

O PostgreSQL usa a porta `5444` no computador e a porta `5432` dentro da rede Docker. O pgAdmin estará em `http://localhost:5051`.

### Conexão no computador

- Host: `localhost`
- Porta: `5444`
- Banco: `refeicaosolidaria`
- Usuário padrão local: `postgres`
- Senha padrão local: `postgres`

No pgAdmin rodando no Compose, use o host `db` e porta `5432`, e faça login com `admin@local.dev` / `admin`, salvo se as variáveis de ambiente forem alteradas.

**Aviso:** essas credenciais são padrões de demonstração local. Nunca use essas senhas em produção nem armazene credenciais reais no Git.

## Verificar

```bash
docker compose exec db pg_isready -U postgres -d refeicaosolidaria
docker compose logs --tail=30 db
```

Para parar sem perder dados: `docker compose down`. Evite `down -v`, pois remove o volume e os dados locais.

A modelagem JPA e as tabelas da aplicação serão desenvolvidas nas sprints posteriores. Na Sprint 1, é suficiente levantar e validar conceitualmente o modelo e testar a infraestrutura.
