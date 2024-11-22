package com.acpfm.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGptService {
    private final WebClient webClient;
    private static final String API_KEY = "";

    @Autowired
    public ChatGptService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/chat").build();
    }

    //Métido genérico para enviar uma solicitação para API OpenAI
    public String getChatGptResponse(String prompt){
        Map<String,Object> request = new HashMap<>();
        request.put("model","text-davinci-003");
        request.put("prompt", prompt);
        request.put("max_tokens", 150);
        request.put("temperature", 0.7);

        try {
            return this.webClient.post()
                    .uri("/completions")
                    .header("Authorization", "Bearer " + API_KEY)
                    .body(BodyInserters.fromValue(request))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            // Retorna uma mensagem amigável para o cliente caso haja erro na requisição
            return "Erro na solicitação à API: " + e.getMessage();
        }
    }

    // Método específico para sugerir tratamentos
    public String suggestTreatment(String diagnosis) {
        String prompt = "Paciente com diagnóstico de " + diagnosis +
                ". Quais são as possíveis opções de tratamento recomendadas?";
        return getChatGptResponse(prompt);
    }
}
