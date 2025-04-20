package io.michaeljgkopp.github.service;

import io.michaeljgkopp.github.dao.InterviewQuestionRepository;
import io.michaeljgkopp.github.entity.InterviewQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewQuestionService {

  private static final Logger logger = LoggerFactory.getLogger(InterviewQuestionService.class);
  private final InterviewQuestionRepository interviewQuestionRepository;

  public InterviewQuestionService(InterviewQuestionRepository interviewQuestionRepository) {
    this.interviewQuestionRepository = interviewQuestionRepository;
  }

  @Tool(name = "iqs_get_interview_questions_by_category", description =
      "Get interview questions by category"
          + "by category")
  public List<InterviewQuestion> getInterviewQuestionsByCategory(String category) {
    return interviewQuestionRepository.getInterviewQuestionsByCategory(category);
  }

  @Tool(name = "iqs_get_interview_questions_all", description = "Get all the interview questions"
      + "by category")
  public List<InterviewQuestion> getInterviewQuestions() {
    return interviewQuestionRepository.findAll();
  }

  // Get interview questions randomly by category and limit
  @Tool(name = "iqs_get_interview_questions_random_by_category", description =
      "Get interview questions randomly by category and limit")
  public List<InterviewQuestion> getInterviewQuestionsRandomByCategory(String category, int limit) {
    return interviewQuestionRepository.getInterviewQuestionsRandomlyByCountAndCategory(limit, category);
  }

  // Get interview questions randomly by limit
  @Tool(name = "iqs_get_interview_questions_random", description =
      "Get interview questions randomly by limit")
  public List<InterviewQuestion> getInterviewQuestionsRandom(int limit) {
    return interviewQuestionRepository.getInterviewQuestionsRandomlyByCount(limit);
  }

  // Save a new interview question
  @Tool(name = "iqs_save_interview_question", description = "Save an interview question. If id is"
      + " null a new one is created, otherwise the existing one is updated")
  public InterviewQuestion createInterviewQuestion(InterviewQuestion interviewQuestion) {
    return interviewQuestionRepository.save(interviewQuestion);
  }

  @Tool(name = "iqs_delete_interview_question_by_id", description = "Delete the interview "
      + "question by id")
  public void deleteInterviewQuestion(Long id) {
    interviewQuestionRepository.deleteById(id);
  }

  @Tool(name = "iqs_delete_all_interview_questions", description = "Delete all the interview "
      + "questions, only do if explicitly requested for the whole database to be cleared.")
  public void deleteAllInterviewQuestions() {
    interviewQuestionRepository.deleteAll();
  }
}
