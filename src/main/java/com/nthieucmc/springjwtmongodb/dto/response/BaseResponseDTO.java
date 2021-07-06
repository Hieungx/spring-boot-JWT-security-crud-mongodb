package com.nthieucmc.springjwtmongodb.dto.response;

import com.nthieucmc.springjwtmongodb.constant.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private String code;
    private String message;

    public BaseResponseDTO() {
        this.code = ErrorCode.SUCCESS;
        this.message = "Success!!!";
    }

    public BaseResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponseDTO(String message){
        this.code = ErrorCode.SUCCESS;
        this.message = message;
    }
}
