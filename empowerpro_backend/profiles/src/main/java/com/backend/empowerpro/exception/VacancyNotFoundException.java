package com.backend.empowerpro.exception;

public class VacancyNotFoundException extends RuntimeException{
    public VacancyNotFoundException(String message) {
        super(message);
    }
}
