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

    public static Date parseDateTime(String input) throws ParseException {

            SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssz" );

            //this is zero time so we need to add that TZ indicator for
            if ( input.endsWith( "Z" ) ) {
                input = input.substring( 0, input.length() - 1) + "GMT-00:00";
            } else {
                int inset = 6;

                String s0 = input.substring( 0, input.length() - inset );
                String s1 = input.substring( input.length() - inset, input.length() );

                input = s0 + "GMT" + s1;
            }

            return df.parse(input);

        }


    @RequestMapping(value = "news/add",method = RequestMethod.GET)
    public  News addNews(@RequestParam(value = "newsName") String name,@RequestParam(value = "newsDate") String date,
                         @RequestParam(value = "newsPlace") String place, @RequestParam(value = "newsTime") String time,@RequestParam(value = "check") String check){
        News news = new News();
        news.setNewsDate(date);
        news.setNewsTime(time);
        news.setNewsName(name);
        news.setNewsPlace(place);
        System.out.print(check);
        if(check.equals("'true'")){
        newsService.sendmail(news);
        }
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
