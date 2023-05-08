package com.botscrew.university.exception;

import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class ExceptionSupplier {
    public static final Supplier<EntityNotFoundException> LECTOR_NOT_FOUND =
            () -> new EntityNotFoundException("Lector not found");
}
