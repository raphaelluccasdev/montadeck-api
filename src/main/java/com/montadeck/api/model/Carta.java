package com.montadeck.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartas")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(name = "custo_mana")
    private Integer custoMana;

    @Column(length = 1000)
    private String texto;

    @Column(length = 30, nullable = false)
    private String raridade;

    @Column(length = 20, nullable = false)
    private String cor;
}
