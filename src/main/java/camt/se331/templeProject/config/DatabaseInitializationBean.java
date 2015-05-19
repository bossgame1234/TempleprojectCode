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
        initHistory.setHistoryDes("สร้างในสมัย\"พญาแสนเมืองมา\" เจ้าผู้ครองนครเชียงใหม่ลำดับที่ ๗ แห่งราชวงศ์มังราย พ.ศ.๑๙๓๑ - ๑๙๕๔ เพื่ออุทิศส่วนกุศลถวายแด่\"พญากือนา\" พระราชบิดา แต่ยังสร้างไม้เสร็จ\n" +
                "ก็สิ้นพระชนม์เสียก่อน ต่อมาพระมเหสีได้ควบคุมการก่อสร้างต่อจนแล้วเสร็จในสมัย \"พญาสามฝั่งแกน\" \n" +
                "เรียกว่า\"กู่หลวง\" แรกสร้างเป็นเจดีย์เล็ก ๆ ทรงสี่เหลี่ยมฐานกว้างด้านละ ๑๔ เมตร สูง๒๔ เมตร\n" +
                "ต่อมาสมัย\"พระเจ้าติโลกราช\" รัชกาลที่ ๙ แห่งราชวงศ์มังราย พ.ศ.๑๙๘๕ - ๒๐๓๐ โปรดให้\n" +
                "\"หมื่นด้ามพร้าคต\" เป็นนายช่างใหญ่สร้างเสริมเจดีย์ใหม\b"+"เริ่มสร้างตั้งแต่ปี พ.ศ. ๒๐๒๐ แล้วเสร็จเมื่อปี พ.ศ. ๒๐๒๕ โดยขยายฐานให้กว้างออกถึง ๕๖ เมตร สูง ๙๕ เมตร สามารถมองเห็นได้แต่ไกล\n" +
                "แล้วอัญเชิญพระแก้วมรกตมาประดิษฐานที่มุขด้านตะวันออกของเจดีย์เป็นเวลานานถึง ๘๐ ปี ตั้งแต่พ.ศ. ๒๐๑๐ - ๒๐๙๑ ต่อมารสมัย\"พระมหาเทวีจิระประภา\" รัชกาลที่ ๑๕ แห่งราชวงศ์มังราย พ.ศ. ๒๐๘๘ - ๒๐๘๙ \n" +
                "ในปีพ.ศ. ๒๐๘๘ ต่อมามีฝนตกหนัก และเกิดแผ่นดินไหวครั้งใหญ่ เป็นสาเหหตุให้ส่วนยอดของเจดีย์หักพังเหลือเพียงครึ่งองค์ เกิดรอยร้าวที่องค์พระเจดีย์สุดที่จะแก้ไขได้ จึงถูกทิ้งร้างมานานถึง ๔๔๕ ต่อมาปี พ.ศ. ๒๕๓๓ กรมศิลปกรได้ทำการบูรณะจนเป็นดังที่เห็นเช่นปัจจุบันนี้ เสาหลักเมือง ตั้งอยู่กลางวิหารจตุรมุขศิลปะแบบล้านนาประยุกต์ เป็นเสาอิฐก่อปูนตัดกระจกสี รอบเสาวัดได้ ๕.๖๗ เมตร สูง ๑.๓๐ เมตร แท่นพระบนเสาอินทขิลสูง ๙๗ เซนติเมตร รอบแท่นวัดได้ ๒.๔ เมตร บนเสาอินทขิลมีพะรพุทธรูปทองสำริดปางรำพึง ประดิษฐานอยู่ภายในบุษบก พลตรี เจ้าราชบุตร (วงศ์ตะวัน ณ เชียงใหม่) นำมาถวายวัดเจดีย์หลวงเมื่อปี พ.ศ. ๒๕๑๔ เพื่อให้ชาวเมืองได้สักการะคู่กัน\n" +
                "\n" +
                "ตำนานเสาอินทขิล การสร้างเสาอินทขิลเริ่มจากชาวลัวะซึ่งเป็นชนพื้นเมืองในบริเวณที่ราบลุ่มแม่น้ำปิง เชิงดอยสุเทพ ได้ก่อตั้งชุมชนระดับเวียงหลายแห่งในบริเวณนี้ เช่นเวียงเชษฐบุรี เวียงสวนดอก เวียงนพบุรี เมื่อตั้งเวียงนพบุรีได้ตั้งเสาอินทขิลขึ้นเป็นศูนย์รวมจิตใจของชาวเมือง พร้อมกับมอบกุมภัณฑ์สองตนทำหน้าที่รักษาเวียงให้มั่นคง ตามคำแนะนำของฤาษี ชาวเมืองต้องทำพิธีบูชาเสาอินทขิลและเลี้ยงกุมภัณฑ์ หากปล่อยปละละเลยไม่บูชาบ้านเมืองจะวินาศ\n" +
                "ส่วนเสาอินทขิลที่ประดิษฐานอยู่ที่วัดเจดีย์หลวงนั้น มีบันทึกไว้ว่าพญามังรายมหาราช ปฐมกษัตริย์ทรงสร้างเสาอินทขิล เมื่อครั้งสถาปนา \"นพบุรีศรีนครพิงค์เชียงใหม่\" ขึ้นเมื่อปี พ.ศ. ๑๘๓๙ เดิมอยู่ที่วัดสะดือเมืองหรือวัดอินทขิล กลางเวียงเชียงใหม่ (ปัจจุบันคือหอประติโลกราช ข้างศาลากลางหลังเก่า) ครั้ง\"พระเจ้ากาวิละ\"ครองเมืองเชียงใหม่ ได้ย้ายมาประดิษฐานที่วัดเจดีย์หลวง โดยบูรณะขึ้นใหม่เป็นเสาปูน พร้อมกับทำการบวงสรวงเป็นพระเพณีสืบทอดกันมาจนถึงปัจจุบัน\n" +
                "\n" +
                "เครื่องสังเวยพลีกรรม หรือเครื่องบูชาเสาอินทขิล\n" +
                "ได้แก่ ขันตั้ง ๑๒ ขัน ขันประธาน ๑ ขัน ขันบริวาร ๑๑ ขัน\n" +
                "\n" +
                "คำบูชาเสาอินทขิล\n" +
                "\"อินทะขีลัง สิทธิชัยยะ อินทะขีลัง สิทธิชัยยะ\n" +
                "อินทะขีลัง มังคะลัตถิ อินทะขีลัง โสตถิมังคะลัง\"");
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
                new Question(1L, "ถ้าอยากจะเข้าไปพบหลวงพ่อพรุ่งนี้(19/05/2558) จะสะดวกตอนไหนบ้างคะ", "จามจุรี สวยจัง"),
                new Question(2L, "ประวัติของวัดเจดีย์หลวง ผมขออนุญาติก็อบปี้นำไปลงเว็บได้ไหมครับ", "ไอ้วัน"),
                new Question(3L, "ที่จอดรถเต็มหรือยังคะ เวลาประมาณเที่ยงๆ", "ฉัน อ้วน"),
                new Question(4L, "I Love This Place .....", "Chinese Love Thailand")
        };

        initQuestion[0].setAnswerDes("หลวงพ่อไม่ว่างเลยครับวันพรุ่งนี้ ขออภัยด้วยนะครับ");
        initQuestion[1].setAnswerDes("ได้เลยครับ");
        questionRepository.save(Arrays.asList(initQuestion));

        //News
        Calendar calendar1 = new GregorianCalendar(2015, 7,11);
        News[] initNews = {
                new News("งานประเพณีใส่ขันดอก อินทขีล",calendar1.getTime().toString(),"10:30:00","ณ วัดเจดีย์หลวง วรวิหาร เมืองเชียงใหม่  ในวันที่ ๑๔-๒๑ พฤษภาคม ๒๕๕๘",PictureUtil.getPicture("picture/slideNew1.jpg")),
                new News("งานประเพณีสงกรานต์ 2558",calendar1.getTime().toString(),"18:00:00","ณ วัดเจดีย์หลวง วรวิหาร เมืองเชียงใหม่  ในวันที่ ๑๓-๑๕ เมษายน ๒๕๕๘",PictureUtil.getPicture("picture/slideNew2.jpg"))
        };
        newsRepository.save(Arrays.asList(initNews));

        }
    }

