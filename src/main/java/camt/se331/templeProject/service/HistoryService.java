package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.entity.Picture;

import java.util.List;

/**
 * Created by Dell on 5/4/2558.
 */
public interface HistoryService {
    public History getHistory();
    public History updateHistory(History history);
    public History addHistory(History history);
    public History addPicture(History history, Picture picture);
}
