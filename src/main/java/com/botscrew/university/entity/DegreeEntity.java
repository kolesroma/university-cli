package com.botscrew.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "degree")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DegreeEntity {
    @Id
    private Integer id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "degree")
    private List<LectorEntity> lectorList;
}
