package com.opticus.opticusapp.helpers;

public class VisitNotFoundException extends RuntimeException {


    public VisitNotFoundException() {
    }

    public VisitNotFoundException(String message) {
        super(message);
    }

    public VisitNotFoundException(Throwable cause) {
        super(cause);
    }

    public VisitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VisitNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
