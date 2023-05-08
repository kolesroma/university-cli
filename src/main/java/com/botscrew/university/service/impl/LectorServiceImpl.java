package com.botscrew.university.service.impl;

import com.botscrew.university.entity.LectorEntity;
import com.botscrew.university.exception.ExceptionSupplier;
import com.botscrew.university.repository.LectorRepository;
import com.botscrew.university.service.LectorService;
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
