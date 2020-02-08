package com.opticus.opticusapp.helpers;

public class SpecialistNotFoundException extends RuntimeException {


    public SpecialistNotFoundException() {
    }

    public SpecialistNotFoundException(String message) {
        super(message);
    }

    public SpecialistNotFoundException(Throwable cause) {
        super(cause);
    }

    public SpecialistNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpecialistNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
