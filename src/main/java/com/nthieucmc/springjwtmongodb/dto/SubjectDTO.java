package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    @JsonProperty("subjectCode")
    private String subjectCode;
    @JsonProperty("subjectName")
    private String subjectName;
    @JsonProperty("credit")
    private String credit;
}
