package com.lab4.GTICS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "aerolinea")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaerolinea", nullable = false)
    private int idAerolinea;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String codigo;
}
