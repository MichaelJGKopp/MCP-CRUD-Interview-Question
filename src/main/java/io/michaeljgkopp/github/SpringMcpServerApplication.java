package io.michaeljgkopp.github;

import io.michaeljgkopp.github.service.InterviewQuestionService;
import java.util.List;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMcpServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMcpServerApplication.class, args);
  }

  @Bean
  public List<ToolCallback> interviewQuestionTools(
      InterviewQuestionService interviewQuestionService) {
    return List.of(ToolCallbacks.from(interviewQuestionService));
  }
}
