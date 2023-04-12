package com.example.gamificationaccesa.domain.validators;

public interface Validator<T> {
        void validate(T entity) throws ValidatorException;
    }
