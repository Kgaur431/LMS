package com.kartik.Learning.Navigator.dto;

import java.util.Set;

public class SubjectResponseDTO {
    private String subjectId;
    private String name;
    private Set<String> enrolledStudents;

    // Getters and Setters

    public Set<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}

