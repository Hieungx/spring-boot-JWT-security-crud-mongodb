package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectDTO {
    @JsonProperty("SubjectCode")
    private String subjectCode;
    @JsonProperty("Username")
    private String username;
    @JsonProperty("Email")
    private String email;
}
