package com.tgp.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEntity<T> {
    private T object;
    private String message;
    private ResponseStatus status;
}
