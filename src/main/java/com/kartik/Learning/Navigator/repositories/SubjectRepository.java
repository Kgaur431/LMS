package com.kartik.Learning.Navigator.repositories;

import com.kartik.Learning.Navigator.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectId(String subjectId);
}
