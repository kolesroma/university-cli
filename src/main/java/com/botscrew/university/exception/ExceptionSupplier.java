package com.botscrew.university.exception;

import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class ExceptionSupplier {
    public static final Supplier<EntityNotFoundException> LECTOR_NOT_FOUND =
            () -> new EntityNotFoundException("Lector not found");
    public static final Supplier<EntityNotFoundException> DEPARTMENT_NOT_FOUND =
            () -> new EntityNotFoundException("Department not found");
}
