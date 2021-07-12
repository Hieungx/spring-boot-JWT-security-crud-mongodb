package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @JsonProperty("departmentCode")
    private String departmentCode;
    @JsonProperty("departmentName")
    private String departmentName;
    @JsonProperty("departmentLead")
    private String departmentLead;
}
