package com.rohit.academics.controller;

import com.rohit.academics.entity.Student;
import com.rohit.academics.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student/")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping("getstudentsbydomain/{domainId}")
    public ResponseEntity<List<Student>> getStudentsByDomain(@PathVariable int domainId) {
        try {
            List<Student> students = studentService.getStudentsByDomain(domainId);
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
