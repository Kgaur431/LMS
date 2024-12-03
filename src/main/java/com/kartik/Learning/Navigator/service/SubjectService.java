package com.kartik.Learning.Navigator.service;

import com.kartik.Learning.Navigator.dto.SubjectRequestDTO;
import com.kartik.Learning.Navigator.dto.SubjectResponseDTO;
import com.kartik.Learning.Navigator.entities.Subject;
import com.kartik.Learning.Navigator.exception.ResourceNotFoundException;
import com.kartik.Learning.Navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // DTO-to-Entity mapping (RequestDTO -> Entity)
    public Subject createSubject(SubjectRequestDTO subjectRequestDTO) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectRequestDTO.getSubjectId());
        subject.setName(subjectRequestDTO.getName());
        return subjectRepository.save(subject);
    }

    // Entity-to-DTO mapping (Entity -> ResponseDTO)
    public SubjectResponseDTO getSubjectById(String subjectId) {
        Subject subject = subjectRepository.findBySubjectId(subjectId);
        if (subject == null) {
            throw new ResourceNotFoundException("Subject not found with subjectId: " + subjectId);
        }

        SubjectResponseDTO subjectResponseDTO = new SubjectResponseDTO();
        subjectResponseDTO.setSubjectId(subject.getSubjectId());
        subjectResponseDTO.setName(subject.getName());
        subjectResponseDTO.setEnrolledStudents(subject.getStudents().stream()
                .map(student -> student.getName()).collect(Collectors.toSet()));
        return subjectResponseDTO;
    }
}
