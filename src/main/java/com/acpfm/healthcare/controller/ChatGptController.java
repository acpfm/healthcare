package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatgpt")
public class ChatGptController {
    private final ChatGptService chatGptService;

    @Autowired
    public ChatGptController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> suggestTreatment(@RequestBody String diagnosis) {
        String treatmentSuggestion = chatGptService.getChatGptResponse(diagnosis);
        return ResponseEntity.ok(treatmentSuggestion);
    }
}
