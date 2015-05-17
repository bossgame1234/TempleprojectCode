package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.NewsDao;
import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2/4/2558.
 */
@Service
public class NewsServiceImpl implements NewsService {
@Autowired
    NewsDao newsDao;

    public News getNewsById(Long id){
        return newsDao.getNews(id);
    }

    @Override
    public List<News> getNews() {
        return newsDao.getNews();
    }

    @Override
    public News updateNews(News news) {
        return newsDao.updateNews(news);
    }

    @Override
    public News addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    public News deleteNews(Long id) {
        News news  = newsDao.getNews(id);
      return newsDao.deleteNews(news);
    }



}
