package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.QuestionDao;
import camt.se331.templeProject.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestion() {
        List<Question> question= new ArrayList<>();
        for(Question question1:questionDao.getQuestion()){
            if(question1.getAnswerDes()!=null)
            {
                question.add(question1);
            }
        }

        return question;
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
    public List<Question> getUserQuestion(String username) {return questionDao.getUserQuestion(username);
    }

    @Override
    public List<Question> getQuestionToAdmin() {
        return questionDao.getQuestion() ;
    }


}
