package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Course;
import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
@RestController
@RequestMapping("/")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "news",method = RequestMethod.GET)
    public List<News> getNews(){
        return newsService.getNews();
    }


    @RequestMapping(value = "news",method = RequestMethod.POST)
    public @ResponseBody
    News addNews(@RequestBody News news, BindingResult bindingResult){
        return newsService.addNews(news);
    }


    @RequestMapping(value = "news/{id}",method = RequestMethod.PUT)
    public  News editNews(@RequestBody News news, BindingResult bindingResult){
      return   newsService.updateNews(news);
    }

    @RequestMapping(value = "news/{id}",method = RequestMethod.DELETE)
    public News deleteNews(@PathVariable("id") Long id){
        return newsService.deleteNews(id);
    }


}
