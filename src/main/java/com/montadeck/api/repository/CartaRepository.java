package com.montadeck.api.repository;

import com.montadeck.api.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

}
