package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Course;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface CourseService {
    List<Course> getCourses();
    List<Course> getCourses(String id,String name);
    Course getCourse(Long id);
    Course addCourse(Course Course);
    Course deleteCourse(Long id);
    Course updateCourse(Course Course);
}