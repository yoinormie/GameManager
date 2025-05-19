package com.yoi.GameManager.Model.Entity.JPA.PlayStation;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "game_property")
@IdClass(GamePropertyId.class)
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

    // getters y setters
}
