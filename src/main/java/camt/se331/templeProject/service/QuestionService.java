package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Question;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface QuestionService {
    public List<Question> getQuestion() ;
    public Question getQuestionById(Long id) ;
    public Question addQuestion(Question question);
    public  Question deleteQuestion(Long id);
    public  Question addAnswer(Question questionWithAnswer);
    public  List<Question> getUserQuestion(String username);
    public List<Question> getQuestionToAdmin();
}
