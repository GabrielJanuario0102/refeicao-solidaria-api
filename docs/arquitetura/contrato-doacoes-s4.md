# Contrato de doações — Sprint 4

**Responsável:** Gabriel · REF-36  
**API:** `http://localhost:8080/api/doacoes`

## Rotas

| Método | Rota | Uso | Resposta de sucesso |
|---|---|---|---|
| `POST` | `/api/doacoes` | Publicar doação | `201` e cabeçalho `Location` |
| `GET` | `/api/doacoes` | Listar | `200` |
| `GET` | `/api/doacoes?status=DISPONIVEL&idDoador=1` | Filtrar pelos dois campos | `200` |
| `GET` | `/api/doacoes/{id}` | Consultar uma | `200` |
| `PUT` | `/api/doacoes/{id}` | Editar publicação disponível | `200` |
| `DELETE` | `/api/doacoes/{id}` | Cancelar com justificativa | `200` |

**Exemplo de publicação** (substituir as datas por horários futuros ao testar):

```json
{
  "idDoador": 1,
  "nomeAlimento": "Marmitas caseiras",
  "descricao": "Porções embaladas individualmente",
  "quantidadeDisponivel": 20,
  "dataHoraPreparo": "2026-12-05T10:00:00",
  "validadeConsumo": "2026-12-05T20:00:00",
  "armazenamentoConservacao": "Manter refrigerado até a retirada",
  "declaracaoDoadorAceite": true,
  "localRetirada": "Rua das Flores, 120",
  "horarioLimiteRetirada": "2026-12-05T18:00:00",
  "fotoUrl": null
}
```

**Cancelamento:** `DELETE /api/doacoes/1` com `Content-Type: application/json` e corpo `{"motivo":"Problema de conservação"}`.

## Regras

- Cadastro exige usuário do tipo `DOADOR`, quantidade positiva, conservação, aceite, local e datas futuras.
- Retirada não pode ocorrer depois da validade; o horário de preparo não pode ultrapassá-la.
- Status inicial `DISPONIVEL` é definido no serviço. Não é aceito status enviado pelo cliente.
- Edição liberada somente em `DISPONIVEL`, sem transferência para outro doador.
- Cancelamento liberado em `DISPONIVEL` ou `PARCIALMENTE_RESERVADA`; solicitações `PENDENTE` e `APROVADA` são canceladas na mesma transação e recebem a justificativa.
- Status `TOTALMENTE_RESERVADA`, `AGUARDANDO_RETIRADA`, `CONCLUIDA` e `CANCELADA` impedem novo cancelamento.
- Erros de formato/validação: `400`; regra de negócio: `409`; recurso inexistente: `404`.

## Limites deste incremento

O identificador `idDoador` vem da requisição. **Ainda não há autenticação/autorização na API** para provar que a pessoa autenticada é dona do anúncio. Não disponibilizar essa rota em ambiente público sem controle de acesso. O frontend da Sprint 4 é demonstrativo com `localStorage`, sem integração HTTP. A criação de solicitações e as transições após reserva pertencem a outras entregas.

## Integração

Manter as classes da Sprint 3 (`Doacao`, `Solicitacao`, `Usuario` e repositórios) no mesmo pacote. O método de consulta utilizado é `findByDoador_IdAndStatus`, conforme REF-32. O driver `org.postgresql:postgresql` deve permanecer no `pom.xml`.
