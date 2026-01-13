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

    @PostMapping
    public Carta criarCarta(@RequestBody Carta carta) {
        return cartaService.criarCarta(carta);
    }

    @PutMapping("/{id}")
    public Carta atualiz(@PathVariable Long id, @RequestBody Carta carta) {
        return cartaService.atualizar(id, carta);
    }
    
    @DeleteMapping("/{id}")
    public void deletarCarta(@PathVariable Long id) {
        cartaService.deletar(id);
    }
}