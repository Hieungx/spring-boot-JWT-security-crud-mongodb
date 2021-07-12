package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgrammeDTO {
    @JsonProperty("trainingProgrammeCode")
    private String trainingProgrammeCode;
    @JsonProperty("trainingProgrammeName")
    private String trainingProgrammeName;
    @JsonProperty("majorCodes")
    private List<String> majorCodes;
}
