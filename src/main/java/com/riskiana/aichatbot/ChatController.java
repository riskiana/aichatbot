package com.riskiana.aichatbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
  private final ChatClient chatClient;

  public ChatController(ChatModel chatModel) {
    this.chatClient = ChatClient.builder(chatModel).build();

  }

  @PostMapping(path = "/chat",
               consumes = "text/plain",
               produces = "text/plain")
  public String chat(@RequestBody String message) {
    return chatClient.prompt().user(message)
        .call()
        .content();

  }

}
