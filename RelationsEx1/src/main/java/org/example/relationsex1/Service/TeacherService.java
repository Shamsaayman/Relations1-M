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
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id , Teacher teacher){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("Teacher not found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacherDetails(Integer id){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("Teacher not found");
        }
        return t;
    }


}
