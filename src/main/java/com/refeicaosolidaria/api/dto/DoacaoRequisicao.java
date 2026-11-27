package com.refeicaosolidaria.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record DoacaoRequisicao(
        @NotNull Long idDoador,
        @NotBlank @Size(max = 150) String nomeAlimento,
        String descricao,
        @NotNull @Positive Integer quantidadeDisponivel,
        LocalDateTime dataHoraPreparo,
        @NotNull LocalDateTime validadeConsumo,
        @NotBlank String armazenamentoConservacao,
        @NotNull Boolean declaracaoDoadorAceite,
        @NotBlank String localRetirada,
        @NotNull LocalDateTime horarioLimiteRetirada,
        @Size(max = 500) String fotoUrl
) {}
