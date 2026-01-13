package com.montadeck.api.service;

import com.montadeck.api.model.Card;
import com.montadeck.api.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card not found by id: " + id));
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(Long id, Card updateCard) {
        Card card = findById(id);
        card.setName(updateCard.getName());
        card.setType(updateCard.getType());
        card.setManaCost(updateCard.getManaCost());
        card.setText(updateCard.getText());
        card.setRarity(updateCard.getRarity());
        card.setColor(updateCard.getColor());
        return cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        Card card = findById(id);
        cardRepository.delete(card);
    }


}
