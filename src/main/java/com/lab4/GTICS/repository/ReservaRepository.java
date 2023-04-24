package com.lab4.GTICS.repository;

import com.lab4.GTICS.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) VALUES (now(), ?1, 'procesado', ?2, ?3)")
    void guardarReserva(float precio, int idUser, int idVuelo);
}
