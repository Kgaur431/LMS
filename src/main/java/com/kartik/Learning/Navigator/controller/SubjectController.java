package com.kartik.Learning.Navigator.controller;

import com.kartik.Learning.Navigator.dto.SubjectRequestDTO;
import com.kartik.Learning.Navigator.dto.SubjectResponseDTO;
import com.kartik.Learning.Navigator.entities.Subject;
import com.kartik.Learning.Navigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@RequestBody SubjectRequestDTO subjectRequestDTO) {
        Subject subject = subjectService.createSubject(subjectRequestDTO);
        return ResponseEntity.ok(subjectService.getSubjectById(subject.getSubjectId()));
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectResponseDTO> getSubject(@PathVariable String subjectId) {
        return ResponseEntity.ok(subjectService.getSubjectById(subjectId));
    }
}
