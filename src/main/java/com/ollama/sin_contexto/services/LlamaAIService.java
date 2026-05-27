package com.ollama.sin_contexto.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAIService {

    @Autowired
    private OllamaChatModel chatModel;

    public String generateResult(String prompt) {
        OllamaChatOptions options = new OllamaChatOptions();
        options.setModel("llama2"); // Asegúrate de que el modelo esté disponible en tu instancia de Ollama

        ChatResponse response = chatModel.call(new Prompt(prompt, options));

        if (response != null) {
            return response.getResult().getOutput().getText();
        }

        return "Error: No hay respuesta recibida de Ollama API";
    }
}
