package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Course;
import camt.se331.templeProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@RestController
@RequestMapping("/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "course",method = RequestMethod.GET)
    public  List<Course> list(){
        return courseService.getCourses();
    }


    @RequestMapping(value = "course",method = RequestMethod.POST)
    public @ResponseBody Course add(@RequestBody Course Course, BindingResult bindingResult){
        return courseService.addCourse(Course);
    }

    @RequestMapping(value = "course/{id}",method = RequestMethod.GET)
    public  Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "course/search/{courseId}&&{name}",method = RequestMethod.GET)
    public  List<Course> getCourse(@PathVariable("courseId") String courseId,@PathVariable("name") String name){
        return courseService.getCourses(courseId,name);
    }

    @RequestMapping(value = "course/{id}",method = RequestMethod.PUT)
    public  Course edit(@PathVariable("id") Long id  ,@RequestBody Course Course, BindingResult bindingResult){
        return courseService.updateCourse(Course);
    }

    @RequestMapping(value = "course/{id}",method = RequestMethod.DELETE)
    public  Course edit(@PathVariable("id") Long id){
        return courseService.deleteCourse(id);
    }
}
