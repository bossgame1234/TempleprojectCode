package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.HistoryDao;
import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dell on 5/4/2558.
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao historyDao;
    @Override
    public History getHistory() {
        return historyDao.getHistory();
    }

    @Override
    public History updateHistory(History history) {
    return  historyDao.updateHistory(history);
    }

    @Override
    public History addHistory(History history) {
    return  historyDao.addHistory(history);
    }


    @Override
    public History addPicture(History history, Picture picture) {
        history.getHistoryPictureLocation().add(picture);
        return historyDao.updateHistory(history);
    }
}
