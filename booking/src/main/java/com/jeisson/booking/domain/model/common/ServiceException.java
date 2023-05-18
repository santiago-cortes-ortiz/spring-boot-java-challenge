package com.jeisson.booking.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ServiceException extends Exception{
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Exception exception){
        super(exception);
    }
    public ServiceException(String message, Exception e){
        super(message, e);
    }
}
