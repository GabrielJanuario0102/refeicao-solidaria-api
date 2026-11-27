package com.refeicaosolidaria.api.controller;

import com.refeicaosolidaria.api.exception.RecursoNaoEncontradoException;
import com.refeicaosolidaria.api.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> naoEncontrado(RecursoNaoEncontradoException erro) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", erro.getMessage()));
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Map<String, String>> regra(RegraNegocioException erro) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("erro", erro.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> dadosInvalidos(MethodArgumentNotValidException erro) {
        String mensagem = erro.getBindingResult().getFieldErrors().stream()
                .findFirst().map(item -> item.getField() + ": " + item.getDefaultMessage())
                .orElse("Requisição inválida.");
        return ResponseEntity.badRequest().body(Map.of("erro", mensagem));
    }
}
