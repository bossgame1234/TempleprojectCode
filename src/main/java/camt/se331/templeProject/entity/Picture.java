package camt.se331.templeProject.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by Dell on 14/4/2558.
 */
@Entity
public class Picture {
        @Id
        @GeneratedValue
    long pictureId;
    String pictureName;
    String pictureType;

    @Lob
    byte[] pictureLocation;

    public Picture(){

    }

    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public byte[] getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(byte[] pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }
}
