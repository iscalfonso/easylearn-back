package com.easylearn.unir.dao.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto <T>{
    public ResponseDto(boolean status, String message){
        this.status = status;
        this.message = message;
    }
    public ResponseDto(boolean status, T data){
        this.status = status;
        this.data = data;
    }
    private boolean status;
    private T data;
    private String message;
}
