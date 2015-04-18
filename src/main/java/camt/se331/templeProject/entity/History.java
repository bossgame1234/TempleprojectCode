package camt.se331.templeProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Dell on 2/4/2558.
 */
@Entity
public class History {
    @Id
    @GeneratedValue
    long historyID;
    String historyDes;



    String historyPictureLocation;

    public History(String historyDes,String historyPictureLocation) {
        this.historyDes = historyDes;
        this.historyPictureLocation =historyPictureLocation;
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

    public String getHistoryPictureLocation() {
        return historyPictureLocation;
    }

    public void setHistoryPictureLocation(String historyPictureLocation) {
        this.historyPictureLocation = historyPictureLocation;
    }
}
