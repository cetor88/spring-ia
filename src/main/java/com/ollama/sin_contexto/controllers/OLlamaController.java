package com.ollama.sin_contexto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lta.example.services.LlamaAIService;

@RestController
public class OLlamaController {

    @Autowired
    private LlamaAIService llamaAIService;

    @GetMapping("/api/v1/generate")
    public String generate(@RequestParam(value = "promptMessage") String promptMessage) {
        return llamaAIService.generateResult(promptMessage);
    }
}