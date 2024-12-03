package com.kartik.Learning.Navigator.service;

import com.kartik.Learning.Navigator.dto.StudentRequestDTO;
import com.kartik.Learning.Navigator.dto.StudentResponseDTO;
import com.kartik.Learning.Navigator.entities.Student;
import com.kartik.Learning.Navigator.entities.Subject;
import com.kartik.Learning.Navigator.exception.ResourceNotFoundException;
import com.kartik.Learning.Navigator.repositories.StudentRepository;
import com.kartik.Learning.Navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // DTO-to-Entity mapping (RequestDTO -> Entity)
    public Student registerStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setRegistrationId(studentRequestDTO.getRegistrationId());
        student.setName(studentRequestDTO.getName());

        // Enroll student in subjects
        studentRequestDTO.getSubjectIds().forEach(subjectId -> {
            Subject subject = subjectRepository.findBySubjectId(subjectId);
            if (subject != null) {
                student.getSubjects().add(subject);
            }
        });

        return studentRepository.save(student);
    }

    // Entity-to-DTO mapping (Entity -> ResponseDTO)
    public StudentResponseDTO getStudentByRegistrationId(String registrationId) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByRegistrationId(registrationId));
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
            studentResponseDTO.setRegistrationId(student.getRegistrationId());
            studentResponseDTO.setName(student.getName());
            studentResponseDTO.setEnrolledSubjects(student.getSubjects().stream()
                    .map(subject -> subject.getName()).collect(Collectors.toSet()));
            return studentResponseDTO;
        }
        throw new ResourceNotFoundException("Student not found with registrationId: " + registrationId);
    }
}
