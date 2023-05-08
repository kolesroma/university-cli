package com.botscrew.university.service;

import com.botscrew.university.entity.DegreeEntity;
import com.botscrew.university.entity.DepartmentEntity;
import com.botscrew.university.entity.LectorEntity;
import com.botscrew.university.exception.ExceptionSupplier;
import com.botscrew.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity findByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(ExceptionSupplier.DEPARTMENT_NOT_FOUND);
    }

    @Override
    public Map<DegreeEntity, List<LectorEntity>> getDegreeLectorsMap(String departmentName) {
        return findByName(departmentName)
                .getLectorList()
                .stream()
                .collect(Collectors.groupingBy(LectorEntity::getDegree));
    }
}
