package com.montadeck.api.controller;

import com.montadeck.api.model.Card;
import com.montadeck.api.service.CardService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> listAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable Long id) {
        return cardService.findById(id);
    }

    @PostMapping
    public Card createCard(@Valid@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @Valid @RequestBody Card card) {
        return cardService.updateCard(id, card);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}