package org.example.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Turma turma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Professor professor;
}
