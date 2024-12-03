package com.kartik.Learning.Navigator.repositories;

import com.kartik.Learning.Navigator.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findByExamId(String examId);
}

