package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.QuestionDao;
import camt.se331.templeProject.service.ContactService;
import camt.se331.templeProject.service.PictureUtil;
import camt.se331.templeProject.service.QuestionService;
import camt.se331.templeProject.service.QuestionServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
        when(questionDao.getQuestion()).thenReturn(questionList);

        assertThat(questionService.getQuestionById(1L).getQuestionId(), is(1L));
        //assertThat(questionService.getQuestionById(1L).getQuestionDes(), is("QuestionDes1"));
        //assertThat(questionService.getQuestionById(1L).getUsername(), is("Cartoon"));
    }

    @Test
    public void testGetQuestionById(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);

        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        when(questionDao.getQuestionById(2L)).thenReturn(question2);

        assertThat(questionDao.getQuestionById(2L), is(question2));

    }

    @Test
    public void testAddQuestion(){
        Question question1 = new Question(1L,"QuestionDes1","Cartoon");
        Question question2 = new Question(2L,"QuestionDes2","Pare");
        Question question3 = new Question(3L,"QuestionDes3","Nook");
        Question question4 = new Question(4L,"QuestionDes4","Boss");

        List<Question> questionList = new ArrayList<>();
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);

        QuestionService questionService = Mockito.mock(QuestionService.class);
        when(questionService.addQuestion(question4)).thenReturn(question4);
        assertThat(questionService.addQuestion(question4), is(question4));

        questionList.add(question4);
        when(questionService.getQuestionById(4L)).thenReturn(question4);
        assertThat(questionService.getQuestionById(4L),is(question4));

    }
}
