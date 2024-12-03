package com.kartik.Learning.Navigator.service;

import com.kartik.Learning.Navigator.dto.ExamResponseDTO;
import com.kartik.Learning.Navigator.entities.Exam;
import com.kartik.Learning.Navigator.entities.Student;
import com.kartik.Learning.Navigator.exception.BadRequestException;
import com.kartik.Learning.Navigator.exception.ResourceNotFoundException;
import com.kartik.Learning.Navigator.repositories.ExamRepository;
import com.kartik.Learning.Navigator.repositories.StudentRepository;
import com.kartik.Learning.Navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // Register student for the exam (after subject enrollment)
 //   @Transactional
    public Exam registerForExam(String examId, String registrationId) {
        Exam exam = examRepository.findByExamId(examId);
        if (exam == null) {
            throw new ResourceNotFoundException("Exam not found with examId: " + examId);
        }

        Student student = studentRepository.findByRegistrationId(registrationId);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with registrationId: " + registrationId);
        }

        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new BadRequestException("Student must be enrolled in the subject to register for the exam");
        }

        exam.getStudents().add(student);
        return examRepository.save(exam);
    }

    // Entity-to-DTO mapping (Entity -> ResponseDTO)
    public ExamResponseDTO getExamByExamId(String examId) {
        Exam exam = examRepository.findByExamId(examId);
        if (exam == null) {
            throw new ResourceNotFoundException("Exam not found with examId: " + examId);
        }

        ExamResponseDTO examResponseDTO = new ExamResponseDTO();
        examResponseDTO.setExamId(exam.getExamId());
        examResponseDTO.setSubjectName(exam.getSubject().getName());
        examResponseDTO.setEnrolledStudents(exam.getStudents().stream()
                .map(student -> student.getName()).collect(Collectors.toSet()));
        return examResponseDTO;
    }
}

