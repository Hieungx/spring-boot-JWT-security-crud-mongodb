package com.nthieucmc.springjwtmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("Username")
    private String username;
    @JsonProperty("Email")
    private String email;
}
