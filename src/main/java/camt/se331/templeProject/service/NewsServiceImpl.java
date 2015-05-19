package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.NewsDao;
import camt.se331.templeProject.entity.News;
import javax.mail.Session;

import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;


import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;


/**
 * Created by Dell on 2/4/2558.
 */
@Service
public class NewsServiceImpl implements NewsService {
@Autowired
    NewsDao newsDao;
    @Autowired
    UserRepository userRepository;

    public NewsServiceImpl(NewsDao newsDao){
        this.newsDao = newsDao;
    }

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
    public void sendmail(News news) {
        final String username = "se552115068@vr.camt.info";
        final String password = "552115068";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            List<User> userList = new ArrayList<User>(userRepository.findAll());
            for(int i=1; i < userList.size() ; i++){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("from-email@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(userList.get(i).getUsername()));
                message.setSubject("ขอเชิญร่วมงาน " + news.getNewsName());
                message.setText("   ขอเชิญทุกท่านร่วมงาน " + news.getNewsName() + " ณ " + news.getNewsPlace()+" ระหว่าง " + news.getNewsDate()+" เวลา "+news.getNewsTime());
                Transport.send(message);
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public News addPictureNews(News news, Picture picture) {
        news.getNewsPictureLocation().add(picture);
        return newsDao.addNews(news);
    }

    @Override
    public News deleteNews(Long id) {
        News news  = newsDao.getNews(id);
      return newsDao.deleteNews(news);
    }


}
