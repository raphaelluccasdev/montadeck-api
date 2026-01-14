package com.montadeck.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 200, message = "Name must be between 1 and 200 characters")
    @Column(nullable = false, length = 200)
    private String name;

    @NotBlank(message = "Type is required")
    @Size(max = 50, message = "Type must not exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String type;

    @Min(value = 0, message = "Mana cost must be non-negative")
    @Column(name = "mana_cost")
    private Integer manaCost;

    @Size(max = 1000, message = "Text must not exceed 1000 characters")
    @Column(length = 1000)
    private String text;

    @NotBlank(message = "Rarity is required")
    @Size(max = 30, message = "Rarity must not exceed 30 characters")
    @Column(length = 30, nullable = false)
    private String rarity;

    @NotBlank(message = "Color is required")
    @Size(max = 20, message = "Color must not exceed 20 characters")
    @Column(length = 20, nullable = false)
    private String color;
}
