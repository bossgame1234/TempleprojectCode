package camt.se331.templeProject.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Entity
public class Gallery {
    @Id
    @GeneratedValue
    Long galleryId;
    String galleryName;
    Date galleryDate;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    List<Picture> pictureList = new ArrayList<>();

    public Gallery(){}
    public Long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    public Date getGalleryDate() {
        return galleryDate;
    }

    public void setGalleryDate(Date galleryDate) {
        this.galleryDate = galleryDate;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }
}
