package com.yoi.GameManager.Model.Entity.JPA.PlayStation;

import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.PlayStationPropertyDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "game_property")
@IdClass(GamePropertyId.class)
@Data
public class GamePropertyPlayStation {

    @Id
    @Column(name = "account_id", length = 100)
    private String accountId;

    @Id
    @Column(name = "np_communication_id", length = 100)
    private String npCommunicationId;

    @Column(name = "trophy_gold")
    private Integer trophyGold;

    @Column(name = "trophy_silver")
    private Integer trophySilver;

    @Column(name = "trophy_bronze")
    private Integer trophyBronze;

    @Column(name = "trophy_total")
    private Integer trophyTotal;

    @Column(name = "percentage_progress", precision = 5, scale = 2)
    private BigDecimal percentageProgress;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    public GamePropertyPlayStation(PlayStationPropertyDTO dto) {
        this.accountId = dto.getAccountId();
        this.npCommunicationId = dto.getNpCommunicationId();

        // Extraer los trofeos del objeto anidado TrophyCounts
        if (dto.getTrophyProgress() != null) {
            this.trophyGold = dto.getTrophyProgress().getGold();
            this.trophySilver = dto.getTrophyProgress().getSilver();
            this.trophyBronze = dto.getTrophyProgress().getBronze();
            this.trophyTotal = dto.getTrophyProgress().getPlatinum(); // Ajusta si el total se calcula diferente
        }

        this.percentageProgress = dto.getPercentageProgress();
        this.lastUpdateTime = dto.getLastUpdateTime();
    }

}
