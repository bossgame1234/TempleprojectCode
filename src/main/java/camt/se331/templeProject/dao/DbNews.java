package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 1/4/2558.
 */
@Profile("db.dbNewsDao")
@Repository
public class DbNews implements NewsDao {
@Autowired
NewsRepository newsRepository;
    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNews(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public News updateNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News addNews(News news) {
      return newsRepository.save(news);
    }

    @Override
    public News deleteNews(News news) {
        newsRepository.delete(news);
        news.setNewsId(0);
        return news;
    }

    @Override
    public List<News> sendNews(News news) {
        return newsRepository.findAll();
    }
}
