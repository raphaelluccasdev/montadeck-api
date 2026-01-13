package com.montadeck.api.model;

import jakarta.persistence.*;
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

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(name = "mana_cost")
    private Integer manaCost;

    @Column(length = 1000)
    private String text;

    @Column(length = 30, nullable = false)
    private String rarity;

    @Column(length = 20, nullable = false)
    private String color;
}
