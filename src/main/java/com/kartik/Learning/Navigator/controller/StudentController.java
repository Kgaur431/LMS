package com.kartik.Learning.Navigator.controller;

import com.kartik.Learning.Navigator.dto.StudentRequestDTO;
import com.kartik.Learning.Navigator.dto.StudentResponseDTO;
import com.kartik.Learning.Navigator.entities.Student;
import com.kartik.Learning.Navigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        Student student = studentService.registerStudent(studentRequestDTO);
        return ResponseEntity.ok(studentService.getStudentByRegistrationId(student.getRegistrationId()));
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable String registrationId) {
        return ResponseEntity.ok(studentService.getStudentByRegistrationId(registrationId));
    }
}

