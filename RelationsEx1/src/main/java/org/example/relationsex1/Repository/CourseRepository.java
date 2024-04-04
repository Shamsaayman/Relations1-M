package org.example.relationsex1.Repository;

import org.example.relationsex1.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById (Integer id);

}
