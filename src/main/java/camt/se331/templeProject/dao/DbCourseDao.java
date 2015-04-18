package camt.se331.templeProject.dao;
import camt.se331.templeProject.entity.Course;
import camt.se331.templeProject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sornkom on 24/3/2558.
 */
@Profile("db.dbCourseDao")
@Repository
public class DbCourseDao implements CourseDao {
    @Autowired
    CourseRepository courseRepository;
    @Override

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    @Override
    public List<Course> getCourses(String id,String name) {
        List<Course> allCourse = courseRepository.findAll();
        List<Course> Course = new ArrayList<>();
        Pattern r = Pattern.compile(id);
        Pattern r2 = Pattern.compile(name);
        for (Course course : allCourse) {
            Matcher m = r.matcher(course.getCourseId());
            Matcher m2 = r2.matcher(course.getName());
            if (m.find()&&m2.find()) {
                Course.add(course);
            }
        }
        return Course;
    }
    @Override
    public Course getCourse(Long id) {
        return courseRepository.findOne(id);
    }
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course deleteCourse(Course course) {
        courseRepository.delete(course);
        course.setId(null);
        return course;
    }
    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
}
