package com.simplesolutions.medicinesmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PatientUpdateException extends RuntimeException {
    public PatientUpdateException(String message){
        super(message);
    }
}
