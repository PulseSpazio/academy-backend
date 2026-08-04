/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clasePeriodo.entity;

import com.pulsespazio.academy.backend.academia.clases.entity.Clase;
import com.pulsespazio.academy.backend.academia.periodo.entity.Periodo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Dany
 */
@Entity
@Table(
    name = "tbl_clase_periodo",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_clase_periodo",
            columnNames = {"id_clase", "id_periodo"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClasePeriodo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase_periodo")
    private Long idClasePeriodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_clase",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_clase_periodo_clase")
    )
    private Clase clase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_periodo",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_clase_periodo_periodo")
    )
    private Periodo periodo;
}
