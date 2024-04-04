package org.example.relationsex1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiResponse;
import org.example.relationsex1.Model.Course;
import org.example.relationsex1.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(courseService.getAll());
    }
    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, @PathVariable Integer teacher_id ) {
        courseService.addCourse(course, teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course Added and Assigned"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid  Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course Deleted"));
    }
    @GetMapping("/name/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }
}
