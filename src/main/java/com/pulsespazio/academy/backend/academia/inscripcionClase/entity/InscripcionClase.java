/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.entity;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.clasePeriodo.entity.ClasePeriodo;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity.InscripcionPeriodo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "tbl_inscripcion_clase",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_inscripcion_clase",
            columnNames = {
                "id_inscripcion_periodo",
                "id_clase_periodo"
            }
        )
    }
)
@Getter
@Setter
public class InscripcionClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion_clase")
    private Long idInscripcionClase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_inscripcion_periodo",
        nullable = false
    )
    private InscripcionPeriodo inscripcionPeriodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_clase_periodo",
        nullable = false
    )
    private ClasePeriodo clasePeriodo;
}
