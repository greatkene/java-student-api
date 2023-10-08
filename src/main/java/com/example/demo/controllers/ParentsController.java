package com.example.demo.controllers;

import com.example.demo.models.Parents;
import com.example.demo.models.Student;
import com.example.demo.services.ParentsService;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/parents")
public class ParentsController {
    private final ParentsService parentsService;
    private final StudentService studentService;

    public ParentsController(ParentsService parentsService, StudentService studentService) {
        this.parentsService = parentsService;
        this.studentService = studentService;
    }

    @PostMapping("/add/{studentId}")
    public Student addParentToStudent(@PathVariable Long studentId, @RequestBody Parents parent) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            student.setParents(parent);
            return student;
        } else {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }
    }
}
