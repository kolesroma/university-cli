package com.botscrew.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lector")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class LectorEntity {
    @Id
    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private DegreeEntity degree;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "lectorList")
    private List<DepartmentEntity> departmentList;
}
