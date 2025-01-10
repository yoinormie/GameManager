package com.yoi.GameManager.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameScoreDTO {
    private UUID id_game_score;
    private UUID id_owner;
    private UUID id_game;
    private BigDecimal personalScore;
}
