package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nthieucmc.springjwtmongodb.models.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorDTO {
    @JsonProperty("majorCode")
    private String majorCode;
    @JsonProperty("majorName")
    private String majorName;
    @JsonProperty("departmentCode")
    private List<String> departmentCodes;
}
