package com.riskiana.aichatbot.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
  private final ChatClient chatClient;

   public ArticleController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @GetMapping("posts/new")
  public String newPost(@RequestParam(value = "topic",
  //guidelines to the model before it processes user queries. Think of it as the "behind-the-scenes"
      //instructions that shape how the AI should respond.
      //use it as a guide or a restriction to the model's behaviour
      defaultValue = "JDK Virtual Threads") String topic) {
     var system = """
                 You are an expert technical blog post generator.
                 Guidelines:
                 - Write clearly and concisely for a developer audience.
                 - Focus on the topic: %s.
                 - Use code examples where appropriate.
                 - Avoid unnecessary jargon.
                 - Structure the post with an introduction, main content, and conclusion.
                 - Ensure accuracy and relevance.
                 """;
    return chatClient.prompt()
        .user(u -> {
              u.text("Write me a blog post about {topic}");
              u.param("topic", topic);
            })
        .system(system)
        .call()
        .content();
  }
}
