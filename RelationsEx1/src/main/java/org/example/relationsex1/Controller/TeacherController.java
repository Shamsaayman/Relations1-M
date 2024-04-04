package org.example.relationsex1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiResponse;
import org.example.relationsex1.Model.Teacher;
import org.example.relationsex1.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher( @PathVariable Integer id, @RequestBody @Valid Teacher teacher ){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher( @PathVariable Integer id ){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Deleted"));
    }
    @GetMapping("/getdetails/{id}")
    public ResponseEntity getTeacherDetails( @PathVariable Integer id ){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }

}
