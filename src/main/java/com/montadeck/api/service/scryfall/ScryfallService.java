package com.montadeck.api.service.scryfall;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.montadeck.api.dto.ScryfallCardDTO;
import com.montadeck.api.model.Card;

@Service
public class ScryfallService {
    
private final RestTemplate restTemplate;
private final String SCRYFALL_API_URL = "https://api.scryfall.com/cards/named";

    public ScryfallService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ScryfallCardDTO searchCardByName(String cardName) throws InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MontaDeck/1.0");
        headers.set("Accept", "application/json");

        String url = SCRYFALL_API_URL + "?fuzzy=" + cardName;
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ScryfallCardDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ScryfallCardDTO.class
        );
        Thread.sleep(200);

        return response.getBody();
    }

    public Card convertToCard(ScryfallCardDTO dto) {
        Card card = new Card();
        card.setName(dto.getName());
        card.setType(dto.getTypeLine());
        card.setText(dto.getOracleText());
        card.setRarity(capitalizeFirstLetter(dto.getRarity()));
        card.setManaCost(parseManaCost(dto.getManaCost()));
        card.setColor(parseColors(dto.getColors()));
        return card;
    }

    private Integer parseManaCost(String manaCost) {
        if (manaCost == null || manaCost.isEmpty()) {
            return 0;
        }

        String cleaned = manaCost.replaceAll("[{}]", "");
        int totalCost = 0;

        for (char c : cleaned.toCharArray()) {
            if (Character.isDigit(c)) {
                totalCost += Character.getNumericValue(c);
            } else {
                totalCost += 1;
            }
        }
        return totalCost;
    }

    private String parseColors(List<String> colors) {
        if (colors == null || colors.isEmpty()) {
            return "Multicolor";
        }
        
        String colorCode = colors.get(0);
        return switch (colorCode) {
            case "W" -> "White";
            case "U" -> "Blue";
            case "B" -> "Black";
            case "R" -> "Red";
            case "G" -> "Green";
            default -> "Colorless";
        };
    }

    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

}
