package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayStationPropertyDTO {

    private String accountId;
    private String npCommunicationId;
    private TrophyCounts trophyProgress;
    private BigDecimal percentageProgress;
    private LocalDateTime lastUpdateTime;


}

