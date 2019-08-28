package com.tgp.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ServiceResponse<T> {
    private T object;
    private String message;
    private HttpStatus status;
}
