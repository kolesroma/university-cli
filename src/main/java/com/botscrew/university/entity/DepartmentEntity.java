package com.botscrew.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "department")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DepartmentEntity {
    @Id
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "head_id")
    private LectorEntity head;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "lector_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id")
    )
    private List<LectorEntity> lectorList;
}
