package com.refeicaosolidaria.api.controller;

import com.refeicaosolidaria.api.domain.StatusDoacao;
import com.refeicaosolidaria.api.dto.CancelamentoDoacaoRequisicao;
import com.refeicaosolidaria.api.dto.DoacaoRequisicao;
import com.refeicaosolidaria.api.dto.DoacaoResposta;
import com.refeicaosolidaria.api.service.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/doacoes")
public class DoacaoController {
    private final DoacaoService service;

    public DoacaoController(DoacaoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<DoacaoResposta> criar(@Valid @RequestBody DoacaoRequisicao dados) {
        DoacaoResposta nova = service.criar(dados);
        return ResponseEntity.created(URI.create("/api/doacoes/" + nova.id())).body(nova);
    }

    @GetMapping
    public List<DoacaoResposta> listar(@RequestParam(required = false) StatusDoacao status,
                                       @RequestParam(required = false) Long idDoador) {
        return service.listar(status, idDoador);
    }

    @GetMapping("/{id}")
    public DoacaoResposta buscar(@PathVariable Long id) { return service.buscar(id); }

    @PutMapping("/{id}")
    public DoacaoResposta editar(@PathVariable Long id,
                                @Valid @RequestBody DoacaoRequisicao dados) {
        return service.editar(id, dados);
    }

    @DeleteMapping("/{id}")
    public DoacaoResposta cancelar(@PathVariable Long id,
                                   @Valid @RequestBody CancelamentoDoacaoRequisicao dados) {
        return service.cancelar(id, dados.motivo());
    }
}
