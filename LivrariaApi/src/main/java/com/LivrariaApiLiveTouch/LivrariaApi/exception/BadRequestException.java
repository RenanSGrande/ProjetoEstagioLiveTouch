package com.LivrariaApiLiveTouch.LivrariaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.util.function.Supplier;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException implements Serializable{

    public BadRequestException(String message) {
        super(message);
    }

}
