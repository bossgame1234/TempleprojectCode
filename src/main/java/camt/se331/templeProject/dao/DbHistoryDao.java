package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.repository.CourseRepository;
import camt.se331.templeProject.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 5/4/2558.
 */
@Profile("db.dbHistory")
@Repository
public class DbHistoryDao implements HistoryDao{
    @Autowired
    HistoryRepository historyRepository;
    @Override
    public History getHistory(){
            return  historyRepository.findOne(1L);
        }
    @Override
    public History updateHistory(History history){
        return  historyRepository.save(history);
    }
    @Override
    public History addHistory(History history){
       return  historyRepository.save(history);
    }
}
