package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.QuestionDao;
import camt.se331.templeProject.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionDao questionDao;
    @Override
    public List<Question> getQuestion() {
        return questionDao.getQuestion();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionDao.getQuestionById(id);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

    @Override
    public Question deleteQuestion(Long id) {
        Question question = questionDao.getQuestionById(id);
        return questionDao.deleteQuestion(question);
    }

    @Override
    public Question addAnswer(Question questionWithAnswer) {
        return questionDao.addAnswer(questionWithAnswer);
    }

    @Override
    public List<Question> getUserQuestion(String username) {
        return questionDao.getUserQuestion(username);
    }
}
