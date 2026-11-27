package com.refeicaosolidaria.api.dto;

import com.refeicaosolidaria.api.domain.Doacao;
import com.refeicaosolidaria.api.domain.StatusDoacao;
import java.time.LocalDateTime;

public record DoacaoResposta(
        Long id,
        Long idDoador,
        String nomeAlimento,
        String descricao,
        Integer quantidadeDisponivel,
        LocalDateTime dataHoraPreparo,
        LocalDateTime validadeConsumo,
        String armazenamentoConservacao,
        Boolean declaracaoDoadorAceite,
        String localRetirada,
        LocalDateTime horarioLimiteRetirada,
        String fotoUrl,
        StatusDoacao status,
        LocalDateTime dataCriacao
) {
    public static DoacaoResposta de(Doacao entidade) {
        return new DoacaoResposta(
                entidade.getId(), entidade.getDoador().getId(),
                entidade.getNomeAlimento(), entidade.getDescricao(),
                entidade.getQuantidadeDisponivel(), entidade.getDataHoraPreparo(),
                entidade.getValidadeConsumo(), entidade.getArmazenamentoConservacao(),
                entidade.getDeclaracaoDoadorAceite(), entidade.getLocalRetirada(),
                entidade.getHorarioLimiteRetirada(), entidade.getFotoUrl(),
                entidade.getStatus(), entidade.getDataCriacao());
    }
}
