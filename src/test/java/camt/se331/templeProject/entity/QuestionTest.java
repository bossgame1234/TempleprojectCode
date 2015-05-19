package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.QuestionDao;
import camt.se331.templeProject.service.ContactService;
import camt.se331.templeProject.service.PictureUtil;
import camt.se331.templeProject.service.QuestionService;
import camt.se331.templeProject.service.QuestionServiceImpl;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.*;
/**
 * Created by SONY on 18/5/2558.
 */
public class QuestionTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testGetQuestion(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        question1.setAnswerDes("Yehhhhh");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        List<Question> questionListWithAnswer = new ArrayList<>();
        questionListWithAnswer.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);
        when(questionDao.getQuestion()).thenReturn(questionListWithAnswer);
        assertThat(questionService.getQuestion(), is(questionListWithAnswer));
    }

    @Test
    public void testGetQuestionById(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        when(questionDao.getQuestionById(2L)).thenReturn(question2);
        assertThat(questionService.getQuestionById(2L), is(question2));
        assertThat(questionService.getQuestionById(2L).getQuestionDes(), is("QuestionDes2"));

    }

    @Test
    public void testAddQuestion(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");
        question3.setAnswerDes("Yehhhhh");

        List<Question> questionList = new ArrayList<>();
        List<Question> questionListWithAnswer = new ArrayList<>();
        questionListWithAnswer.add(question3);

        questionList.add(question1);
        questionList.add(question2);

        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        when(questionDao.addQuestion(question4)).thenReturn(question4);
        assertThat(questionService.addQuestion(question4), is(question4));

        questionList.add(question4);
        when(questionDao.getQuestionById(4L)).thenReturn(question4);
        assertThat(questionService.getQuestionById(4L).getAnswerDes(),is(isNull()));
        assertThat(questionService.getQuestionById(4L).getQuestionDes(),is("QuestionDes4"));

    }

    @Test
    public void testDeleteQuestion(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        question1.setAnswerDes("Yehhhhh");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        List<Question> questionListWithAnswer = new ArrayList<>();
        questionListWithAnswer.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        when(questionService.deleteQuestion(2L)).thenReturn(null);
        assertThat(questionService.deleteQuestion(question2.getQuestionId()), is(nullValue()));
    }

    @Test
    public void testAddAnswer(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        question1.setAnswerDes("Yehhhhh");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        List<Question> questionListWithAnswer = new ArrayList<>();
        questionListWithAnswer.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        question2.setAnswerDes("5555555");
        questionListWithAnswer.add(question2);
        when(questionDao.addAnswer(question2)).thenReturn(question2);
        assertThat(questionService.addAnswer(question2), is(question2));
    }

    @Test
    public void testUserQuestion(){

        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        question1.setAnswerDes("Yehhhhh");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        List<Question> questionUser = new ArrayList<>();
        questionUser.add(question1);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        questionUser.add(question1);
        when(questionDao.getUserQuestion("Cartoon")).thenReturn(questionUser);
        assertThat(questionService.getUserQuestion("Cartoon"), is(questionUser));

    }

    @Test
    public void testQuestionToAdmin(){

        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        question1.setAnswerDes("Yehhhhh");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        QuestionService questionService = new QuestionServiceImpl(questionDao);

        when(questionDao.getQuestionToAdmin()).thenReturn(questionList);
        assertThat(questionService.getQuestionToAdmin(), is(questionList));
    }
}
