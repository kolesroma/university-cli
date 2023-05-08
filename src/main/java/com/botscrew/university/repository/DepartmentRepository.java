package com.botscrew.university.repository;

import com.botscrew.university.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {
    Optional<DepartmentEntity> findByName(String name);
}
