package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.News;

import java.util.List;

/**
 * Created by Dell on 1/4/2558.
 */
public interface NewsService {
public List<News> getNews();
public News updateNews(News news);
public News addNews(News news);
public News deleteNews(Long id);
}
