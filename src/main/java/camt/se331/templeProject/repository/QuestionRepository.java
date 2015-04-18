package camt.se331.templeProject.repository;

import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface QuestionRepository extends JpaRepository<Question,Long> {
 public List<Question> findQuestionByUsernameLike(String username);
}

