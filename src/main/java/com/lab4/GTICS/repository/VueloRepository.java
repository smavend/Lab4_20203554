package com.lab4.GTICS.repository;

import com.lab4.GTICS.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository  extends JpaRepository<Vuelo,Integer> {
}
