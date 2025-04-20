package io.michaeljgkopp.github.dao;

import io.michaeljgkopp.github.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {

  List<InterviewQuestion> getInterviewQuestionsByCategory(String category);
}
