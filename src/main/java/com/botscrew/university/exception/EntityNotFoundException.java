package com.botscrew.university.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
    private final String message;
}