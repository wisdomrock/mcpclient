package com.example.mcpclient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(APIConstants.ApiRoot)
class MCPClientController {
    private final ChatClient chatClient;

    MCPClientController(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider) {
        chatClient = builder
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @GetMapping("chat")
    String chat(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
