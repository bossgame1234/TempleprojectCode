package camt.se331.templeProject.repository;

import camt.se331.templeProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 24/3/2558.
 */
public interface CourseRepository extends JpaRepository<Course,Long> {
}