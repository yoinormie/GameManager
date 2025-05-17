package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PlayStationPropertyDTO {

    private String accountId;
    private String npCommunicationId;
    private Integer trophyGold;
    private Integer trophySilver;
    private Integer trophyBronze;
    private Integer trophyTotal;
    private BigDecimal percentageProgress;
    private LocalDateTime lastUpdateTime;

}
