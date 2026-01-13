package com.montadeck.api.controller;

import com.montadeck.api.model.Carta;
import com.montadeck.api.service.CartaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    private final CartaService cartaService;

    public CartaController(CartaService cartaService){
        this.cartaService = cartaService;
    }

    @GetMapping
    public List<Carta> listarTodasCartas() {
        return cartaService.getAllCartas();
    }

    @GetMapping("/{id}")
    public Carta buscarPorId(@PathVariable Long id) {
        return cartaService.buscaPorId(id);
    }
}