package camt.se331.templeProject.config;
import camt.se331.templeProject.entity.*;
import camt.se331.templeProject.repository.*;
import camt.se331.templeProject.service.PictureUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Time;
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
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        //id สำหรับ admin
        Role adminRole = new Role("admin");
        //create admin
        User admin = new User();
        admin.setF_name("admin");
        admin.setL_name("admin");
        admin.setUsername("admin@hotmail.com");
        admin.setPassword("1234");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);
        userRepository.save(admin);
        Role userRole = new Role("registered user");
        userRole.setId(2l);
        roleRepository.save(userRole);

        //History
        History initHistory = new History();
        initHistory.setHistoryID(1L);
        initHistory.setHistoryDes("วัดของเรา");
        initHistory.getHistoryPictureLocation().add(PictureUtil.getPicture("/picture/slideHome1.jpg"));
        historyRepository.save(initHistory);

        Gallery HomeGallery = new Gallery();
        HomeGallery.getPictureList().add(PictureUtil.getPicture("picture/temple2.jpg"));
        HomeGallery.getPictureList().add(PictureUtil.getPicture("picture/temple3.jpg"));
        HomeGallery.setGalleryName("รูปวัด Homepage");
        galleryRepository.save(HomeGallery);


        Gallery gallery = new Gallery();
        gallery.getPictureList().add(PictureUtil.getPicture("picture/slideNew1.jpg"));
        gallery.getPictureList().add(PictureUtil.getPicture("picture/slideNew2.jpg"));
        Calendar calendar = new GregorianCalendar(2015, 5, 10);
        gallery.setGalleryDate(calendar.getTime());
        gallery.setGalleryName("งานประเพณี ใส่ขันดอก อินทขีล");
        galleryRepository.save(gallery);




        //Contact
        Contact initContact = new Contact();
        initContact.setContactId(1L);
        initContact.setContactPlace("ที่อยู่ ถนนพระปกเกล้า ตำบลพระสิงห์ อำเภอเมือง จังหวัดเชียงใหม่ 50200");
        initContact.setContactFacebook("https://www.facebook.com/jdl.chiangmai?fref=ts");
        initContact.setContactTel("โทรศัพท์ 053-276-140");
        contactRepository.save(initContact);

        //Question
        Question[] initQuestion = {
                new Question(1L, "What is this temple name?", "Cartoon"),
                new Question(2L, "This is a question", "Boss"),
                new Question(3L, "How many dogs in the temple?", "Nook"),
                new Question(4L, "Can I take a photo", "Pare")
        };

        initQuestion[0].setAnswerDes("JD");
        initQuestion[1].setAnswerDes("Really?????");
        questionRepository.save(Arrays.asList(initQuestion));

        //News
        Calendar calendar1 = new GregorianCalendar(2015, 7,11);
        News[] initNews = {
                new News("Activity1",calendar1.getTime(),Time.valueOf("10:30:00"),"จัดที่วัด",PictureUtil.getPicture("picture/slideNew1.jpg")),
                new News("Activity2",calendar1.getTime(),Time.valueOf("18:00:00"),"จัดที่บ้านนนนนนนน",PictureUtil.getPicture("picture/slideNew2.jpg"))
        };
        newsRepository.save(Arrays.asList(initNews));

        }
    }

