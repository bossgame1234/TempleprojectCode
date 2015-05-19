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
public class Gallery implements Comparable{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gallery)) return false;

        Gallery gallery = (Gallery) o;

        if (galleryDate != null ? !galleryDate.equals(gallery.galleryDate) : gallery.galleryDate != null) return false;
        if (galleryId != null ? !galleryId.equals(gallery.galleryId) : gallery.galleryId != null) return false;
        if (galleryName != null ? !galleryName.equals(gallery.galleryName) : gallery.galleryName != null) return false;
        if (pictureList != null ? !pictureList.equals(gallery.pictureList) : gallery.pictureList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = galleryId != null ? galleryId.hashCode() : 0;
        result = 31 * result + (galleryName != null ? galleryName.hashCode() : 0);
        result = 31 * result + (galleryDate != null ? galleryDate.hashCode() : 0);
        result = 31 * result + (pictureList != null ? pictureList.hashCode() : 0);
        return result;
    }

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

    @Override
    public int compareTo(Object o) {
        return (int) (this.getGalleryId() - ((Gallery)o).getGalleryId());
    }
}
