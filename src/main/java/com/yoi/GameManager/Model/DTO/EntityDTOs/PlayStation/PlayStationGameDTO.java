package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayStationGameDTO {
    private String npCommunicationId;
    private String gameTitle;
    private String platform;
    private TrophyCounts totalTrophies;
}

