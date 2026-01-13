package com.montadeck.api.service;

import com.montadeck.api.model.Carta;
import com.montadeck.api.repository.CartaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    private final CartaRepository cartaRepository;

    public CartaService(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }

    public List<Carta> getAllCartas() {
        return cartaRepository.findAll();
    }

    public Carta buscaPorId(Long id) {
        return cartaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Carta não encontrada com id: " + id));
    }
    
}
