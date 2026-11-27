package com.refeicaosolidaria.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelamentoDoacaoRequisicao(@NotBlank String motivo) {}
