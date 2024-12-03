package com.kartik.Learning.Navigator.controller;

import com.kartik.Learning.Navigator.dto.ExamResponseDTO;
import com.kartik.Learning.Navigator.entities.Exam;
import com.kartik.Learning.Navigator.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/{examId}")
    public ResponseEntity<ExamResponseDTO> registerForExam(@PathVariable String examId, @RequestParam String registrationId) {
        Exam exam = examService.registerForExam(examId, registrationId);
        return ResponseEntity.ok(examService.getExamByExamId(exam.getExamId()));
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponseDTO> getExam(@PathVariable String examId) {
        return ResponseEntity.ok(examService.getExamByExamId(examId));
    }
}

