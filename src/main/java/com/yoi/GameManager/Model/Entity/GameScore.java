package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "gamescore")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameScore {

    @Id
    @Column(name = "id_game_score",nullable = false)
    private UUID id_game_score;

    @Id
    @ManyToMany
    @JoinColumn(name = "id_owner",nullable = false)
    private UUID id_owner;

    @Id
    @ManyToMany
    @JoinColumn(name = "id_game",nullable = false)
    private UUID id_game;

    @Column(name = "personal_score",nullable = false)
    private BigDecimal personalScore;


}
