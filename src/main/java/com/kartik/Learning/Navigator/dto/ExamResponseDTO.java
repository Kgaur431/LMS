package com.kartik.Learning.Navigator.dto;

import java.util.Set;

public class ExamResponseDTO {
    private String examId;
    private String subjectName;
    private Set<String> enrolledStudents;

    // Getters and Setters

    public Set<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
