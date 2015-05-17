package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.entity.Picture;

import java.util.List;

/**
 * Created by Dell on 1/4/2558.
 */
public interface NewsService {
public List<News> getNews();
public News getNewsById(Long id);
public News updateNews(News news);
public News addNews(News news);
public News addPictureNews(News news,Picture picture);
public News deleteNews(Long id);
    public List<News> sendmail();
}
