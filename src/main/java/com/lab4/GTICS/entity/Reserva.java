package com.lab4.GTICS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva", nullable = false)
    private int idReserva;

    @Column(name = "fecha_reserva",nullable = false)
    private Date fechaReserva;

    @Column(name = "precio_total",nullable = false)
    private float precioTotal;

    @Column(name = "estado_pago", nullable = false)
    private String estadoPago;

    @ManyToOne
    @JoinColumn(name = "user_iduser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vuelo_idvuelo", nullable = false)
    private Vuelo vuelo;
}
