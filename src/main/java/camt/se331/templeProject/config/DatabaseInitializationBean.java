package camt.se331.templeProject.config;
import camt.se331.templeProject.entity.Course;
import camt.se331.templeProject.repository.CourseRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Course[] initCourse = {
                new Course("953331","Component Based Software Development",3,"701"),
                new Course("953331","Component Based Software Development",3,"702"),
                new Course("953323","Software Constrction Testing and Maintenence",3,"701"),
                new Course("953101","Introduction to Computers",4,"702")
        };

    }


}