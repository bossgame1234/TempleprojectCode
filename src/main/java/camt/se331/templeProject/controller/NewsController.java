package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.service.NewsService;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @RequestMapping(value = "news/{id}",method = RequestMethod.GET)
    public News getNewsById(@PathVariable("id") Long id){
        return newsService.getNewsById(id);
    }
    public static Date parseDateTime(String dateString) {
        if (dateString == null) return null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        if (dateString.contains("T")) dateString = dateString.replace('T', ' ');
        if (dateString.contains("Z")) dateString = dateString.replace("Z", "+0000");
        else
            dateString = dateString.substring(0, dateString.lastIndexOf(':')) + dateString.substring(dateString.lastIndexOf(':')+1);
        try {
            return fmt.parse(dateString);
        }
        catch (ParseException e) {
            return null;
        }
    }

    @RequestMapping(value = "news/add",method = RequestMethod.GET)
    public  News addNews(@RequestParam(value = "newsName") String name,@RequestParam(value = "newsDate") String date,
                         @RequestParam(value = "newsPlace") String place,@RequestParam(value = "newsTime") String time){
        News news = new News();
        news.setNewsDate(parseDateTime(date));
        news.setNewsTime(Time.valueOf(time+":00"));
        news.setNewsName(name);
        news.setNewsPlace(place);
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


    @RequestMapping(value = "news",method = RequestMethod.PUT)
    public  List<News> sendNews(News news){
        return   newsService.sendNews(news);
    }
}
