package com.simplesolutions.medicinesmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(code = HttpStatus.CONFLICT)
@Getter
public class PatientAlreadyExistsException extends RuntimeException {
    private final Date timestamp;
    private final int status;
    public PatientAlreadyExistsException(String message) {
        super(message);
        this.timestamp = new Date();
        this.status = 409;
        setStackTrace(new StackTraceElement[0]);
    }
}

