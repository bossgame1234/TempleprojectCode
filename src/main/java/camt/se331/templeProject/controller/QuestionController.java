package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Question;
import camt.se331.templeProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@RestController
@RequestMapping("/")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "Question",method = RequestMethod.GET)
    public List<Question> getQuestion(){
        return questionService.getQuestion();
    }

    @RequestMapping(value = "Question/admin",method = RequestMethod.GET)
    public List<Question> getQuestionToAdmin(){
        return questionService.getQuestionToAdmin();
    }


    @RequestMapping(value = "Question",method = RequestMethod.POST)
    public @ResponseBody
    Question addQuestion(@RequestBody Question question, BindingResult bindingResult){
        return questionService.addQuestion(question);
    }

    @RequestMapping(value = "Question/{id}",method = RequestMethod.PUT)
    public  Question addAnswer(@RequestBody Question question, BindingResult bindingResult){
        return   questionService.addAnswer(question);
    }

    @RequestMapping(value = "Question/{id}",method = RequestMethod.DELETE)
    public Question deleteQuestion(@PathVariable("id") Long id){
        return questionService.deleteQuestion(id);
    }

    @RequestMapping(value = "Question/ownquestion",method = RequestMethod.GET)
    public List<Question> getQuestion(@RequestParam(value = "username") String username){
        return questionService.getUserQuestion(username);
    }

}
