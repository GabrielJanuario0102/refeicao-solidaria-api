package com.refeicaosolidaria.api.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of("aplicacao", "refeicao-solidaria-api", "status", "UP", "sprint", "1");
    }
}
