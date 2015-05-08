package camt.se331.templeProject.config;
import camt.se331.templeProject.entity.*;
import camt.se331.templeProject.repository.CourseRepository;
import camt.se331.templeProject.repository.GalleryRepository;
import camt.se331.templeProject.repository.HistoryRepository;
import camt.se331.templeProject.repository.UserRepository;
import camt.se331.templeProject.service.PictureUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("db.init")
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    GalleryRepository galleryRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        //id สำหรับ admin
        Role adminRole = new Role("admin");

        //create admin
        User admin = new User();
        admin.setF_name("admin");
        admin.setL_name("admin");
        admin.setUsername("admin");
        admin.setPassword("1234");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        userRepository.save(admin);


        History initHistory =  new History();
        initHistory.setHistoryID(1L);
        initHistory.setHistoryDes("วัดของเรา");
        initHistory.getHistoryPictureLocation().add(PictureUtil.getPicture("picture/slideHome1.jpg"));
        historyRepository.save(initHistory);

        Gallery gallery = new Gallery();
        gallery.getPictureList().add(PictureUtil.getPicture("picture/slideNew1.jpg"));
        gallery.getPictureList().add(PictureUtil.getPicture("picture/slideNew2.jpg"));
        Calendar calendar = new GregorianCalendar(2015,5,10);
        gallery.setGalleryDate(calendar.getTime());
        gallery.setGalleryName("งานประเพณี ใส่ขันดอก อินทขีล");
        galleryRepository.save(gallery);
    }


}