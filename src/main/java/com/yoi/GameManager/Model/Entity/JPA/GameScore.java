package com.yoi.GameManager.Model.Entity.JPA;

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


    @ManyToOne
    @JoinColumn(name = "owner", foreignKey = @ForeignKey(name = "id_owner"))
    private Owner owner;


    @ManyToOne
    @JoinColumn(name = "game", foreignKey = @ForeignKey(name = "id_game"))
    private Game game;

    @Column(name = "personal_score",nullable = false)
    private BigDecimal personalScore;


}
