package camt.se331.templeProject.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2/4/2558.
 */
@Entity
public class History {
    @Id
    long historyID;
    String historyDes;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Picture> historyPictureLocation = new HashSet<>();

    public History(){
    }

    public History(String historyDes, Picture picture) {
        this.historyDes = historyDes;
        this.historyPictureLocation.add(picture);
    }

    public void setHistoryPictureLocation(Set<Picture> historyPictureLocation) {
        this.historyPictureLocation = historyPictureLocation;
    }

    public Set<Picture> getHistoryPictureLocation() {
        return historyPictureLocation;
    }

    public long getHistoryID() {
        return historyID;
    }

    public void setHistoryID(long historyID) {
        this.historyID = historyID;
    }

    public String getHistoryDes() {
        return historyDes;
    }

    public void setHistoryDes(String historyDes) {
        this.historyDes = historyDes;
    }


}
