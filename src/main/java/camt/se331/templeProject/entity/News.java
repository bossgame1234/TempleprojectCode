package camt.se331.templeProject.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sornkom on 1/4/2558.
 */
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long newsId;
    private String newsName;
    private String newsDate;
    private String newsTime;
    private String newsPlace;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Picture> newsPictureLocation = new HashSet<>();

    public News(){
    }

    public News(Picture picture){
        this.newsPictureLocation.add(picture);
    }

public News(String name, String newsDate, String newsTime, String newsPlace, Picture picture){
    this.newsName = name;
    this.newsDate = newsDate;
    this.newsTime = newsTime;
    this.newsPlace = newsPlace;
    this.newsPictureLocation.add(picture);
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
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
    public String getNewsDate() {
        return newsDate;
    }
    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }
    public String getNewstime() {
        return newsTime;
    }
    public void setNewstime(String newsTime) {
        this.newsTime = newsTime;
    }
    public String getNewsPlace() {
        return newsPlace;
    }
    public void setNewsPlace(String newsPlace) {
        this.newsPlace = newsPlace;
    }

    public Set<Picture> getNewsPictureLocation() {
        return newsPictureLocation;
    }

    public void setNewsPictureLocation(Set<Picture> newsPictureLocation) {
        this.newsPictureLocation = newsPictureLocation;
    }
}
