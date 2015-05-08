package camt.se331.templeProject.config;
import camt.se331.templeProject.entity.*;
import camt.se331.templeProject.repository.*;
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
    CourseRepository courseRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    QuestionRepository questionRepository;
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

        //History
        History initHistory =  new History();
        initHistory.setHistoryID(1L);
        initHistory.setHistoryDes("วัดของเรา");
        initHistory.getHistoryPictureLocation().add(PictureUtil.getPicture("picture/slideHome1.jpg"));
        historyRepository.save(initHistory);

        //Contact
        Contact initContact = new Contact();
        initContact.setContactId(1L);
        initContact.setContactPlace("ที่อยู่ ถนนพระปกเกล้า ตำบลพระสิงห์ อำเภอเมือง จังหวัดเชียงใหม่ 50200");
        initContact.setContactFacebook("https://www.facebook.com/jdl.chiangmai?fref=ts");
        initContact.setContactTel("โทรศัพท์ 053-276-140");
        contactRepository.save(initContact);

        //Question
        Question[] initQuestion =  {
                new Question(1L,"What is this temple name?","Cartoon"),
                new Question(2L,"This is a question","Boss"),
                new Question(3L,"How many dogs in the temple?","Nook"),
                new Question(4L,"Can I take a photo","Pare")
        };
        questionRepository.save(Arrays.asList(initQuestion));

    }


}