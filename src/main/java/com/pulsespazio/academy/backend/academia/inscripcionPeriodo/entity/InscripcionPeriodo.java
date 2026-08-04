/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.alumna.entity.Alumna;
import com.pulsespazio.academy.backend.academia.periodo.entity.Periodo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "tbl_inscripcion_periodo",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_inscripcion_periodo",
            columnNames = {"id_alumna", "id_periodo"}
        )
    }
)
@Getter
@Setter
public class InscripcionPeriodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion_periodo")
    private Long idInscripcionPeriodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumna", nullable = false)
    private Alumna alumna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_periodo", nullable = false)
    private Periodo periodo;
}
