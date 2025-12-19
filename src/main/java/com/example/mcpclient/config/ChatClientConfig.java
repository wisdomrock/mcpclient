package com.example.mcpclient.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    ChatClient memoryToolChatClient(ChatClient.Builder chatClientBuilder,
                                ChatMemory chatMemory,
                                ToolCallbackProvider toolCallbackProvider) {
        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(1.0)
                .maxTokens(300)
                .build();
        //For OpenAI specific ChatOptions, use OpenAiChatOptions
        Advisor memoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return chatClientBuilder
                .defaultOptions(chatOptions)
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(new SimpleLoggerAdvisor(), memoryAdvisor)
                .build();
    }
}
