package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Question;
import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Profile("db.dbQuestionDao")
@Repository
@Entity
public class DbQuestionDao implements QuestionDao{
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getQuestion() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findOne(id);
    }

    public Question addQuestion(Question question){
        return  questionRepository.save(question);
    }
    public  Question deleteQuestion(Question question){
        questionRepository.delete(question);
        question.setQuestionId(null);
        return question;
    }
    public  Question addAnswer(Question questionWithAnswer){
       return questionRepository.save(questionWithAnswer);
    }

    @Override
    public List<Question> getUserQuestion(String username) {
        return questionRepository.findQuestionByUsernameLike(username);
    }

}
