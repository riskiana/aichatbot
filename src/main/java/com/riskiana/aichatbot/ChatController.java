package com.riskiana.aichatbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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

  @GetMapping("/chat")
  public String chat() {
    return chatClient.prompt()
        .user("Please tell me about interesting in Java")
        .call()//blocking call
        .content();
  }

  @GetMapping("/stream")
  public Flux<String> stream() {
    return chatClient.prompt()
        .user("could you give me recommended place when I visiting indonesi")
        .stream()//non blocking call
        .content();
  }

  @GetMapping("/joke")
  public ChatResponse joke(){
    return chatClient.prompt()
        .user("tell me a dad joke about cats")
        .call()
        .chatResponse();
  }

}
