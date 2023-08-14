package com.jeisson.booking.infraestructure.entry_point.common;

import com.jeisson.booking.domain.model.common.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceException {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity handleServiceException(ServiceException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
