package camt.se331.templeProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Sornkom on 1/4/2558.
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    long newsId;
private String newsName;
private Date newsDate;

    public Time getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Time newsTime) {
        this.newsTime = newsTime;
    }

    private Time newsTime;
private String newsPlace;

    public String getNewsPictureLocation() {
        return newsPictureLocation;
    }

    public void setNewsPictureLocation(String newsPictureLocation) {
        this.newsPictureLocation = newsPictureLocation;
    }

    private String newsPictureLocation;

public News(String name, Date newsDate, Time newsTime, String newsPlace){
    this.newsName = name;
    this.newsDate = newsDate;
    this.newsTime = newsTime;
    this.newsPlace = newsPlace;

    }
    public long getNewsId() {
        return newsId;
    }
    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }
    public String getNewsName() {
        return newsName;
    }
    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }
    public Date getNewsDate() {
        return newsDate;
    }
    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }
    public Time getNewstime() {
        return newsTime;
    }
    public void setNewstime(Time newsTime) {
        this.newsTime = newsTime;
    }
    public String getNewsPlace() {
        return newsPlace;
    }
    public void setNewsPlace(String newsPlace) {
        this.newsPlace = newsPlace;
    }
}
