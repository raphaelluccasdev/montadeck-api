package com.montadeck.api.service.scryfall;

import com.montadeck.api.dto.ScryfallCardDTO;
import com.montadeck.api.model.Card;
import com.montadeck.api.service.CardService;
import com.montadeck.api.service.scryfall.ScryfallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards/scryfall")
public class ScryfallController {
    
    private final ScryfallService scryfallService;
    private final CardService cardService;
    
    public ScryfallController(ScryfallService scryfallService, CardService cardService) {
        this.scryfallService = scryfallService;
        this.cardService = cardService;
    }
    
    @GetMapping("/search")
    public ResponseEntity<ScryfallCardDTO> searchCard(@RequestParam String name) throws InterruptedException {
        ScryfallCardDTO card = scryfallService.searchCardByName(name);
        return ResponseEntity.ok(card);
    }
    
    @PostMapping("/import")
    public ResponseEntity<Card> importCard(@RequestParam String name) throws InterruptedException {
        ScryfallCardDTO dto = scryfallService.searchCardByName(name);
        Card card = scryfallService.convertToCard(dto);
        Card savedCard = cardService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }
}
