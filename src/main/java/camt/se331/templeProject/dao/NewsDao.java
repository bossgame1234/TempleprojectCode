package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.News;

import java.util.List;

/**
 * Created by Dell on 1/4/2558.
 */
public interface NewsDao {
public List<News> getNews();
public News getNews(Long id);
public News updateNews(News news);
public News addNews(News news);
public News deleteNews(News news);
public List<News> sendNews(News news);

}
