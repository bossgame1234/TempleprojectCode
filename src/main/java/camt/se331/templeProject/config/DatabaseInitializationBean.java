package camt.se331.templeProject.config;
import camt.se331.templeProject.entity.Course;
import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.repository.CourseRepository;
import camt.se331.templeProject.repository.HistoryRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Course[] initCourse = {
                new Course("953331","Component Based Software Development",3,"701"),
                new Course("953331","Component Based Software Development",3,"702"),
                new Course("953323","Software Constrction Testing and Maintenence",3,"701"),
                new Course("953101","Introduction to Computers",4,"702")
        };

        History initHistory =  new History();
        initHistory.setHistoryID(1L);
        initHistory.setHistoryDes("วัด");

        historyRepository.save(initHistory);

    }


}