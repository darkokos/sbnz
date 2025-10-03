package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.ErrorMessageDto;
import com.ftn.sbnz.service.exceptions.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler({RestException.class})
    protected ResponseEntity<ErrorMessageDto> handleRestException(RestException e) {
        return new ResponseEntity<>(new ErrorMessageDto(e.getMessage()), e.getStatus());
    }
}
