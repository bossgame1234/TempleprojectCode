package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    camt.se331.templeProject.dao.CourseDao CourseDao;
    @Override
    public List<Course> getCourses() {
        return CourseDao.getCourses();
    }

    @Override
    public List<Course> getCourses(String id,String name) {
        return CourseDao.getCourses(id,name);
    }

    @Override
    public Course getCourse(Long id) {
        return CourseDao.getCourse(id);
    }

    @Override
    public Course addCourse(Course Course) {
        return CourseDao.addCourse(Course);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course Course = getCourse(id);
        return CourseDao.deleteCourse(Course);
    }

    @Override
    public Course updateCourse(Course Course) {
        return CourseDao.updateCourse(Course);
    }
}

