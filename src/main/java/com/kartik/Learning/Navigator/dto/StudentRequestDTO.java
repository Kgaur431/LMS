package com.kartik.Learning.Navigator.dto;

import java.util.Set;

public class StudentRequestDTO {
    private String registrationId;
    private String name;
    private Set<String> subjectIds;

    // Getters and Setters

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

    public Set<String> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(Set<String> subjectIds) {
        this.subjectIds = subjectIds;
    }
}

