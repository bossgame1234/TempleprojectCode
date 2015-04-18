package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Course;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface CourseDao {
    List<Course> getCourses();
    List<Course> getCourses(String id,String name);
    Course getCourse(Long id);
    Course addCourse(Course course);
    Course deleteCourse(Course course);
    Course updateCourse(Course course);

}