package camt.se331.templeProject.entity;

import camt.se331.templeProject.dao.NewsDao;
import camt.se331.templeProject.repository.NewsRepository;
import camt.se331.templeProject.service.NewsService;
import camt.se331.templeProject.service.NewsServiceImpl;
import org.apache.commons.lang.ObjectUtils;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.*;
/**
 * Created by SONY on 19/5/2558.
 */
public class NewsTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testGetNews(){

        Picture picture = Mockito.mock(Picture.class);
        News news1 = new News("news1","20/05/2015","08:00", "temple1" ,picture);
        News news2 = new News("news2","05/12/2015","09:00", "temple1" ,picture);
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        NewsDao newsDao = Mockito.mock(NewsDao.class);
        NewsService newsService = new NewsServiceImpl(newsDao);
        when(newsDao.getNews()).thenReturn(newsList);
        assertThat(newsService.getNews(),is(newsList));
    }

    @Test
    public void testAddNews(){
        Picture picture = Mockito.mock(Picture.class);
        News news1 = new News("news1","20/05/2015","08:00", "temple1" ,picture);
        News news2 = new News("news2","05/12/2015","09:00", "temple1" ,picture);
        News news3= new News("news3","15/02/2015","10:00", "temple1" ,picture);
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        NewsDao newsDao = Mockito.mock(NewsDao.class);
        NewsService newsService = new NewsServiceImpl(newsDao);

        when(newsDao.addNews(news3)).thenReturn(news3);
        newsList.add(news3);
        assertThat(newsService.addNews(news3), is(news3));
        when(newsDao.getNews()).thenReturn(newsList);
        assertThat(newsService.getNews().size(), is(3));

    }

    @Test
    public void testDeleteNews(){
        Picture picture = Mockito.mock(Picture.class);
        News news1 = new News("news1","20/05/2015","08:00", "temple1" ,picture);
        News news2 = new News("news2","05/12/2015","09:00", "temple1" ,picture);
        News news3= new News("news3","15/02/2015","10:00", "temple1" ,picture);
        news1.setNewsId(1L);
        news2.setNewsId(2L);
        news3.setNewsId(3L);
        List<News> newsList = new ArrayList<>();
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        NewsDao newsDao = Mockito.mock(NewsDao.class);
        NewsService newsService = new NewsServiceImpl(newsDao);
        when(newsService.deleteNews(2L)).thenReturn(null);
        assertThat(newsService.deleteNews(news2.getNewsId()), is(nullValue()));
        //ถ้าจะ test ให้แดง  ให้เปลี่ยนเป็น is(notNullValue())
        //assertThat(newsService.getNewsById(2L),is(nullValue()));

    }


}
