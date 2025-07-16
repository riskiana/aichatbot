package com.riskiana.aichatbot;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnthropicChatController {

  private final ChatClient chatClient;
  public AnthropicChatController(@Qualifier("anthropicChatClient") ChatClient chatClient) {
    this.chatClient = chatClient;
  }

}
