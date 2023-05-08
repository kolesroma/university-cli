package com.botscrew.university.service;

import com.botscrew.university.entity.LectorEntity;
import com.botscrew.university.exception.ExceptionSupplier;
import com.botscrew.university.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public LectorEntity findById(Integer id) {
        return lectorRepository.findById(id)
                .orElseThrow(ExceptionSupplier.LECTOR_NOT_FOUND);
    }
}
