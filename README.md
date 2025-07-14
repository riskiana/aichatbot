# Spring AI Chatbot with OpenAI

## References

- [Blog: Creating a Chatbot with Spring AI, Java, and OpenAI](https://medium.com/wearewaes/creating-a-chatbot-with-spring-ai-java-and-openai-ee42ed9f29f8)
- [YouTube Tutorial](https://www.youtube.com/watch?v=FzLABAppJfM&list=LL&index=1&t=6201s)

## Configuration

To use your OpenAI API key securely, set it as an environment variable:

On Linux/macOS:
```bash
export OPENAI_API_KEY=your_actual_api_key
```

On Windows (Command Prompt):
```cmd
set OPENAI_API_KEY=your_actual_api_key
```

Reference the environment variable in your `application.yml`:
```yaml
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
```

## Notes

- **OpenAI Free Tier:**  
  If you are using the free tier of OpenAI, be aware of quota limitations.

- **Default Model:**  
  Spring AI uses `gpt-3.5-turbo` as the default model if none is specified in your properties.

- **Model Usage:**  
  Avoid using the `gpt-4o` model with the free tier, as it may not be supported or may quickly exhaust your quota.
```
