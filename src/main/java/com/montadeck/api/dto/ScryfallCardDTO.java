package com.montadeck.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScryfallCardDTO {
    
    private String id;
    
    private String name;
    
    @JsonProperty("mana_cost")
    private String manaCost;
    
    @JsonProperty("type_line")
    private String typeLine;
    
    @JsonProperty("oracle_text")
    private String oracleText;
    
    private String rarity;
    
    private List<String> colors;
}