# REF-24 — Datasource e restrições da tabela usuarios

**Responsável:** Nelson | **Sprint 2**

## 1. Preparar o PostgreSQL

A configuração reutiliza o `docker-compose.yml` entregue na REF-15:

```bash
docker compose up -d
docker compose ps
docker compose exec db pg_isready -U postgres -d refeicaosolidaria
```

Conexão da API na máquina: `localhost:5444`, banco `refeicaosolidaria`.
As credenciais padrão do Compose são **exclusivas de desenvolvimento local**. Para usar outras, configure `DB_USER` e `DB_PASSWORD` no ambiente, sem colocá-las em commits.

## 2. Executar a aplicação

**Dependência:** primeiro é necessário integrar a REF-23 (entidade `Usuario` e dependências JPA/PostgreSQL no `pom.xml`).

```bash
./mvnw spring-boot:run
```

No Windows, usar `mvnw.cmd spring-boot:run`. Se houver erro de conexão, confira se o container está rodando e se a porta 5444 não está ocupada.

## 3. Verificar a tabela e unicidade

No pgAdmin (host `db`, porta `5432`) ou psql, execute:

```sql
SELECT column_name, data_type, is_nullable
FROM information_schema.columns
WHERE table_schema = 'public' AND table_name = 'usuarios'
ORDER BY ordinal_position;

SELECT indexname, indexdef
FROM pg_indexes
WHERE schemaname = 'public' AND tablename = 'usuarios';
```

Os índices de e-mail e documento devem aparecer como **UNIQUE**. A entidade também precisa oferecer os quatro tipos no enum `TipoUsuario`.

Para confirmar a restrição por inserção, use dois registros fictícios com o mesmo e-mail ou o mesmo documento em transações de teste; a segunda inserção deverá falhar por violação de unicidade. Não utilize dados de pessoas reais. O teste deve acontecer somente em banco descartável de desenvolvimento.

## 4. Resultado da verificação (preencher após executar)

- Data / responsável: `22/11/2026 — Nelson Nunes`
- `docker compose ps`: `refeicao-solidaria-api-db-1 (postgres:15-alpine, Up healthy, 0.0.0.0:5444->5432/tcp) e refeicao-solidaria-api-pgadmin-1 (dpage/pgadmin4:latest, Up, 0.0.0.0:5051->80/tcp); pg_isready confirmou /var/run/postgresql:5432 - accepting connections`
- Aplicação iniciou e conectou ao banco?: `BLOQUEADO / AGUARDANDO REF-23 — application.properties configurado para jdbc:postgresql://localhost:5444/refeicaosolidaria com ddl-auto=update; a inicialização com DataSource/Hibernate depende da integração das dependências spring-boot-starter-data-jpa e postgresql no pom.xml (Task REF-23 — Jefferson)`
- Tabela `usuarios` criada?: `NÃO EXECUTADO / AGUARDANDO REF-23 — depende da integração da entidade Usuario (Task REF-23)`
- Restrição UNIQUE de `email` encontrada?: `NÃO EXECUTADO / AGUARDANDO REF-23 — será verificada via pg_indexes assim que a entidade Usuario (REF-23) gerar o DDL da tabela usuarios`
- Restrição UNIQUE de `documento` encontrada?: `NÃO EXECUTADO / AGUARDANDO REF-23 — será verificada via pg_indexes assim que a entidade Usuario (REF-23) gerar o DDL da tabela usuarios`
- Resultado do teste de duplicidade (se executado): `NÃO EXECUTADO / AGUARDANDO REF-23`
- Erros ou impedimentos: `PostgreSQL (porta 5444) e pgAdmin (porta 5051) estão operacionais via Docker Compose; a geração automática da tabela usuarios pelo Hibernate aguarda o merge da Task REF-23 (Jefferson — entidade Usuario, enum TipoUsuario, UsuarioRepository e dependências JPA/PostgreSQL no pom.xml)`
- Evidência (captura / commit / PR): `Branch chore/REF-24-datasource-usuarios — configuração em src/main/resources/application.properties e verificação do container PostgreSQL 15.19`

**Não marcar esses itens como executados antes de testar.** `ddl-auto=update` serve para desenvolvimento, não substitui migração versionada de banco.
