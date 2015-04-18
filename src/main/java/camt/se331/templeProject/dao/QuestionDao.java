package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Question;
import camt.se331.templeProject.entity.User;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface QuestionDao {
    public List<Question> getQuestion() ;
    public Question getQuestionById(Long id) ;
    public Question addQuestion(Question question);
    public  Question deleteQuestion(Question question);
    public  Question addAnswer(Question questionWithAnswer);
    public  List<Question> getUserQuestion(String username);
}
