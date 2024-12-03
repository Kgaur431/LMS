package com.kartik.Learning.Navigator.dto;

import java.util.Set;

public class StudentResponseDTO {
    private String registrationId;
    private String name;
    private Set<String> enrolledSubjects;

    // Getters and Setters

    public Set<String> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(Set<String> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
