package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayStationGameDTO {
    private String npCommunicationId;
    private String gameTitle;
    private String platform;
    private Integer totalTrophiesGold;
    private Integer totalTrophiesSilver;
    private Integer totalTrophiesBronze;
    private Integer totalTrophiesTotal;

}
