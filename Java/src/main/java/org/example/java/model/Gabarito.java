package org.example.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Gabarito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    private CorrecaoProva correcaoProva;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Prova prova;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Aluno aluno;

    @ElementCollection
    private List<String> respostas;
}
