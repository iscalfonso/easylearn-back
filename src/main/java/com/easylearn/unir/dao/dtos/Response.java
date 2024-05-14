package com.easylearn.unir.dao.dtos;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response <T>{
    private boolean status;
    private T data;
    private String message;
    private List<String>errors;
    public Response(boolean status, T data) {
        this.status = status;
        this.data = data;
    }
    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(boolean status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }
}
