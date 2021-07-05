package com.nthieucmc.springjwtmongodb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private String code;
    private String message;

    public CustomException(String code){
        this.code = code;
        this.message = "";
    }
}
