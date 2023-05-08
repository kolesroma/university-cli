package com.botscrew.university.repository;

import com.botscrew.university.entity.DepartmentEntity;
import com.botscrew.university.entity.LectorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {
    Optional<DepartmentEntity> findByName(String name);

    @Query("select lec from LectorEntity lec where concat(lec.name, lec.surname) like concat('%', :keyword, '%')")
    List<LectorEntity> findByKeyword(@Param("keyword") String keyword);
}
