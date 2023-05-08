package com.botscrew.university.service;

import com.botscrew.university.entity.DegreeEntity;
import com.botscrew.university.entity.DepartmentEntity;
import com.botscrew.university.entity.LectorEntity;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    DepartmentEntity findByName(String name);
    Map<DegreeEntity, List<LectorEntity>> getDegreeLectorsMap(String departmentName);
}
