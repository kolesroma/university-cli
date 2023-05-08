package com.botscrew.university.repository;

import com.botscrew.university.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {
}
