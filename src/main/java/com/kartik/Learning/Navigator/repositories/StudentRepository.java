package com.kartik.Learning.Navigator.repositories;

import com.kartik.Learning.Navigator.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRegistrationId(String registrationId);
}
