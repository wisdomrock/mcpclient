package com.example.mcpclient.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(APIConstants.ApiRoot)
class MCPClientController {
    private final ChatClient chatClient;

    @GetMapping("chat")
    String chat(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
