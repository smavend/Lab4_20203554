package com.lab4.GTICS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo", nullable = false)
    private int idVuelo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(name = "fecha_salida",nullable = false)
    private Date fechaSalida;

    @Column(name = "fecha_llegada",nullable = false)
    private Date fechaLlegada;

    @Column(nullable = false)
    private int duracion;

    @Column(nullable = false)
    private float precio;

    @Column(name = "asientos_disponibles",nullable = false)
    private int asientosDisponibles;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea", nullable = false)
    private Aerolinea aerolinea;
}
