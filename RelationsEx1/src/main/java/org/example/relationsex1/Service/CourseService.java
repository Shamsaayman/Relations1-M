package org.example.relationsex1.Service;

import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiException;
import org.example.relationsex1.Model.Course;
import org.example.relationsex1.Model.Teacher;
import org.example.relationsex1.Repository.CourseRepository;
import org.example.relationsex1.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAll(){
        return courseRepository.findAll();
    }

public void addCourse(Course course , Integer teacher_id){
    Teacher t = teacherRepository.findTeacherById(teacher_id);
    if(t==null){
        throw new ApiException("Teacher id doesn't exist");
    }
    course.setTeacher(t);
    courseRepository.save(course);
}
public void updateCourse(Integer id , Course course){
    Course c = courseRepository.findCourseById(id);
    if(c==null){
        throw new ApiException("Course doesn't exist");
    }
    c.setName(course.getName());
    courseRepository.save(c);
}
public void deleteCourse(Integer id){
    Course c = courseRepository.findCourseById(id);
    if(c==null){
        throw new ApiException("Course doesn't exist");
    }
    courseRepository.delete(c);
}

public String getTeacherName(Integer id){
    Course c = courseRepository.findCourseById(id);
    if(c==null){
        throw new ApiException("Course doesn't exist");
    }
    return "Teacher Name: " + c.getTeacher().getName() ;
}



}